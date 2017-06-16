package xyz.vimtools.share.global.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.collect.Lists.newArrayList;

/**
 * swagger config
 *
 * @author luckyhua
 * @version 1.0
 * @date 2017/3/29
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        //可以添加多个header或参数
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        parameterBuilder.parameterType("header") //参数类型支持header、cookie、body、query
                .name("Authorization") //参数名
                .defaultValue("") //默认值
                .description("登录后返回的授权码")
                .modelRef(new ModelRef("string")) //指定参数值的类型
                .required(false) //非必须，全局配置，登录的时候不用验证
                .build();
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
                .select()
                .apis(RequestHandlerSelectors.basePackage("xyz.vimtools"))
                .paths(PathSelectors.any())
                .build()
                .ignoredParameterTypes(ApiIgnore.class)
                .globalOperationParameters(newArrayList(parameterBuilder.build()));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTFUL APIs")
                .description("官方网站 : http://www.liegouchina.cn")
                .termsOfServiceUrl("http://api.restaurant.com")
                .contact(new Contact("xyz", "www.vimtools.share", "kezy-5566@163.com"))
                .version("1.0")
                .build();
    }

}
