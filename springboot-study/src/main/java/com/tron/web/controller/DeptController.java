package com.tron.web.controller;


import com.tron.web.service.impl.DeptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tron
 * @since 2019-10-19
 */
@RestController
@RequestMapping("/web/dept")
public class DeptController {
    @Autowired
    private DeptServiceImpl deptService;

    @RequestMapping("/test")
    public Object test() {
        return deptService.getById(1);
    }

}
