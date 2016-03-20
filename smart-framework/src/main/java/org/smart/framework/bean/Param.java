package org.smart.framework.bean;

import org.smart.framework.util.CastUtil;

import java.util.Map;

/**
 * 请求参数对象
 * Created by wangrl on 2016/3/20.
 */
public class Param {
    private Map<String,Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    /**
     * 根据参数名获取long型参数值
     * @param paramname
     * @return
     */
    public long getLong(String paramname) {
        return CastUtil.castLong(paramMap.get(paramname));
    }

    /**
     * 获取所有参数信息
     * @return
     */
    public Map<String, Object> getMap() {
        return paramMap;
    }
}
