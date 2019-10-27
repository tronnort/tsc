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

    @ApiOperation(value = "根据Id查询${table.comment}" ,notes = "返回数据${getComment()}")
    @RequestMapping(value ="/{id}",method = RequestMethod.GET)
    public Object get${upName}ById(
        @ApiParam(name="id",value="主键",example = "1",required=true)
        @PathVariable String id){
        return ${lowName}Service.getById(id);
    }
    @ApiOperation(value = "添加${table.comment}",notes = "参数参考${getComment()},id自动生成")
    @RequestMapping(value ="/add",method = RequestMethod.POST)
    public Object add${upName}(
        @ApiParam(name="${lowName}",value="${getComment()}",example = "{}",required=true)
        ${upName} ${lowName}) {
    String id = UUID.randomUUID().toString().replace("-", "");
        ${lowName}.setId(id);
        ${lowName}Service.save(${lowName});
        return id;
    }

    @ApiOperation(value = "更新${table.comment}" ,notes = "参数参考${getComment()}")
    @RequestMapping(value ="/update",method = RequestMethod.POST)
    public Object update${upName}(
        @ApiParam(name="${lowName}",value="${getComment()}",example = "{}",required=true)
        ${upName} ${lowName}) {
        boolean update = ${lowName}Service.updateById(${lowName});
        return update;
    }

    @ApiOperation(value = "删除${table.comment}")
    @RequestMapping(value ="/delete",method = RequestMethod.POST)
    public Object delete${upName}(
        @ApiParam(name="ids",value="主键列表",example = "{ids:1,2,3}",required=true)
        String[] ids) {
        boolean remove = ${lowName}Service.removeByIds(Arrays.asList(ids));
        return remove;
    }


    @ApiOperation(value = "query查询${table.comment}")
    @RequestMapping(value ="/query/{current}/{size}",method = RequestMethod.POST)
    public Object queryUser(
        @ApiParam(name="current",value="页码",example = "1",required=true)
        @PathVariable Long current,
        @ApiParam(name="size",value="最大显示条数",example = "10",required=true)
        @PathVariable Long size,
        @ApiParam(name="conditions",value="查询条件",example = "{}",required=true)
        @RequestBody Map<String,String> conditions) {
        List<${upName}> list = new ArrayList<>();
        long defaultCurrent = (current != null && current > 0 ) ? current : 1;
        long defaultSize = (size != null && size > 0 ) ? size : 20;
        Page<${upName}> page = new Page<>();
        page.setCurrent(defaultCurrent);   //当前页码
        page.setSize(defaultSize);     //显示条数
        QueryWrapper queryWrapper = null;
        if (!conditions.isEmpty()) {
            queryWrapper = new QueryWrapper<${upName}>();
            Set<Map.Entry<String, String>> entrySet = conditions.entrySet();
            Iterator<Map.Entry<String, String>> iterator = entrySet.iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> next = iterator.next();
                queryWrapper.eq(next.getKey(), next.getValue());
            }
        }
        if (null != queryWrapper) {
            IPage<${upName}> iPage = ${lowName}Service.page(page,queryWrapper);
            list = iPage.getRecords();
        }else {
            IPage<${upName}> iPage = ${lowName}Service.page(page);
            list = iPage.getRecords();
        }
        return list;
    }

}
</#if>
