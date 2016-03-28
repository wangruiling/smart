package org.smart.framework.aop;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;

/**
 * cglib动态代理
 * Created by wangrl on 2016/3/23.
 */
public class CGLibDynamicProxy implements MethodInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static CGLibDynamicProxy instance = new CGLibDynamicProxy();

    @Override
    public Object intercept(Object target, Method method, Object[] objects, MethodProxy proxy) throws Throwable {
        before();
        Object result = proxy.invokeSuper(target, objects);
        after();
        return result;
    }

    private void after() {
        logger.info("后增强");
    }

    private void before() {
        logger.info("前增强");
    }

    private CGLibDynamicProxy() { }

    @SuppressWarnings("unchecked")
    public <T> T getProxy(Class<T> cls) {
        return (T) Enhancer.create(cls, this);
    }

    public static CGLibDynamicProxy getInstance() {
        return instance;
    }
}
