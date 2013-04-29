package ch.x42.osgi.weavinghook;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.osgi.framework.hooks.weaving.WeavingHook;
import org.osgi.framework.hooks.weaving.WovenClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Instrument code from specific classes to
 *  log all method calls */
public class LogMethodCallsHook implements WeavingHook {

    private final Logger log = LoggerFactory.getLogger(getClass());
    
    @Override
    public void weave(WovenClass wovenClass) {
        if(isInstrumented(wovenClass.getClassName())) {
            log.info("Instrumenting {}", wovenClass.getClassName());
            final ClassReader cr = new ClassReader(wovenClass.getBytes());
            final ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
            final ClassVisitor v = new LMCClassVisitor(cw);
            cr.accept(v, 0);
            wovenClass.setBytes(cw.toByteArray());
        }
    }
    
    /** True if class having className should be instrumented */
    private boolean isInstrumented(String className) {
        return className.contains("people");
    }
}