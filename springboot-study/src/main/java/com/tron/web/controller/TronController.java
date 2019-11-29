package com.tron.web.controller;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.autoconfigure.data.RepositoryType;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

@Component
public class TronController implements BeanFactoryAware, ImportBeanDefinitionRegistrar, ResourceLoaderAware,
        EnvironmentAware {
    private BeanFactory beanFactory;
    private  Environment environment;
    private ResourceLoader resourceLoader;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
        RepositoryType repositoryType = RepositoryType.valueOf(environment
                .getProperty(String.format("spring.data.%s.repositories.type", "AUTO"),
                        "auto")
                .toUpperCase(Locale.ENGLISH));
        String property = environment.getProperty("spring.template.provider.cache");
        System.out.println(property);
        System.out.println(environment.getProperty("spring.datasource.schema",String.class));
        System.out.println(environment.getProperty("spring.datasource.initialization-mode"));
        System.out.println("-----------------");
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        RootBeanDefinition definition = new RootBeanDefinition();
        registry.registerBeanDefinition("Tron", definition);
        System.out.println("-----------------------");
    }
}
