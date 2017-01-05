
package org.mule.modules.novapmsensor.generated.adapters;

import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.novapmsensor.NovaPmSensorConnector;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * A <code>NovaPmSensorConnectorProcessAdapter</code> is a wrapper around {@link NovaPmSensorConnector } that enables custom processing strategies.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.0", date = "2016-10-14T09:29:40+08:00", comments = "Build UNNAMED.2793.f49b6c7")
public class NovaPmSensorConnectorProcessAdapter
    extends NovaPmSensorConnectorLifecycleInjectionAdapter
    implements ProcessAdapter<NovaPmSensorConnectorCapabilitiesAdapter>
{


    public<P >ProcessTemplate<P, NovaPmSensorConnectorCapabilitiesAdapter> getProcessTemplate() {
        final NovaPmSensorConnectorCapabilitiesAdapter object = this;
        return new ProcessTemplate<P,NovaPmSensorConnectorCapabilitiesAdapter>() {


            @Override
            public P execute(ProcessCallback<P, NovaPmSensorConnectorCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
                throws Exception
            {
                return processCallback.process(object);
            }

            @Override
            public P execute(ProcessCallback<P, NovaPmSensorConnectorCapabilitiesAdapter> processCallback, Filter filter, MuleMessage message)
                throws Exception
            {
                return processCallback.process(object);
            }

        }
        ;
    }

}
