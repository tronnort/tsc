
package com.tron.web.controller;

import com.tron.web.entity.User;
import com.tron.web.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author tron
 * @since 2019-10-27
 */
@RestController
@RequestMapping("/web/user")
@Api(tags = "用户表操作")
public class UserController {
    @Autowired
    private IUserService userService;

    @ApiOperation(value = "根据Id查询用户表" ,notes = "返回数据{id:主键 username:账号 name:姓名 age:年龄 balance:余额 }")
    @RequestMapping(value ="/{id}",method = RequestMethod.GET)
    public Object getUserById(
        @ApiParam(name="id",value="主键",example = "1",required=true)
        @PathVariable String id){
        return userService.getById(id);
    }
    @ApiOperation(value = "添加用户表",notes = "参数参考{id:主键 username:账号 name:姓名 age:年龄 balance:余额 },id自动生成")
    @RequestMapping(value ="/add",method = RequestMethod.POST)
    public Object addUser(
        @ApiParam(name="user",value="{id:主键 username:账号 name:姓名 age:年龄 balance:余额 }",example = "{}",required=true)
        User user) {
    String id = UUID.randomUUID().toString().replace("-", "");
        user.setId(id);
        userService.save(user);
        return id;
    }

    @ApiOperation(value = "更新用户表" ,notes = "参数参考{id:主键 username:账号 name:姓名 age:年龄 balance:余额 }")
    @RequestMapping(value ="/update",method = RequestMethod.POST)
    public Object updateUser(
        @ApiParam(name="user",value="{id:主键 username:账号 name:姓名 age:年龄 balance:余额 }",example = "{}",required=true)
        User user) {
        boolean update = userService.updateById(user);
        return update;
    }

    @ApiOperation(value = "删除用户表")
    @RequestMapping(value ="/delete",method = RequestMethod.POST)
    public Object deleteUser(
        @ApiParam(name="ids",value="主键列表",example = "{ids:1,2,3}",required=true)
        String[] ids) {
        boolean remove = userService.removeByIds(Arrays.asList(ids));
        return remove;
    }


    @ApiOperation(value = "query查询用户表")
    @RequestMapping(value ="/query/{current}/{size}",method = RequestMethod.POST)
    public Object queryUser(
        @ApiParam(name="current",value="页码",example = "1",required=true)
        @PathVariable Long current,
        @ApiParam(name="size",value="最大显示条数",example = "10",required=true)
        @PathVariable Long size,
        @ApiParam(name="conditions",value="查询条件",example = "{}",required=true)
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
