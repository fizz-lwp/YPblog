package com.blog.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            // 配置url映射规则
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/reg.html").setViewName("default/reg");
                registry.addViewController("/login.html").setViewName("default/login");
                registry.addViewController("/forget_pwd.html").setViewName("default/forget_pwd");
                registry.addViewController("/edit_userinfo.html").setViewName("login_only/edit_userinfo");
                registry.addViewController("/test.html").setViewName("test/test");
                registry.addViewController("/new_index.html").setViewName("default/new_index");
            }

            // 配置系统资源的虚拟路径
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry){
                registry.addResourceHandler("/upload/blog_photo/**").addResourceLocations("file:D:\\upload\\blog_photo\\");
                registry.addResourceHandler("/upload/head_photo/**").addResourceLocations("file:D:\\upload\\head_photo\\");
                registry.addResourceHandler("/img/**").addResourceLocations("file:D:\\Study\\Projects\\blog\\src\\main\\resources\\static\\img\\");
                registry.addResourceHandler("/js/**").addResourceLocations("file:D:\\Study\\Projects\\blog\\src\\main\\resources\\static\\js\\");
                registry.addResourceHandler("/css/**").addResourceLocations("file:D:\\Study\\Projects\\blog\\src\\main\\resources\\static\\css\\");
            }
        };
        return adapter;
    }

}

