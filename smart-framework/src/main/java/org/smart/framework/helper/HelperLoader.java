package org.smart.framework.helper;

import org.smart.framework.util.ClassUtil;

/**
 * 加载相应的Helper
 * Created by wangrl on 2016/3/20.
 */
public final class HelperLoader {
    public static void init() {
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };

        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName());
        }
    }
}
