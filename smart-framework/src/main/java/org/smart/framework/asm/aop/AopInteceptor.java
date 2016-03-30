package org.smart.framework.asm.aop;

/**
 * 要修改的方法中，准备添加的我们自己的代码逻辑
 * http://blog.csdn.net/catoop/article/details/50629921
 * Created by wangrl on 2016/3/25.
 */
public class AopInteceptor {
    public static void before(){
        System.out.println(".......before().......");
    }

    public static void after(){
        System.out.println(".......after().......");
    }

}
