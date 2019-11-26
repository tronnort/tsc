<#assign upName = "${table.entityName}">
<#assign lowName = "${table.entityPath}">
<#assign packageName = "${'${package.Controller}'?replace('.controller','')}">

<#function getComment>
    <#local names = "">
    <#list table.fields as node>
    <#local names = names +node.name+":"+node.comment+" ">
    </#list>
    <#return "{"+ names + "}">
</#function>

<#--   ${getComment()}    获取对象的json字符串-->

package ${package.Controller};

import ${packageName}.entity.${upName};
import ${packageName}.service.${table.serviceName};
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@RestController
@Validated
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/${lowName}")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
@Api(tags = "${table.comment}操作")
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>
    @Autowired
    private ${table.serviceName} ${(table.serviceName?substring(1))?uncap_first};


    /**
    *根据id查找
    * @param id  主键id
    * @return FinalResult
    */
    @ApiOperation(value = "根据Id查询${table.comment}" ,notes = "返回数据${getComment()}")
    @GetMapping("/{id}")
    public FinalResult<${upName}> get${upName}ById(
        @ApiParam(name="id",value="主键",required=true)
        @PathVariable String id){
        ${upName} ${lowName} = ${lowName}Service.getById(id);
        return buildFinalResult(${lowName});
    }


    /**
    *新增方法
    * @param ${lowName} 实体类
    * @return FinalResult
    */
    @ApiOperation(value = "添加${table.comment}",notes = "参数参考${getComment()},id自动生成")
    @PostMapping("/add")
    public FinalResult<String> add${upName}(
        @ApiParam(name="${lowName}",value="${getComment()}",required=true)
        @Valid
        @RequestBody ${upName} ${lowName}) {
        String id = UUID.randomUUID().toString().replace("-", "");
        ${lowName}.setId(id);
        ${lowName}Service.save(${lowName});
        return  buildFinalResult(id);
    }


    /**
    * 修改方法
    * @param ${lowName} 实体类
    * @return FinalResult
    */
    @ApiOperation(value = "更新${table.comment}" ,notes = "参数参考${getComment()}")
    @PostMapping("/update")
    public FinalResult<Boolean> update${upName}(
        @ApiParam(name="${lowName}",value="${getComment()}",required=true)
        @Valid
        @RequestBody ${upName} ${lowName}) {
        boolean update = ${lowName}Service.updateById(${lowName});
        return  buildFinalResult(update);
    }


    /**
    * 删除方法
    * @param ids 主键列表
    * @return FinalResult
    */
    @ApiOperation(value = "删除${table.comment}" ,notes = "参数参考[1,2,3]")
    @PostMapping("/delete")
    public FinalResult<Boolean> delete${upName}(
        @ApiParam(name="ids",value="主键列表",example = "[1,2,3]",required=true)
        @Size(min = 1)
        @RequestBody String[] ids) {
        boolean remove = ${lowName}Service.removeByIds(Arrays.asList(ids));
        return  buildFinalResult(remove);
    }


    /**
    * 分页查询方法
    * @param current 页码
    * @param size  显示条数
    * @param conditions 附加查询条件
    * @return FinalResult
    */
    @ApiOperation(value = "query查询${table.comment}" ,notes = "conditions参数参考{\"name\":\"=tron\"},查询条件为空时传{}")
    @PostMapping("/query/{current}/{size}")
    public FinalResult<IPage> queryUser(
        @ApiParam(name="current",value="页码",required=true)
        @PathVariable Long current,
        @ApiParam(name="size",value="最大显示条数",required=true)
        @PathVariable Long size,
        @ApiParam(name="conditions",value="查询条件Map<String,String>",defaultValue ="{}")
        @RequestBody Map<String,String> conditions) {
        long defaultCurrent = (current != null && current > 0 ) ? current : 1;
        long defaultSize = (size != null && size > 0 ) ? size : 20;
        Page<${upName}> page = new Page<>();
        page.setCurrent(defaultCurrent);   //当前页码
        page.setSize(defaultSize);     //显示条数
        QueryWrapper queryWrapper = null;
        //设置分页信息
        Page<${upName}> page = new Page<>();
        page.setCurrent(defaultCurrent);
        page.setSize(defaultSize);
        //组装查询条件
        Map<String, String> conditions = new HashMap<>();
        //K->数据库中字段名   V-> 伪查询条件表达式 纯sql的语法封装查询条件，更多转换类型支持查看或者扩展，参见QueryWrapperFactory类
        conditions.put("这里填数据库中的字段名", ">20");
        //构建查询sql
        QueryWrapper queryWrapper = QueryWrapperFactory.create(${upName}.class, conditions);
        IPage<${upName}> iPage = (null != queryWrapper) ? ${lowName}Service.page(page,queryWrapper) : ${lowName}Service.page(page);
        return buildFinalResult(iPage);
    }

}
</#if>
