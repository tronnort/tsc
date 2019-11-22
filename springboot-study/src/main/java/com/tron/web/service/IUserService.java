package com.tron.web.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.tron.web.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;




/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author tron
 * @since 2019-10-27
 */
public interface IUserService extends IService<User> {
    void say(Wrapper<User> wrapper);
}
