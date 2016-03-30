package org.smart.framework.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart.framework.aop.proxy.Proxy;
import org.smart.framework.aop.proxy.ProxyChain;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;

/**
 * 切面代理
 * Created by wangrl on 2016/3/28.
 */
public abstract class AspectProxy implements Proxy {
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public Object doProxy(ProxyChain proxyChain) throws Throwable {
        Object result = null;

        Class<?> cls = proxyChain.getTargetClass();
        Method method = proxyChain.getTargetMethod();
        Object[] params = proxyChain.getMethodParams();

        begin();

        try {
            if (intercept(cls, method, params)) {
                before(cls, method, params);
                result = proxyChain.doProxyChain();
                after(cls, method, params, result);
            } else {
                result = proxyChain.doProxyChain();
            }
        } catch (Throwable throwable) {
            logger.error("proxy failure", throwable);
            error(cls, method, params, throwable);
            throw throwable;
        } finally {
            end();
        }
        return result;
    }

    public void error(Class<?> cls, Method method, Object[] params, Throwable throwable) {

    }

    public void end() {

    }

    public void after(Class<?> cls, Method method, Object[] params, Object result) {

    }

    public void before(Class<?> cls, Method method, Object[] params) {

    }

    public boolean intercept(Class<?> cls, Method method, Object[] params) {
        return true;
    }

    protected void begin(){

    }
}
