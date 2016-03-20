package org.smart.framework.bean;

/**
 * 返回数据对象
 * Created by wangrl on 2016/3/20.
 */
public class Data {
    /**
     * 模型数据
     */
    private Object model;

    public Data(Object model) {
        this.model = model;
    }

    public Object getModel() {
        return model;
    }
}
