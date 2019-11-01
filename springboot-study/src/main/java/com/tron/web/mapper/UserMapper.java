package com.tron.web.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.tron.web.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author tron
 * @since 2019-10-27
 */
@Component
public interface UserMapper extends BaseMapper<User> {
    User tronGet(@Param(Constants.WRAPPER) Wrapper wrapper);
}
