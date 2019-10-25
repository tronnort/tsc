
package com.tron.web.controller;

import com.tron.web.entity.User;
import com.tron.web.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.*;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tron
 * @since 2019-10-26
 */
@RestController
@RequestMapping("/web/user")
public class UserController {
    @Autowired
    private IUserService userService;


    @RequestMapping("/{id}")
    public Object getUserById(@PathVariable String id){
        return userService.getById(id);
    }

    @RequestMapping("/add")
    public Object addUser(User user) {
    String id = UUID.randomUUID().toString().replace("-", "");
        user.setId(id);
        userService.save(user);
        return id;
    }

    @RequestMapping("/update")
    public Object updateUser(User user) {
        boolean update = userService.updateById(user);
        return update;
    }

    @RequestMapping("/delete")
    public Object deleteUser(String[] ids) {
        boolean remove = userService.removeByIds(Arrays.asList(ids));
        return remove;
    }

    @RequestMapping("/query/{current}/{size}")
    public Object queryUser(@PathVariable Long current,
                            @PathVariable Long size,
                            @RequestBody Map<String,String> conditions) {
        List<User> list = new ArrayList<>();
        long defaultCurrent = (current != null && current > 0 ) ? current : 1;
        long defaultSize = (size != null && size > 0 ) ? size : 20;
        Page<User> page = new Page<>();
        page.setCurrent(defaultCurrent);   //当前页码
        page.setSize(defaultSize);     //显示条数
        QueryWrapper queryWrapper = null;
        if (!conditions.isEmpty()) {
            queryWrapper = new QueryWrapper<User>();
            Set<Map.Entry<String, String>> entrySet = conditions.entrySet();
            Iterator<Map.Entry<String, String>> iterator = entrySet.iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> next = iterator.next();
                queryWrapper.eq(next.getKey(), next.getValue());
            }
        }
        if (null != queryWrapper) {
            IPage<User> iPage = userService.page(page,queryWrapper);
            list = iPage.getRecords();
        }else {
            IPage<User> iPage = userService.page(page);
            list = iPage.getRecords();
        }
        return list;
    }

}
