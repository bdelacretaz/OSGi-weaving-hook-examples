package ch.x42.osgi.weavinghook;

import java.util.ArrayList;
import java.util.List;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.framework.hooks.weaving.WeavingHook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Activator implements BundleActivator {

    private final List<ServiceRegistration<?>> regs = new ArrayList<ServiceRegistration<?>>();
    private final Logger log = LoggerFactory.getLogger(getClass());
    
    @Override
    public void start(BundleContext context) throws Exception {
        addHook(context, new WeaveCallLoggingHook());
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        for(ServiceRegistration<?> reg : regs) {
            reg.unregister();
        }
        regs.clear();
    }
    
    private void addHook(BundleContext context, WeavingHook h) {
        log.info("Registering WeavingHook {}", h);
        regs.add(context.registerService(WeavingHook.class.getName(), h, null));
    }

}
