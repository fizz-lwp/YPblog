package com.blog.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    // 配置url映射规则
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/reg.html").setViewName("default/reg");
        registry.addViewController("login.html").setViewName("default/login");
        registry.addViewController("sample.html").setViewName("sample/sample");
        registry.addViewController("edit_blog.html").setViewName("login_only/edit_blog");
        registry.addViewController("forget_pwd.html").setViewName("default/forget_pwd");
        registry.addViewController("edit_userinfo.html").setViewName("login_only/edit_userinfo");
        registry.addViewController("blog_manage.html").setViewName("admin/blog_manage");
    }

    // 配置系统资源的虚拟路径
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/upload/**").addResourceLocations("file:D:\\upload\\");
        registry.addResourceHandler("/img/**").addResourceLocations("file:D:\\Study\\Projects\\blog\\src\\main\\resources\\static\\img\\");
        registry.addResourceHandler("/upload/head_photo/**").addResourceLocations("file:D:\\upload\\head_photo\\");
    }

}

