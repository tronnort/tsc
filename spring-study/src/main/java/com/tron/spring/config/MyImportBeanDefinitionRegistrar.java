package com.tron.spring.config;

import com.tron.spring.util.Pink;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean pink = registry.containsBeanDefinition("pink");
        if (!pink) {
            RootBeanDefinition beanDefinition = new RootBeanDefinition(Pink.class);
            registry.registerBeanDefinition("pink",beanDefinition);
        }
    }
}
