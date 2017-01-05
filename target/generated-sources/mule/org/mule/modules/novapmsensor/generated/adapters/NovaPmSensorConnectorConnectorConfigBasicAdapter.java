
package org.mule.modules.novapmsensor.generated.adapters;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.mule.common.DefaultResult;
import org.mule.common.Result;
import org.mule.common.metadata.ConnectorMetaDataEnabled;
import org.mule.common.metadata.DefaultMetaDataKey;
import org.mule.common.metadata.MetaData;
import org.mule.common.metadata.MetaDataFailureType;
import org.mule.common.metadata.MetaDataKey;
import org.mule.common.metadata.key.property.TypeDescribingProperty;
import org.mule.common.metadata.property.StructureIdentifierMetaDataModelProperty;
import org.mule.devkit.internal.metadata.MetaDataGeneratorUtils;
import org.mule.modules.novapmsensor.NovaPmSensorConnector;
import org.mule.modules.novapmsensor.config.ConnectorConfig;
import org.mule.modules.novapmsensor.metadata.NovaPmSensorData;


/**
 * A <code>NovaPmSensorConnectorConnectorConfigBasicAdapter</code> is a wrapper around {@link NovaPmSensorConnector } that represents the strategy {@link ConnectorConfig }
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.0", date = "2016-10-14T09:29:40+08:00", comments = "Build UNNAMED.2793.f49b6c7")
public class NovaPmSensorConnectorConnectorConfigBasicAdapter
    extends NovaPmSensorConnectorProcessAdapter
    implements ConnectorMetaDataEnabled
{


    @Override
    public Result<List<MetaDataKey>> getMetaDataKeys() {
        try {
            List<MetaDataKey> gatheredMetaDataKeys = new ArrayList<MetaDataKey>();
            NovaPmSensorData novaPmSensorData = new NovaPmSensorData();
            gatheredMetaDataKeys.addAll(MetaDataGeneratorUtils.fillCategory(novaPmSensorData.getMetadataKeys(), "NovaPmSensorData"));
            return new DefaultResult<List<MetaDataKey>>(gatheredMetaDataKeys, (Result.Status.SUCCESS));
        } catch (Exception e) {
            return new DefaultResult<List<MetaDataKey>>(null, (Result.Status.FAILURE), "There was an error retrieving the metadata keys from service provider after acquiring connection, for more detailed information please read the provided stacktrace", MetaDataFailureType.ERROR_METADATA_KEYS_RETRIEVER, e);
        }
    }

    @Override
    public Result<MetaData> getMetaData(MetaDataKey metaDataKey) {
        try {
            MetaData metaData = null;
            TypeDescribingProperty property = metaDataKey.getProperty(TypeDescribingProperty.class);
            String category = ((DefaultMetaDataKey) metaDataKey).getCategory();
            if (category!= null) {
                if (category.equals("NovaPmSensorData")) {
                    NovaPmSensorData novaPmSensorData = new NovaPmSensorData();
                    metaData = novaPmSensorData.getNovaPmSensorData(metaDataKey);
                } else {
                    throw new Exception(((("Invalid key type. There is no matching category for ["+ metaDataKey.getId())+"]. All keys must contain a category with any of the following options:[NovaPmSensorData]")+((", but found ["+ category)+"] instead")));
                }
            } else {
                throw new Exception((("Invalid key type. There is no matching category for ["+ metaDataKey.getId())+"]. All keys must contain a category with any of the following options:[NovaPmSensorData]"));
            }
            metaData.getPayload().addProperty(new StructureIdentifierMetaDataModelProperty(metaDataKey, false));
            return new DefaultResult<MetaData>(metaData);
        } catch (Exception e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), MetaDataGeneratorUtils.getMetaDataException(metaDataKey), MetaDataFailureType.ERROR_METADATA_RETRIEVER, e);
        }
    }

}
