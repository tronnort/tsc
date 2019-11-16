<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!--namespace对应的是接口类-->
<mapper namespace="com.tron.web.twodatasources.Mydb1Mapper">
    
    <!--接口方法类似   public Vo getVoById(String id); -->
    
    <select id="方法名" resultType="sql语句用哪个实体来接收">
        select * from 表名 where id = #{id}     //#{} 取方法的传参
    </select>

    <!--
    mybatis把接口的方法名与xml文件中的id匹配的方法进行绑定，
    生成一个代理对象执行操作方法
    -->
    
    
    <insert id="方法名" /* parameterType 可以省略 */ >
        insert into 表名(表中的列名...)
        values(#{参数对象的字段}...)
    </insert>
    
    <update id="方法名">
        update 表名
        set 表中的列名 = #{参数对象的字段},...
        where id = #{id}  //一定要加条件
    </update>
    
    <delete>
        delete form 表名 
        where id = #{id}   //一定要加条件
    </delete>
    
    
    
    
    <!--
    单个参数  #{}    //public Vo getVoById(String id);
    多个参数会自动封装成map  #{0} #{1} / #{param1} #{param2}        //public Vo getVoById(String id ,String name);
    多个参数会自动封装成map(指定封装的key)  #{id} #{name}        //public Vo getVoById(@Param("id") String id ,@Param("name") String name); 
    用对象来接传参数#{id} #{name}                   //public Vo getVoById(Vo);
    用map传值  #{id} #{name}                                   //public Vo getVoById(Map map);
    集合或数组传值 #{list[0]}...                                             //public Vo getVoById(Collection list);   
    
    #{} 预编译的方式把值放入sql
    ${} 把值直接封装在sql   //日志sql中直接可见 不能防止sql注入   
    分表情况下，需要动态传表名时。可以用${}来填充表名  
    或者动态传排序字段                                             
    --> 
    
    
    <!-- 
    返回值是List     resultType="单个元素的类型"
    返回值是Map<String,Object>      resultType="map"   //单条记录
    返回值是Map<String,Vo>         resultType="单个元素的类型"   //多条记录 用@MapKey("做key的对象属性")   
    -->
    
    <!--
        <resultMap id="别名"  type="全类名">
            <id property="属性" column="列名" />
            <result property="属性" column="列名" />
        </resultMap>
    -->
    
    <!--  一对多 联合查询 select 列名  from 表1 表2 where 条件
        <resultMap id="别名"  type="全类名">
            <id property="属性" column="列名" />
            <result property="属性" column="列名" />
            <result property="聚合类名.属性" column="联合查询的列名"/>
        </resultMap>
    -->
    
    <!--  一对一 联合查询  select 列名  from 表1 表2 where 条件
        <resultMap id="别名"  type="全类名">
            <id property="属性" column="列名" />
            <result property="属性" column="列名" />
            <association property="聚合类变量名" javaType="聚合类全类名">
                <id property="聚合类属性" column="联合查询的列名"/>
                <result property="聚合类属性" column="联合查询的列名"/>
            </association>
        </resultMap>
    --> 

    <!--  一对一 分步查询   先单表查表1
        <resultMap id="别名"  type="全类名">
            <id property="属性" column="列名" />
            <result property="属性" column="列名" />
            <association property="聚合类变量名" select="聚合类mapper的查询方法" column="传参列名">
            </association>
        </resultMap>
    -->   
    
    
    <!--  一对多 联合查询  select 列名  from 表1 join 表2  on 条件  where 条件
        <resultMap id="别名"  type="全类名">
            <id property="属性" column="列名" />
            <result property="属性" column="列名" />
            <collection property="聚合类变量名" ofType="聚合类全类名">
                <id property="聚合类属性" column="联合查询的列名"/>
                <result property="聚合类属性" column="联合查询的列名"/>                
            </collection>
        </resultMap>
    -->   
    
    <!--  一对多 分步查询  先查表1
        <resultMap id="别名"  type="全类名">
            <id property="属性" column="列名" />
            <result property="属性" column="列名" />
            <collection property="聚合类变量名" select="聚合类mapper的查询方法" column="传参列名">              
            </collection>
        </resultMap>
        
        column="{key1=value1,key2=value2}"   可以传多个值
    -->        
    
    
    <--  递归查询
        参考 SchoolMapper
            
    --> 
</mapper>

```text
自定填充字段，定制序列化规则，参见com.tron.web.mybatis.metahandler.MyMetaObjectHandler
```