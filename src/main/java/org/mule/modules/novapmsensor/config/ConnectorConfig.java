package org.mule.modules.novapmsensor.config;

import org.mule.api.annotations.components.Configuration;
import org.mule.api.annotations.display.FriendlyName;
import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.param.Default;

@Configuration(friendlyName = "Configuration")
public class ConnectorConfig {

    /**
     * Configure the Nova PM Sensor
     */
    @Configurable
    @FriendlyName("Sensor device location: i.e. /dev/ttyUSB0")
    @Default("/dev/ttyUSB0")
    private String serialPortDevice;

    /**
     * Set Nova PM Sensor serial port device
     *
     * @param Nova PM Sensor serial port device
     */
    public void setSerialPortDevice(String serialPortDevice) {
        this.serialPortDevice = serialPortDevice;
    }

    /**
     * Get Nova PM Sensor serial port device
     */
    public String getSerialPortDevice() {
        return this.serialPortDevice;
    }
}