package org.mule.modules.novapmsensor;

import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.param.MetaDataKeyParam;
import org.mule.api.annotations.param.MetaDataKeyParamAffectsType;
import org.mule.modules.novapmsensor.config.ConnectorConfig;
import org.mule.modules.novapmsensor.metadata.NovaPmSensorData;

import com.fazecast.jSerialComm.*;
import org.mule.api.annotations.MetaDataKeyRetriever;
import org.mule.api.annotations.MetaDataRetriever;
import org.mule.api.annotations.MetaDataScope;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mule.common.metadata.MetaDataKey;
import org.mule.common.metadata.MetaData;

@Connector(name="nova-pm-sensor", friendlyName="Nova PM Sensor")
@MetaDataScope(NovaPmSensorData.class)
public class NovaPmSensorConnector {

    @Config
    ConnectorConfig config;

    /**
     * Read a single sensor reading from the Nova PM Sensor
     *
     * @return Get reading from the Nova PM Sensor
     */
	@Processor(friendlyName = "Read Sensor Data")
    public Map<String, Object> readSensor(@MetaDataKeyParam String entityType) {
    	SerialPort comPort = SerialPort.getCommPort(config.getSerialPortDevice());
		comPort.setComPortParameters(9600, 8, SerialPort.ONE_STOP_BIT, SerialPort.NO_PARITY);
		String data = "";
		Map<String, Object> entityData = new HashMap<String, Object>();
		byte[] readBuffer = new byte[9];
		
		try {
			comPort.openPort();
			comPort.readBytes(readBuffer, readBuffer.length);
			data = byteArrayToHex(readBuffer);
			int pm25Low = readBuffer[2] & 0xff;
			int pm25High = readBuffer[3] & 0xff;
			int pm10Low = readBuffer[4] & 0xff;
			int pm10High = readBuffer[5] & 0xff;

			entityData.put("pm25", ((pm25High*256)+pm25Low)/10.0); 
			entityData.put("pm10", ((pm10High*256)+pm10Low)/10.0);
			entityData.put("hex", data);
			
			//Debug code: Print actual data read from Connector
			System.out.println("Read:" + data);
		} catch (Exception e) { e.printStackTrace(); }
		comPort.closePort();
		return entityData;
    }

    public ConnectorConfig getConfig() {
        return config;
    }

    public void setConfig(ConnectorConfig config) {
        this.config = config;
    }
	
	public static String byteArrayToHex(byte[] a) {
		   StringBuilder sb = new StringBuilder(a.length * 2);
		   for(byte b: a)
		      sb.append(String.format("%02x", b & 0xff));
		   return sb.toString();
		}
}