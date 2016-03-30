package org.smart.framework.helper;

import org.smart.framework.annotation.Controller;
import org.smart.framework.annotation.Service;
import org.smart.framework.helper.ConfigHelper;
import org.smart.framework.util.ClassUtil;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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

        return getClassSetByAnnotation(Service.class);
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

        return getClassSetByAnnotation(Controller.class);
    }

    /**
     * 获取应用包名下带有某注解的所有类
     * @param annotationClass
     * @return
     */
    public static Set<Class<?>> getClassSetByAnnotation(Class<? extends Annotation> annotationClass) {
        //return CLASS_SET.stream().filter(cls -> cls.isAnnotationPresent(classZ)).collect(Collectors.toSet());
        return CLASS_SET.stream().filter(cls -> cls.isAnnotationPresent(annotationClass)).collect(Collectors.toSet());
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

    /**
     * 获取应用包名下某父类(或接口)的所有子类(或实现)
     * @param superClass
     * @return
     */
    public static Set<Class<?>> getClassSetBysuper(Class<?> superClass) {
//        Set<Class<?>> classSet = new HashSet<>();
//        for (Class<?> cls : CLASS_SET) {
//            if (superClass.isAssignableFrom(cls) && !superClass.equals(cls)) {
//                classSet.add(cls);
//            }
//        }
//        return classSet;
        return CLASS_SET.stream().filter(cls -> superClass.isAssignableFrom(cls) && !superClass.equals(cls)).collect(Collectors.toSet());
    }


}
