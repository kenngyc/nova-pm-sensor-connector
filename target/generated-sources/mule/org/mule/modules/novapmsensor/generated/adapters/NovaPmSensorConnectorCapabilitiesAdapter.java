
package org.mule.modules.novapmsensor.generated.adapters;

import javax.annotation.Generated;
import org.mule.api.devkit.capability.Capabilities;
import org.mule.api.devkit.capability.ModuleCapability;
import org.mule.modules.novapmsensor.NovaPmSensorConnector;


/**
 * A <code>NovaPmSensorConnectorCapabilitiesAdapter</code> is a wrapper around {@link NovaPmSensorConnector } that implements {@link org.mule.api.Capabilities} interface.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.0", date = "2016-10-14T09:29:40+08:00", comments = "Build UNNAMED.2793.f49b6c7")
public class NovaPmSensorConnectorCapabilitiesAdapter
    extends NovaPmSensorConnector
    implements Capabilities
{


    /**
     * Returns true if this module implements such capability
     * 
     */
    public boolean isCapableOf(ModuleCapability capability) {
        if (capability == ModuleCapability.LIFECYCLE_CAPABLE) {
            return true;
        }
        return false;
    }

}
