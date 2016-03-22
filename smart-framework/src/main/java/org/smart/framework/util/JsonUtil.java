package org.smart.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

/**
 * JSON工具类
 * Created by wangrl on 2016/3/22.
 */
public final class JsonUtil {
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
}
