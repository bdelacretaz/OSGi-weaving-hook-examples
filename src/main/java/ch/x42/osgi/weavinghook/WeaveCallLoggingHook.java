package ch.x42.osgi.weavinghook;

import org.osgi.framework.hooks.weaving.WeavingHook;
import org.osgi.framework.hooks.weaving.WovenClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Start simple...just log the weave call */
public class WeaveCallLoggingHook implements WeavingHook {

    private final Logger log = LoggerFactory.getLogger(getClass());
    
    @Override
    public void weave(WovenClass wovenClass) {
        log.info("weave called for {}", wovenClass.getClassName());
    }
}