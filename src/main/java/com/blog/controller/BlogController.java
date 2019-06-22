package com.blog.controller;
import com.blog.entity.*;
import com.blog.mapper.BlogMapper;
import com.blog.service.BlogService;
import com.blog.service.ReplyService;
import com.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
public class BlogController {

    @Autowired
    BlogService blogService;
    @Autowired
    TypeService typeService;
    @Autowired
    ReplyService replyService;

    @RequestMapping("/edit_blog")
    public String editBlog(Model model){
        List<Type> typeList = typeService.getAllTypes();
        model.addAttribute("typeList",typeList);
        return "login_only/edit_blog";
    }

    @RequestMapping("/commit")
    public String commit(Blog blog,String typeName,HttpServletRequest request,HttpSession session){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        blog.setPublishTime(timestamp);
        blog.setLastModifyTime(timestamp);
        blog.setReadCount(0);
        blog.setRecommend(0);
        blog.setUser((User)session.getAttribute("loginUser"));
        Type type = typeService.getType(typeName);
        blog.setType(type);
        blogService.saveBlog(blog);
        return "login_only/edit_blog";
    }

    @RequestMapping("/blog")
    public String blog(String id,Model model){
        Blog blog = blogService.getBlogById(Integer.valueOf(id));
        blog.setReadCount(blog.getReadCount()+1); // 阅读加一
        blogService.saveBlog(blog);
        model.addAttribute("blog",blog);
        List<Blog> latestBlogs = blogService.getLatestBlogs(3);
        List<Blog> hotestBlogs = blogService.getReadestBlogs(3);
        model.addAttribute("latestBlogs",latestBlogs);
        model.addAttribute("hotestBlogs",hotestBlogs);
        return "default/blog";
    }

    @RequestMapping("/reply")
    public String reply(Reply reply,String receiverId,String commentId,String blogId,HttpSession session){
        Timestamp time = new Timestamp(System.currentTimeMillis());
        User receiver = new User();
        Comment comment = new Comment();
        comment.setId(Integer.valueOf(commentId));
        receiver.setId(Integer.valueOf(receiverId));
        reply.setPublishTime(time);
        reply.setSender((User)session.getAttribute("loginUser"));
        reply.setReceiver(receiver);
        reply.setComment(comment);
        replyService.saveReply(reply);
        return "redirect:/blog?id="+blogId;
    }

}
