package com.blog.controller;
import com.blog.entity.Blog;
import com.blog.entity.Collect;
import com.blog.entity.Comment;
import com.blog.entity.User;
import com.blog.service.BlogService;
import com.blog.service.CollectService;
import com.blog.service.CommentService;
import com.blog.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    BlogService blogService;
    @Autowired
    CommentService commentService;
    @Autowired
    CollectService collectService;

    @RequestMapping("/login")
    public String login(User user, HttpSession session){
        User loginUser = userService.login(user.getName(),user.getPassword());
        if(loginUser != null){
            session.setAttribute("loginUser",loginUser);
            return "redirect:/index.html";
        }
        else{
            return "default/login";
        }
    }

    @RequestMapping("/reg")
    public String reg(User user,HttpSession session){
        User loginUser = userService.reg(user.getName(),user.getPassword());
        session.setAttribute("loginUser",loginUser);
        return "redirect:/index.html";
    }

    @RequestMapping("/userinfo")
    public String userinfo(String param_list,Integer index,HttpSession session, Model model){
        User loginUser = (User)session.getAttribute("loginUser");
        User user = userService.getUserInfo(loginUser.getId());
        switch (param_list){
            case "blog":
                PageHelper.startPage(index,10);
                List<Blog> blogList = blogService.getBlogsByUserId(loginUser.getId());
                PageInfo<Blog> blogs = new PageInfo<>(blogList);
                model.addAttribute("blogList",blogs);
                model.addAttribute("switch","blog");
                break;
            case "comment":
                PageHelper.startPage(index,5);
                List<Comment> commentList = commentService.getCommentsByUserId(loginUser.getId());
                PageInfo<Comment> comments = new PageInfo<>(commentList);
                model.addAttribute("commentList",comments);
                model.addAttribute("switch","comment");
                break;
            case "collect":
                PageHelper.startPage(index,10);
                List<Collect> collectList = collectService.getCollectsByUserId(loginUser.getId());
                List<Blog> collectBlogList = blogService.getListByCollectList(collectList);
                PageInfo<Blog> collects = new PageInfo<>(collectBlogList);
                model.addAttribute("collectList",collects);
                model.addAttribute("switch","collect");
                break;
//            case "notice":
//                List<Blog> blogList = user.getBlogList();
//                PageInfo<Blog> blogs = new PageInfo<>(blogList);
//                model.addAttribute("blogList",blogs);
//                break;
            default:
                model.addAttribute("switch","null");
                break;
        }
        model.addAttribute("user",user);
        return "login_only/userinfo";
    }

    @RequestMapping("/comment")
    public String comment(Comment comment,int blogId,HttpSession session){
        Timestamp time = new Timestamp(System.currentTimeMillis());
        Blog blog = new Blog();
        blog.setId(blogId);
        comment.setPublishTime(time);
        comment.setBlog(blog);
        comment.setUser((User)session.getAttribute("loginUser"));
        commentService.saveComment(comment);
        return "redirect:/blog?id="+blogId;
    }

}
