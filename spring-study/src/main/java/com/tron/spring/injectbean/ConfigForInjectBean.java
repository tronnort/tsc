package com.tron.spring.injectbean;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScans(
        @ComponentScan(basePackages = {"com.tron.spring.injectbean"}
//                ,
//                excludeFilters = {
//                        //排除@Service标注的类
//                        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Service.class}),
//                        //安装class类过滤
//                        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {MyOtherService.class}),
//                        //自定义过滤规则
//                        @ComponentScan.Filter(type = FilterType.CUSTOM ,classes = {MyTypeFilter.class} )
//                }
        )
)
@Import({FourthWay.class,FifthWay.class,SixthWay.class})
public class ConfigForInjectBean {

    /**
     *
     * 默认注入到容器的名词是myBean，即方法名。可以在@Bean()中自定义
     * 默认单实例，获取到的列是相等的。可以在@Scope()指定
     *     String SCOPE_SINGLETON = "singleton";
     *     String SCOPE_PROTOTYPE = "prototype";
     *
     * */


    @Bean
    public FirstWay firstWay() {
        return new FirstWay();
    }

    @Bean
    @Conditional(ConditionForSecondWay.class)
    public SecondWay secondWay() {
        return new SecondWay();
    }

    //此bean是工厂bean，获取的是工厂生产的对象
    @Bean
    public SeventhWay seventhWay() {
        return new SeventhWay();
    }
}
