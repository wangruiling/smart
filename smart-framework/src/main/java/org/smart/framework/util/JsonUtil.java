package org.smart.framework.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    /**
     * 将POJO转换为json
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> String toJson(T obj) {
        try {
            return OBJECT_MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            logger.error("convert POJO to JSON failute", e);
            throw new RuntimeException(e);
        }
    }


    /**
     * 将json转换为POJO
     * @param json
     * @param <T>
     * @return
     */
    public static <T> T fromJson(String json, Class<T> type) {
        try {
            return OBJECT_MAPPER.readValue(json, type);
        } catch (Exception e) {
            logger.error("convert JSON to POJO failute", e);
            throw new RuntimeException(e);
        }
    }
}
