package com.tron.spring.injectbean;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.Set;


//通过ConfigForInjectBean类@ComponentScan包扫描时，可以自定义过滤规则
//@ComponentScan.Filter(type = FilterType.CUSTOM ,classes = {MyTypeFilter.class} )
public class MyTypeFilter implements TypeFilter {
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {

        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        Set<String> annotationTypes = annotationMetadata.getAnnotationTypes();
        for (String type :
                annotationTypes) {
            System.out.println("---------------获取当前环境中注解信息-----------" + type);
        }


        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        String className = classMetadata.getClassName();
        System.out.println("---------------获取当前处理的类名-----------" +className);

        Resource resource = metadataReader.getResource();
        URI uri = resource.getURI();
        URL url = resource.getURL();
        System.out.println("---------------获取当前处理的类路径-----------"+url);

        //过滤包扫描的类,true表示过滤    不能过滤掉@Configuration  和 @Bean注入的类
        return false;
    }
}
