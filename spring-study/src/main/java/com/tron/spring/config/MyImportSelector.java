package com.tron.spring.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

//@Component    加其他注解无用，只能在@Configuration的配置类中import进去才能进方法
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.tron.spring.util.Black"};
    }
}
