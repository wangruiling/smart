package org.smart.framework.aop;

/**
 * Created by wangrl on 2016/3/23.
 */
public class GreetingImpl implements Greeting {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello ! " + name);
    }
}
