package com.tron.web.service.impl;

import com.tron.web.entity.User;
import com.tron.web.mapper.UserMapper;
import com.tron.web.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tron
 * @since 2019-10-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
