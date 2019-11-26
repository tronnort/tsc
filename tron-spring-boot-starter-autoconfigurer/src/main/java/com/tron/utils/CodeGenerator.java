package com.tron.utils;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.tron.config.TronProperties;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CodeGenerator {

    private TronProperties tronProperties;


    /**
     * 前缀字段的作用是，生成实体的时候去除数据库字段前缀。 如f_id生成实体时，只保留id
     * @param modelName 模块名单个
     * @param tableName tableName表名，多个英文逗号分割
     * @param tablePrefix tablePrefix表前缀，多个英文逗号分割
     * @param fieldPrefix fieldPrefix字段前缀，多个英文逗号分割
     */
    public void run(String modelName,String tableName,String tablePrefix,String fieldPrefix) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // -------------------------------全局配置---------------------------------
        GlobalConfig gc = new GlobalConfig();

        String projectPath = System.getProperty("user.dir");
        //多模块时指定模块名称/springboot-study
        gc.setOutputDir(projectPath + "/src/main/java");
        //作者信息
        gc.setAuthor("tron");
        //是否打开生成目录
        gc.setOpen(false);
        //开启 swagger2 模式
        gc.setSwagger2(true);
        //开启 BaseResultMap
        gc.setBaseResultMap(true);
        //开启 baseColumnList
        gc.setBaseColumnList(true);
        //是否覆盖已有文件
        gc.setFileOverride(true);
        //设置主键生成策略
        gc.setIdType(IdType.UUID);

        mpg.setGlobalConfig(gc);

        // -------------------------------数据源配置----------------------------

        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(tronProperties.getDataSource().getUrl());
        dsc.setDriverName(tronProperties.getDataSource().getDriverClassName());
        dsc.setUsername(tronProperties.getDataSource().getUserName());
        dsc.setPassword(tronProperties.getDataSource().getPassWord());

        mpg.setDataSource(dsc);

        // -------------------------包配置----------------------------------
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(modelName);
        //这里只填到包名即可，留着模块名称
        pc.setParent(tronProperties.getCodeGeneratorConfig().getPackageName());

        mpg.setPackageInfo(pc);

        // -------------------------自定义配置------------------------------
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                //多模块时需要加上模块名"/springboot-study"
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录");
                return false;
            }
        });
        */
        cfg.setFileOutConfigList(focList);

        mpg.setCfg(cfg);

        // ------------------------------------配置模板-------------------------------
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
         templateConfig.setEntity("templates/entity.java");
        // templateConfig.setService();
        templateConfig.setController("/templates/controller.java");
        //mapper xml 模板
        templateConfig.setXml(null);

        mpg.setTemplate(templateConfig);

        // ---------------------------------策略配置------------------------------------
        StrategyConfig strategy = new StrategyConfig();

        //数据库表映射到实体的命名策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //数据库表字段映射到实体的命名策略, 未指定按照 naming 执行
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //如何去掉父类属性
        strategy.setSuperEntityColumns(new String[] { "create_by","create_time","update_by","update_time"});
        //生成Lombok注解
        strategy.setEntityLombokModel(true);
        //设置RestController
        strategy.setRestControllerStyle(true);
        // 公共父类
        strategy.setSuperEntityClass("com.tron.base.BaseEntity");
        strategy.setSuperControllerClass("com.tron.base.BaseController");
        //表名，多个英文逗号分割
        strategy.setInclude(tableName.split(","));
        //驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);
        //表前缀
        strategy.setTablePrefix(tablePrefix.split(","));
        //字段前缀
        strategy.setFieldPrefix(fieldPrefix.split(","));

        mpg.setStrategy(strategy);

        mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        mpg.execute();
    }
}
