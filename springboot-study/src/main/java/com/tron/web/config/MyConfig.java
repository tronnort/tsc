package com.tron.web.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;


@Configuration
@EnableConfigurationProperties
@EnableTransactionManagement
@EnableAspectJAutoProxy
@MapperScan(basePackages = {"com.tron.web.mapper","com.tron.web.twodatasources","com.tron.web.mybatis","com.tron.web.mybatis.mapper"})
@EnableSwagger2
public class MyConfig {

    /**
     *
     * myBaitsPlus分页插件配置
     *
     * */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
        // paginationInterceptor.setOverflow(false);
        // 设置最大单页限制数量，默认 500 条，-1 不受限制
        // paginationInterceptor.setLimit(500);
        return paginationInterceptor;
    }


    /**
     * 创建一个Docket对象
     * 调用select()方法，
     * 生成ApiSelectorBuilder对象实例，该对象负责定义外漏的API入口
     * 通过使用RequestHandlerSelectors和PathSelectors来提供Predicate，在此我们使用any()方法，将所有API都通过Swagger进行文档管理
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
//                .apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.tron.web.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //标题
                .title("API文档")
                //简介
                .description("")
                //服务条款
                .termsOfServiceUrl("")
                //作者个人信息
                .contact(new Contact("tron","","tron@outlook.com"))
                //版本
                .version("1.0")
                .build();
    }


    /**
     *
     * 自定义拦截器
     *
     * */
    @Bean
    public MyFilter myFilter() {
        return new MyFilter();
    }


    /**
     *
     * fastJson 序列化配置
     *
     * */
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteNullStringAsEmpty);
        ArrayList<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        fastJsonHttpMessageConverter.setSupportedMediaTypes(mediaTypes);
        return new HttpMessageConverters(fastJsonHttpMessageConverter);
    }

}
