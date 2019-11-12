package com.tron.spring.injectbean;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;


//通过ConfigForInjectBean类@Import({SixthWay.class}) 先导入ImportBeanDefinitionRegistrar实现类
//这种方式对比第五中方式有个好处可以自定义bean的名称
public class SixthWay implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean pink = registry.containsBeanDefinition("importBeanDefinitionRegistrarBeanForSixthWay");
        if (!pink) {
            RootBeanDefinition beanDefinition = new RootBeanDefinition(ImportBeanDefinitionRegistrarBeanForSixthWay.class);
            registry.registerBeanDefinition("importBeanDefinitionRegistrarBeanForSixthWay",beanDefinition);
        }
    }
}
