package org.smart.framework.util;

import org.junit.Test;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
//import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by wangrl on 2016/3/14.
 */
public class ReflectionUtilTest {
    @Test
    public void testMethodType() {
        MethodType mt = MethodType.methodType(void.class, int.class, double.class);
        System.out.println(mt);
        System.out.println(mt.wrap());
        System.out.println(mt.unwrap());
        System.out.println(mt.generic());
        System.out.println(mt.toMethodDescriptorString());
        System.out.println(mt.erase());
    }

    @Test
    public void testNewInstance() throws Exception {
        String str = (String) ReflectionUtil.newInstance(String.class);
//        assertThat(str instanceof String);
    }

    @Test
    public void testInvokeMethod() throws Throwable {
        MethodHandle methodHandle = ReflectionUtil.makeMh();
        Object result = ReflectionUtil.invokeMethod(methodHandle, null);
        System.out.println(result);
    }

    class Person {
        private String name;
        private int age;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}