package org.smart.framework.helper;

import org.smart.framework.annotation.Controller;
import org.smart.framework.annotation.Service;
import org.smart.framework.helper.ConfigHelper;
import org.smart.framework.util.ClassUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * 类操作助手
 *
 * @author: wangrl
 * @Date: 2016-03-09 23:42
 */
public final class ClassHelper {
    /**
     * 定义类集合(用于存放所加载的类)
     */
    private static final Set<Class<?>> CLASS_SET;

    static {
        String basePackage = ConfigHelper.getAppBasePackage();
        CLASS_SET = ClassUtil.getClassSet(basePackage);
    }

    /**
     * 获取应用包名下的所有类
     * @return
     */
    public static Set<Class<?>> getClassSet() {
        return CLASS_SET;
    }

    /**
     * 获取应用包名下的所有Service类
     * @return
     */
    public static Set<Class<?>> getServiceClassSet() {
        //Set<Class<?>> classSet = new HashSet<>();
        //for (Class<?> cls : CLASS_SET) {
        //    if (cls.isAnnotationPresent(Service.class)) {
        //        classSet.add(cls);
        //    }
        //}
        //return classSet;

        return getClassSet4Annotation(Service.class);
    }

    /**
     * 获取应用包名下的所有Controller类
     * @return
     */
    public static Set<Class<?>> getControllerClassSet() {
        //Set<Class<?>> classSet = new HashSet<>();
        //for (Class<?> cls : CLASS_SET) {
        //    if (cls.isAnnotationPresent(Controller.class)) {
        //        classSet.add(cls);
        //    }
        //}
        //return classSet;

        return getClassSet4Annotation(Controller.class);
    }

    private static Set<Class<?>> getClassSet4Annotation(Class classZ) {
        //return CLASS_SET.stream().filter(cls -> cls.isAnnotationPresent(classZ)).collect(Collectors.toSet());
        Set<Class<?>> classSet = new HashSet<>();
        for (Class<?> cls : CLASS_SET) {
            if (cls.isAnnotationPresent(classZ)) {
                classSet.add(cls);
            }
        }
        return classSet;
    }

    /**
     * 获取应用包名下的所有Bean类(包括：Service、Controller等)
     * @return
     */
    public static Set<Class<?>> getBeanClassSet() {
        Set<Class<?>> beanClassSet = new HashSet<>();
        beanClassSet.addAll(getServiceClassSet());
        beanClassSet.addAll(getControllerClassSet());
        return beanClassSet;
    }
}
