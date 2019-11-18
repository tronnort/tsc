package com.tron.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring")
@Data
public class TronProperties {
   private Swagger swagger;
   private DataSource dataSource;
   private CodeGeneratorConfig codeGeneratorConfig;
}
