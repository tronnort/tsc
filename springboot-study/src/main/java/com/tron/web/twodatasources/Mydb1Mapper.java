package com.tron.web.twodatasources;

//import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tron.web.entity.User;
import org.springframework.stereotype.Component;

/**
 * @Description
 *
 * 动态数据源配置，yml配置参见application.yml test环境
 *         <!-- 依赖引入 -->
 *         <!--<dependency>-->
 *         <!--<groupId>com.baomidou</groupId>-->
 *         <!--<artifactId>dynamic-datasource-spring-boot-starter</artifactId>-->
 *         <!--<version>2.5.4</version>-->
 *         <!--</dependency>-->
 *
 *                 注解@DS
 * @auther tron
 * @create 2019-11-01
 */

@Component
//@DS("mydb1")
public interface Mydb1Mapper extends BaseMapper<User> {
}
