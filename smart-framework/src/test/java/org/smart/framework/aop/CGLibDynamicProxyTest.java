package org.smart.framework.aop;

import org.junit.Test;

/**
 * Created by wangrl on 2016/3/23.
 */
public class CGLibDynamicProxyTest {

    @Test
    public void testCGlib() {
        Greeting greeting = CGLibDynamicProxy.getInstance().getProxy(GreetingImpl.class);
        greeting.sayHello("Jack");
    }
}