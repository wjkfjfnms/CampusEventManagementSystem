package com.six.campuseventmanagementsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class Swagger2Config implements WebMvcConfigurer {
    /**
     * 创建 API 应用
     * apiInfo 增加 API 相关信息
     * 通过 select() 函数返回一个 ApiSelectorBuilder 实例，用来控制哪些接口暴露给 Swagger 来展现
     * 本例采用指定扫描的包路径来定义指定要建立 API 的目录
     */
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()) // 用来展示该 API 的基本信息
                .select()   // 返回一个 ApiSelectorBuilder 实例，用来控制哪些接口暴露给 Swagger 来展现
                .apis(RequestHandlerSelectors.basePackage("com/six/campuseventmanagementsystem/controller"))   // 配置包扫描路径（根据自己项目调整，通常配置为控制器路径）
                .paths(PathSelectors.any()) //
                .build();
    }

    /**
     * 创建 API 的基本信息（这些基本信息会展现在文档页面中）
     * 访问地址：http://xxx/swagger-ui.html
     */
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("校园赛事活动管理系统")
                .description("校园赛事活动管理系统 API接口文档")
                .termsOfServiceUrl("http://localhost:8080/")
                .contact(new Contact("ambrose", "swagger.example", "2020480337@qq.com"))
                .version("3.0")
                .build();
    }
}
