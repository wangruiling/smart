package org.smart.framework.util;

import org.junit.Test;
import org.smart.framework.helper.ClassHelper;

import java.util.Set;

/**
 * Created by wrl on 2016/3/10.
 */
public class ClassHelperTest {

    @Test
    public void testGetClassSet() throws Exception {
        Set<Class<?>> classSet = ClassHelper.getClassSet();
        for (Class<?> cls : classSet) {
            System.out.println(cls.getName());
        }
    }

    @Test
    public void testGetServiceClassSet() throws Exception {

    }

    @Test
    public void testGetControllerClassSet() throws Exception {

    }

    @Test
    public void testGetBeanClassSet() throws Exception {

    }
}