package com.tron.web.twodatasources;

//import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tron.web.entity.User;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @auther tron
 * @create 2019-11-01
 */

@Component
//@DS("mydb2")
public interface Mydb2Mapper extends BaseMapper<User> {
}
