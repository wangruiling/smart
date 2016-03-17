package org.smart.framework.helper;

import org.smart.framework.ConfigConstant;
import org.smart.framework.util.PropertiesUtil;

import java.util.Properties;

/**
 * 属性文件助手类
 *
 * @author: wangrl
 * @Date: 2016-03-07 22:49
 */
public final class ConfigHelper {
    private static final Properties CONFIG_PROPS = PropertiesUtil.loadProps(ConfigConstant.CONFIG_FILE);

    /**
     * 获取JDBC驱动
     * @return
     */
    public static String getJdbcDriver() {
        return PropertiesUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_DRIVER);
    }

    /**
     * 获取JDBC URL
     * @return
     */
    public static String getJdbcUrl() {
        return PropertiesUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_URL);
    }

    /**
     * 获取JDBC 连接的用户名
     * @return
     */
    public static String getJdbcUsername() {
        return PropertiesUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_USERNAME);
    }

    /**
     * 获取JDBC 连接的密码
     * @return
     */
    public static String getJdbcPassword(){
        return PropertiesUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_PASSWORD);
    }

    /**
     * 获取应用基础包名
     * @return
     */
    public static String getAppBasePackage() {
        return PropertiesUtil.getString(CONFIG_PROPS, ConfigConstant.APP_BASE_PACKAGE);
    }


    /**
     * 获取应用JSP路径，默认"/WEB-INF/view/"
     * @return
     */
    public static String getAppJspPath() {
        return PropertiesUtil.getString(CONFIG_PROPS, ConfigConstant.APP_JSP_PATH, "/WEB-INF/view/");
    }

    /**
     * 获取应用静态资源路径
     * @return
     */
    public static String getAppAssetPath() {
        return PropertiesUtil.getString(CONFIG_PROPS, ConfigConstant.APP_ASSET, "/asset/");
    }
}
