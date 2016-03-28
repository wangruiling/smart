package org.smart.framework.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import java.util.List;

/**
 * 代理管理器
 * Created by wangrl on 2016/3/28.
 */
public class ProxyManager {
    /**
     * 使用CGLib提供的Enhancer#create方法来创建代理对象，将intercept的参数传入ProxyChain的构造器中即可。
     * @param targetClass
     * @param proxyList
     * @param <T>
     * @return
     */
    public static <T> T createProxy(final Class<?> targetClass, final List<Proxy> proxyList) {
        return (T) Enhancer.create(targetClass, (MethodInterceptor) (targetObject, targetMethod, objects, methodProxy) -> new ProxyChain(targetClass, targetObject, targetMethod, methodProxy, objects, proxyList).doProxyChain());
    }
}
