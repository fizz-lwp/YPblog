package com.blog.controller;
import com.blog.entity.Blog;
import com.blog.entity.Type;
import com.blog.service.BlogService;
import com.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    TypeService typeService;
    @Autowired
    BlogService blogService;

    @RequestMapping({"index.html","/"})
    public String index(HttpSession session, Model model){
        List<Type> typeList = typeService.getAllTypes();
        List<Blog> latestBlogs = blogService.getLatestBlogs(2);
        List<Blog> hotestBlogs = blogService.getReadestBlogs(2);
        List<Blog> recommendBlogs = blogService.getRecommendBlogs(2);
        model.addAttribute("latestBlogs",latestBlogs);
        model.addAttribute("hotestBlogs",hotestBlogs);
        model.addAttribute("recommendBlogs",recommendBlogs);
        session.setAttribute("typeList",typeList);
        return "default/index";
    }

}
