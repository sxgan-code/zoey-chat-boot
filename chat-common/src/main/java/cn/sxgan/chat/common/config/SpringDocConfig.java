package cn.sxgan.chat.common.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: SpringDoc配置文档
 * @Author: sxgan
 * @Date: 24/8/1 14:14
 * @Version: 1.0
 **/
@Configuration
public class SpringDocConfig {
    
    @Bean
    public OpenAPI defaultOpenAPI() {
        return new OpenAPI().
                info(info())
                .externalDocs(documentation());
    }
    
    public Info info() {
        return new Info()
                .title("zoey chat boot")
                .version("V1.0.0")
                .description("zoey chat boot spring doc open api")
                .license(new License().name("Apache-2.0").url("https://www.apache.org/licenses/LICENSE-2.0"))
                .contact(new Contact().name("sxgan").url("https://gitee.com/sxgan"))
                .summary("聊天核心系统");
    }
    
    public ExternalDocumentation documentation() {
        return new ExternalDocumentation().description("zoey chat boot spring doc")
                .url("http://localhost:8080/v3/api-docs");
    }
}