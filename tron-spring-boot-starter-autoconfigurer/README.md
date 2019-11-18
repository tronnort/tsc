####当前依赖框架版本
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.0.8.RELEASE</version>
    </parent>

####tronStart基础配置
```text
spring:
  datasource:
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://localhost:3306/mydb?useUnicode=true&useSSL=false&characterEncoding=utf8
    username: root
    password: 123456
  swagger:
    swaggerApiScanPage: com.tron.web.controller
  codeGeneratorConfig:
    packageName: com.tron
```
####代码生成器使用
```text
@RunWith(SpringRunner.class)
@SpringBootTest
public class Code {

    @Autowired
    CodeGenerator codeGenerator;

    @Test
    public void code() {
        codeGenerator.run("web","person");
    }
}
```