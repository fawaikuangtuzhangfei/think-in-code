package com.fun.oom;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 操作字节码生成大量的类--->测试方法区
 * jdk7
 *  VM Args：-XX:PermSize=10M -XX:MaxPermSize=10M
 *  Caused by: java.lang.OutOfMemoryError: PermGen space
 *
 *
 * @author Java男朋友
 * @date 2021-08-29 23:52
 */
public class JavaMethodAreaOOM {
    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o, args);
                }

            });
            enhancer.create();
        }
    }
    static class OOMObject {
    }
}

