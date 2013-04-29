package ch.x42.osgi.weavinghook;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Instrument a given class to log all its method calls */
class LMCMethodVisitor extends MethodVisitor {

    private final Logger log = LoggerFactory.getLogger(getClass());
    
    private final String name;
    
    LMCMethodVisitor(ClassWriter cw, int access, String name) {
        super(Opcodes.ASM4);
        this.name = name;
    }

    @Override
    public void visitCode() {
        super.visitCode();
        log.info("Visiting code of {}", name);
    }
}