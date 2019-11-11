package com.tron.spring.config;

import com.tron.spring.bean.MyBean;
import com.tron.spring.otherbean.MyOtherBean;
import com.tron.spring.otherbean.MyOtherService;
import com.tron.spring.util.MyUtil;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Service;

@Configuration
/**
 *包扫描的形式导入bean
 * */
@ComponentScan(basePackages = {"com.tron.spring.config","com.tron.spring.bean", "com.tron.spring.otherbean"},
        excludeFilters = {
                //排除@Service标注的类
                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Service.class}),
                //安装class类过滤
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {MyOtherService.class}),
                //自定义过滤规则
                @ComponentScan.Filter(type = FilterType.CUSTOM ,classes = {MyTypeFilter.class} )
        }
)
/**
 * 导入第三方包的组件
 * */
@Import(value = {MyUtil.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
public class MyConfig {

    /**
     *
     * 默认注入到容器的名词是myBean，即方法名。可以在@Bean()中自定义
     * 默认单实例，获取到的列是相等的。可以在@Scope()指定
     *     String SCOPE_SINGLETON = "singleton";
     *     String SCOPE_PROTOTYPE = "prototype";
     *
     * */
    @Bean
    @Scope
    public MyBean myBean() {
        return new MyBean();
    }


    /**
     * 按照条件注册bean
     */

    @Bean(initMethod = "init",destroyMethod = "dest")
    @Conditional(MyConditional.class)
    public MyBean myTestBean() {
        return new MyBean();
    }
}
