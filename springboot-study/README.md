#####建数据模型
~~~
把建表sql命名为 schema.sql 测试数命名为 data.sql ，application.yml 里配置相应的配置。启动项目，springboot会自动创建表和测试数据。

~~~
#####自动生成代码
~~~
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
            <version>3.2.0</version>
        </dependency>
        <dependency>
            <groupId>org.freemarker</groupId>
            <artifactId>freemarker</artifactId>
            <version>2.3.29</version>
        </dependency>
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-generator</artifactId>
            <version>3.2.0</version>
        </dependency>
        
        
准备以上依赖  参见com.tron.web.generator.CodeGenerator 自动生成代码   

             
~~~
#####系统级全局变量应统一管理
~~~
参见 com.tron.web.config.MyEnvironment
~~~
#####自定义starts
~~~
@Configuration
~~~

```text
依赖排除
    <dependency>
      <groupId>xxx</groupId>
      <artifactId>xxx</artifactId>
      <version>xxx</version>
      <scope>xxx</scope>
      <exclusions>
        <exclusion>
          <artifactId>xxx</artifactId>
          <groupId>xxx</groupId>
        </exclusion>
      </exclusions>
    </dependency>
```