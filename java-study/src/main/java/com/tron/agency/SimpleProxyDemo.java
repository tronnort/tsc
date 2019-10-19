package com.tron.agency;

//静态代理
public class SimpleProxyDemo {
    static interface IServer {
        public void sayHello();
    }

    static class RealService implements IServer{
        @Override
        public void sayHello() {
            System.out.println("RealService----sayHello");
        }
    }

    static class ProxyService implements IServer {
        private IServer realService;

        ProxyService(IServer realService) {
            this.realService = realService;
        }

        @Override
        public void sayHello() {
            System.out.println("ProxyService---------sayHello");
            realService.sayHello();
        }

        public static void main(String[] args) {
            RealService realService = new RealService();
            ProxyService proxyService = new ProxyService(realService);
            proxyService.sayHello();
        }
    }
}
