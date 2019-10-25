package com.tron.web.controller;


import com.tron.web.entity.User;
import com.tron.web.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tron
 * @since 2019-10-25
 */
@RestController
@RequestMapping("/web/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return  iUserService.getById(id);
    }

}
