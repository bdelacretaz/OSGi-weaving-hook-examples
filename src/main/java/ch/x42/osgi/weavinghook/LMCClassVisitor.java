package ch.x42.osgi.weavinghook;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/** Instrument a given class to log all its method calls */
class LMCClassVisitor extends ClassVisitor {

    private final ClassWriter cw;
    
    LMCClassVisitor(ClassWriter cw) {
        super(Opcodes.ASM4, cw);
        this.cw = cw;
    }
    
    @Override
    public MethodVisitor visitMethod(int access,
            String name,
            String desc,
            String signature,
            String[] exceptions) {
        return new LMCMethodVisitor(cw, access, name);
    }
}