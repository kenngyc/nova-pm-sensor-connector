package org.mule.modules.novapmsensor.metadata;

import java.util.ArrayList;
import java.util.List;

import org.mule.api.annotations.MetaDataKeyRetriever;
import org.mule.api.annotations.MetaDataRetriever;
import org.mule.api.annotations.components.MetaDataCategory;
import org.mule.common.metadata.DefaultMetaData;
import org.mule.common.metadata.DefaultMetaDataKey;
import org.mule.common.metadata.MetaData;
import org.mule.common.metadata.MetaDataKey;
import org.mule.common.metadata.MetaDataModel;
import org.mule.common.metadata.builder.DefaultMetaDataBuilder;
import org.mule.common.metadata.datatype.DataType;

@MetaDataCategory
public class NovaPmSensorData {

	@MetaDataKeyRetriever
	public List<MetaDataKey> getMetadataKeys() {
		List<MetaDataKey> entities = new ArrayList<MetaDataKey>();
		entities.add(new DefaultMetaDataKey("SensorData","Sensor Data"));
		return entities;  }
	
	/**
	 * Get MetaData given a key
	 */
	@MetaDataRetriever
	public MetaData getNovaPmSensorData(MetaDataKey entityKey) throws Exception {
		 if ("SensorData".equals(entityKey.getId())) {
			MetaDataModel sensorDataModel =  new DefaultMetaDataBuilder().createDynamicObject("SensorData")
	                .addSimpleField("pm25", DataType.DOUBLE)
	                .addSimpleField("pm10", DataType.DOUBLE)
	                .addSimpleField("hex", DataType.STRING)
	                .build();
	        return new DefaultMetaData(sensorDataModel);
		 }
		 throw new RuntimeException(String.format("This entity %s is not supported",entityKey.getId()));
	}
}
