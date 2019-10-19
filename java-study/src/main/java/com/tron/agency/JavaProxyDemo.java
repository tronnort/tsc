package com.tron.agency;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JavaProxyDemo {
    static interface IServer {

        public void say();

        public void talk();
    }

    static class realService implements IServer{

        @Override
        public void say() {
            System.out.println("realService  say----------------------");
        }

        @Override
        public void talk() {
            System.out.println("realService  talk----------------------");
        }
    }

    static class SimpleInvocationHandler implements InvocationHandler {
        private  Object realObj;

        SimpleInvocationHandler(Object realObj) {
            this.realObj = realObj;
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("invoke start---------------------");
            System.out.println(method.getName());
            Object invoke = method.invoke(realObj, args);
            System.out.println("invoke over------------------");
            return invoke;
        }
    }

    static <T> T getProxy(Class<T> interfacesClazz, InvocationHandler invocationHandler) {
        T t = (T) Proxy.newProxyInstance(interfacesClazz.getClassLoader(), new Class[]{interfacesClazz}, invocationHandler);
        return t;
    }

    public static void main(String[] args) {
        realService realService = new realService();
        IServer proxy = getProxy(IServer.class,new SimpleInvocationHandler(realService));
        proxy.say();
        proxy.talk();
    }

}
