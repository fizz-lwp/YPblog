package com.blog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BlogApplication/* extends SpringBootServletInitializer */{

    // 如果不想使用 springboot 自带的 tomcat 部署项目的话，想使用自定义 tomcat 部署项目则需要 extends SpringBootServletInitializer 并覆盖 configure 方法
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(BlogApplication.class);
//    }

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }

}
