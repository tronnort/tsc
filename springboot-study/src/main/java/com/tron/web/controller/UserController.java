
package com.tron.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tron.web.common.BaseController;
import com.tron.web.entity.User;
import com.tron.web.service.IUserService;
import com.tron.web.utils.QueryWrapperFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author tron
 * @since 2019-11-15
 */
@RestController
@Validated
@RequestMapping("/web/user")
@Api(tags = "用户表操作")
public class UserController extends BaseController {
    @Autowired
    private IUserService userService;


    /**
     * 根据id查找
     *
     * @param id 主键id
     * @return FinalResult
     */
    @ApiOperation(value = "根据Id查询用户表", notes = "返回数据{id:主键 username:账号 name:姓名 age:年龄 balance:余额 }")
    @GetMapping("/{id}")
    public FinalResult<User> getUserById(
            @ApiParam(name = "id", value = "主键", required = true)
            @PathVariable String id) {
        User user = userService.getById(id);
        return buildFinalResult(user);
    }


    /**
     * 新增方法
     *
     * @param user 实体类
     * @return FinalResult
     */
    @ApiOperation(value = "添加用户表", notes = "参数参考{id:主键 username:账号 name:姓名 age:年龄 balance:余额 },id自动生成")
    @PostMapping("/add")
    public FinalResult<String> addUser(
            @ApiParam(name = "user", value = "{id:主键 username:账号 name:姓名 age:年龄 balance:余额 }", required = true)
            @Valid
            @RequestBody User user) {
        String id = UUID.randomUUID().toString().replace("-", "");
        user.setId(id);
        userService.save(user);
        return buildFinalResult(id);
    }


    /**
     * 修改方法
     *
     * @param user 实体类
     * @return FinalResult
     */
    @ApiOperation(value = "更新用户表", notes = "参数参考{id:主键 username:账号 name:姓名 age:年龄 balance:余额 }")
    @PostMapping("/update")
    public FinalResult<Boolean> updateUser(
            @ApiParam(name = "user", value = "{id:主键 username:账号 name:姓名 age:年龄 balance:余额 }", required = true)
            @Valid
            @RequestBody User user) {
        boolean update = userService.updateById(user);
        return buildFinalResult(update);
    }


    /**
     * 删除方法
     *
     * @param ids 主键列表
     * @return FinalResult
     */
    @ApiOperation(value = "删除用户表", notes = "参数参考[1,2,3]")
    @PostMapping("/delete")
    public FinalResult<Boolean> deleteUser(
            @ApiParam(name = "ids", value = "主键列表", example = "[1,2,3]", required = true)
            @Size(min = 1)
            @RequestBody String[] ids) {
        boolean remove = userService.removeByIds(Arrays.asList(ids));
        return buildFinalResult(remove);
    }


    /**
     * 分页查询方法
     *
     * @param current    页码
     * @param size       显示条数
     * @param user 附加查询条件
     * @return FinalResult
     */
    @ApiOperation(value = "query查询用户表", notes = "conditions参数参考{\"name\":\"tron\"},查询条件为空时传{}")
    @PostMapping("/query/{current}/{size}")
    public FinalResult<IPage> queryUser(
            @ApiParam(name = "current", value = "页码", required = true)
            @PathVariable long current,
            @ApiParam(name = "size", value = "最大显示条数", required = true)
            @PathVariable long size,
            @ApiParam(name = "conditions", value = "查询条件Map<String,String>", defaultValue = "{}")
            @RequestBody User user) {
        long defaultCurrent = current > 0 ? current : 1;
        long defaultSize = size > 0 ? size : 20;
        //设置分页信息
        Page<User> page = new Page<>();
        page.setCurrent(defaultCurrent);
        page.setSize(defaultSize);
        //组装查询条件
        Map<String, String> conditions = new HashMap<>();
        //K->数据库中字段名   V-> 伪查询条件表达式 纯sql的语法封装查询条件，更多转换类型支持查看或者扩展，参见QueryWrapperFactory类
        conditions.put("这里填数据库中的字段名", " > 20 ");
        conditions.put("name","    %1111%");
        //构建查询sql
        QueryWrapper queryWrapper = QueryWrapperFactory.create(User.class, conditions);
        IPage<User> iPage = (null != queryWrapper) ? userService.page(page, queryWrapper) : userService.page(page);
        return buildFinalResult(iPage);
    }

}
