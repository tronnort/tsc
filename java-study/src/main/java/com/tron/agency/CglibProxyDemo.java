package com.tron.agency;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyDemo {
    static class RealService {
        public void say() {
            System.out.println("RealService say-------------------");
        }
    }

    static class SimpleInterceptor implements MethodInterceptor {
        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("invoke--------------------");
            System.out.println(method.getName());
            Object invokeSuper = methodProxy.invokeSuper(o, objects);
            return invokeSuper;
        }
    }

    static <T> T getProxy(Class<T> clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new SimpleInterceptor());
        return (T) enhancer.create();
    }

    public static void main(String[] args) {
        RealService proxy = getProxy(RealService.class);
        proxy.say();
    }
}
