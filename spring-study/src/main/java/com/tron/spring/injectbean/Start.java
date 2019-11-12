package com.tron.spring.injectbean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

import java.util.Arrays;

public class Start {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigForInjectBean.class);
        //校验装配方法一
        assertHasBean(context, "firstWay");
        //校验装配方法二
        assertHasBean(context, "secondWay");
        //校验装配方法三
        assertHasBean(context, "thirdWay");
        //校验装配方法四
        assertHasBean(context, "com.tron.spring.injectbean.FourthWay");
        //校验装配方法五
        assertHasBean(context, "com.tron.spring.injectbean.ImportSelectorBeanForFifthWay");
        //校验装配方法六
        assertHasBean(context,"importBeanDefinitionRegistrarBeanForSixthWay");
        //校验装配方法七
        assertHasBean(context,"seventhWay");

        //装配时装配工厂类，就可以通过实际的类型获取到bean
        BeanForSeventhWay bean = context.getBean(BeanForSeventhWay.class);
        System.out.println(bean);
    }

    private static void assertHasBean(ApplicationContext context, String beanName) {
        String[] definitionNames = context.getBeanDefinitionNames();
        boolean anyMatch = Arrays.stream(definitionNames).anyMatch(s -> s.equals(beanName));
        Assert.isTrue(anyMatch,"容器中没有"+beanName);
    }
}
