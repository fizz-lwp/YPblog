package com.blog.controller;
import com.blog.entity.Blog;
import com.blog.entity.Type;
import com.blog.mapper.BlogMapper;
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
    BlogMapper blogMapper;

    @RequestMapping("index.html")
    public String index(HttpSession session, Model model){
        List<Type> typeList = typeService.getAllType();
        List<Blog> latestBlogList = blogMapper.selectLatestLimit4();
        List<Blog> hotestBlogList = blogMapper.selectHotestLimit4();
        List<Blog> recommendBlogList = blogMapper.selectRecommendLimit4();
        model.addAttribute("latestBlogList",latestBlogList);
        model.addAttribute("hotestBlogList",hotestBlogList);
        model.addAttribute("recommendBlogList",recommendBlogList);
        session.setAttribute("typeList",typeList);
        return "default/index";
    }

}
