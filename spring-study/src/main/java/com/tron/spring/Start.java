package com.tron.spring;

import com.tron.spring.config.MyConfig;
import com.tron.spring.util.MyUtil;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Start {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        //通过包扫描的形式装配进带有注解的bean
        printBeanNames(context);

        //import导入的类，类名是全路径
        MyUtil myUtil = (MyUtil) context.getBean("com.tron.spring.util.MyUtil");
        myUtil.test();
    }

    private static void printBeanNames(AnnotationConfigApplicationContext context) {
        String[] definitionNames = context.getBeanDefinitionNames();
        for (int i = 0; i < definitionNames.length; i++) {
            System.out.println(definitionNames[i]);
        }
    }


}
