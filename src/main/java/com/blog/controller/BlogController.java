package com.blog.controller;
import com.blog.mapper.BlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BlogController {

    @Autowired
    BlogMapper blogMapper;

    @RequestMapping("commit")
    public String commit(String editContent, String htmlContent, String title, HttpServletRequest request){
//        Blog blog = new Blog();
//        BlogDetail blogDetail = new BlogDetail();
//        blogMapper.insert(blog);
        System.out.println(request.getCharacterEncoding());
        System.out.println(editContent);
        System.out.println(title);
        return "login_only/edit_blog";
    }

    @RequestMapping("blog/{id}")
    public String blog(@PathVariable Integer id,Model model){
//        Blog blog = blogMapper.selectById(id);
//        model.addAttribute("blog",blog);
//        model.addAttribute("blog",blog);
        return "default/blog";
    }

}
