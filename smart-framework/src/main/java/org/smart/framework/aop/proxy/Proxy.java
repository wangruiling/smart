package org.smart.framework.aop.proxy;

/**
 * 代理接口
 * Created by wangrl on 2016/3/27.
 */
public interface Proxy {
    /**
     * 执行链式代理
     * @param proxyChain
     * @return
     */
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
