package com.blog.controller;

import com.blog.entity.Blog;
import com.blog.service.BlogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class JottingsController {
    @Autowired
    private BlogService blogService ;

    @GetMapping("/blog/type/{id}")
    public String jottingsIndex(@PathVariable(name = "id") int id , Model model){
        if (id != 1)
            return "error/404" ;
        model.addAttribute("latestJottings",blogService.getBlogsOrderByPT(1,2) );
        model.addAttribute("hotestJottings",blogService.getBlogsOrderByReadCount(1,2));
        model.addAttribute("recommendJottings", blogService.getRecommendBlogs(1,2));

        return "jottings/jottingsIndex" ;
    }
    @GetMapping("/jotting/latestindex")
    public String Latestindex(Model model , HttpSession session){
        PageHelper.startPage(1,5);
        List<Blog> blogsOrderByPT = blogService.getBlogsOrderByPT(1, null);
        PageInfo<Blog> latestJottings = new PageInfo<>(blogsOrderByPT);

        model.addAttribute("latestJottings",latestJottings);
        session.setAttribute("pageNow",1);

        return "jottings/LatestJottings" ;
    }
    @GetMapping("/jotting/hotestindex")
    public String hotestindex(Model model,HttpSession session){
        PageHelper.startPage(1,5);
        List<Blog> blogsOrderByReadCount = blogService.getBlogsOrderByReadCount(1, null);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogsOrderByReadCount);

        model.addAttribute("hotestJottings",pageInfo) ;
        session.setAttribute("pageNow",1);

        return "jottings/hotestJottings" ;
    }
    @GetMapping("/jotting/recommendindex")
    public String recommendindex(Model model ,HttpSession session ){
        PageHelper.startPage(1,5);
        List<Blog> recommendBlogs = blogService.getRecommendBlogs(1, null);
        PageInfo<Blog> blogPageInfo = new PageInfo<>(recommendBlogs);

        model.addAttribute("recommendJottings",blogPageInfo);
        session.setAttribute("pageNow" ,1);

        return  "jottings/recommendJottings" ;
    }

}
