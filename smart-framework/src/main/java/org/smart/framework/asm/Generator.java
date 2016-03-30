package org.smart.framework.asm;

import com.sun.xml.internal.ws.org.objectweb.asm.ClassAdapter;
import jdk.internal.org.objectweb.asm.Opcodes;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * 将集成上面定义的 ClassAdapter，ClassReader和 ClassWriter产生修改后的 Account类文件
 * Created by wangrl on 2016/3/26.
 */
public class Generator {
    /**
     * 执行完这段程序后，我们会得到一个新的 Account.class 文件
     * @throws Exception
     */
    public static void generator() throws Exception {
        ClassReader cr = new ClassReader("org/smart/framework/asm/Account");
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        ClassVisitor classVisitor = new AddSecurityCheckClassAdapter(Opcodes.ASM5, cw);
        cr.accept(classVisitor, ClassReader.SKIP_DEBUG);
        byte[] data = cw.toByteArray();
        File file = new File("Account.class");
        FileOutputStream fout = new FileOutputStream(file);
        fout.write(data);
        fout.close();
    }

    public static void main(String[] args) throws Exception {
        generator();
        Account account = new Account();
        account.operation();
    }

}
