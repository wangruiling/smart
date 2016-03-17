package org.smart.framework.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 类型转换工具类
 * @author: wangrl
 * @Date: 2016-03-07 23:46
 */
public class CastUtil {
    public static int castInt(Object object) {
        return castInt(object, 0);
    }

    public static int castInt(Object object, int defaultValue) {
        int value = defaultValue;
        if (object != null) {
            String strValue = castString(object);
            if (StringUtils.isNotBlank(strValue)) {
                value = Integer.parseInt(strValue);
            }
        }
        return value;
    }

    /**
     * 转换为String类型
     * @param object
     * @return
     */
    public static String castString(Object object) {
        return castString(object, "");
    }

    public static String castString(Object object, String defaultValue) {
        return object != null ? String.valueOf(object) : defaultValue;
    }

    public static boolean castBoolean(Object obj) {
        return castBoolean(obj, false);
    }

    public static boolean castBoolean(Object obj, boolean defaultValue) {
        boolean value = defaultValue;
        if (obj != null) {
            value = Boolean.parseBoolean(castString(obj));
        }
        return value;
    }
}
