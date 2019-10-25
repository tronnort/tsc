<#assign upName = "${table.entityName}">
<#assign lowName = "${table.entityPath}">
<#assign packageName = "${'${package.Controller}'?replace('.controller','')}">

package ${package.Controller};

import ${packageName}.entity.${upName};
import ${packageName}.service.${table.serviceName};
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>
    @Autowired
    private ${table.serviceName} ${(table.serviceName?substring(1))?uncap_first};


    @RequestMapping("/{id}")
    public Object get${upName}ById(@PathVariable String id){
        return ${lowName}Service.getById(id);
    }

    @RequestMapping("/add")
    public Object add${upName}(${upName} ${lowName}) {
    String id = UUID.randomUUID().toString().replace("-", "");
        ${lowName}.setId(id);
        ${lowName}Service.save(${lowName});
        return id;
    }

    @RequestMapping("/update")
    public Object update${upName}(${upName} ${lowName}) {
        boolean update = ${lowName}Service.updateById(${lowName});
        return update;
    }

    @RequestMapping("/delete")
    public Object delete${upName}(String[] ids) {
        boolean remove = ${lowName}Service.removeByIds(Arrays.asList(ids));
        return remove;
    }

    @RequestMapping("/query/{current}/{size}")
    public Object queryUser(@PathVariable Long current,
                            @PathVariable Long size,
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
