package com.blog.controller;

import com.blog.entity.Blog;
import com.blog.service.BlogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminBlogController {
    @Autowired
    private BlogService blogService ;
    @GetMapping("/blog")
    public String blogArrange(Model model, HttpSession session){
        PageHelper.startPage(1,5);
        List<Blog> allBlogs = blogService.getAllBlogs();
        PageInfo<Blog> blogInfo = new PageInfo<>(allBlogs);

        model.addAttribute("blogInfo",blogInfo);
        session.setAttribute("pageNow",1);
        session.setAttribute("pageNum",blogInfo.getPages());

        return "admin/blogArrange" ;
    }
    @GetMapping("/blog/page")
    public String pageIndex(int index,Model model,HttpSession session){
        int pageNum = (int)session.getAttribute("pageNum");
        if (index>pageNum)
            return "error/404" ;

        PageHelper.startPage(index,5);
        List<Blog> allBlogs = blogService.getAllBlogs();
        PageInfo<Blog> blogInfo = new PageInfo<>(allBlogs);
         //设置数据
        model.addAttribute("blogInfo",blogInfo);
        session.setAttribute("pageNow",index);

        return "admin/blogArrange" ;
    }
    @DeleteMapping("/blog/{id}")
    public String deleteBlog(@PathVariable(name = "id") int id){
        blogService.deleteBlogById(id);
        return "redirect:/admin/blog" ;
    }
    @PutMapping("/blog/{id}")
    public String setRecommend(@PathVariable(name = "id") int id){
        Integer recommend = blogService.getBlogById(id).getRecommend();
        if(recommend == 1)
            blogService.setNoRecommend(id);
        else
            blogService.setRecommend(id);
        return "redirect:/admin/blog" ;
    }
}
