package ch.x42.osgi.weavinghook;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Instrument a given class to log all its method calls */
class LogMethodCallsVisitor implements ClassVisitor {

    private final Logger log = LoggerFactory.getLogger(getClass());
    
    LogMethodCallsVisitor(ClassWriter cw) {

    }
    
    @Override
    public void visit(int arg0, int arg1, String arg2, String arg3,
            String arg4, String[] arg5) {
    }

    @Override
    public AnnotationVisitor visitAnnotation(String arg0, boolean arg1) {
        return null;
    }

    @Override
    public void visitAttribute(Attribute arg0) {
    }

    @Override
    public void visitEnd() {
    }

    @Override
    public FieldVisitor visitField(int arg0, String arg1, String arg2,
            String arg3, Object arg4) {
        return null;
    }

    @Override
    public void visitInnerClass(String arg0, String arg1, String arg2, int arg3) {
    }

    @Override
    public MethodVisitor visitMethod(int access,
            String name,
            String desc,
            String signature,
            String[] exceptions) {
        log.info("visitMethod {} / {}", name, signature);
        return null;
    }

    @Override
    public void visitOuterClass(String arg0, String arg1, String arg2) {
    }

    @Override
    public void visitSource(String arg0, String arg1) {
    }
}