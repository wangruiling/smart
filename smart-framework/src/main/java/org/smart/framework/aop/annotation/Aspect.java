package org.smart.framework.aop.annotation;

import java.lang.annotation.*;

/**
 * 切面注解
 * Created by wangrl on 2016/3/27.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
    /**
     * 注解
     * @return
     */
    Class<? extends Annotation> value();
}
