package com.tron.spring.injectbean;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;



//通过ConfigForInjectBean类@Import({FifthWay.class}) 先导入ImportSelector实现类
//selectImports方法返回数组中的全类名就能被装配到容器中
public class FifthWay implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.tron.spring.injectbean.ImportSelectorBeanForFifthWay"};
    }
}
