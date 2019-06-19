package com.blog.controller;
import com.blog.entity.Blog;
import com.blog.entity.Collect;
import com.blog.entity.Comment;
import com.blog.entity.User;
import com.blog.service.BlogService;
import com.blog.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    BlogService blogService;

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
    public String userinfo(String param_list,HttpSession session, Model model){
        System.out.println();
        User loginUser = (User)session.getAttribute("loginUser");
        User user = userService.getUserInfo(loginUser.getId());
        PageHelper.startPage(1,10);
        switch (param_list){
            case "blog":
                List<Blog> blogList = user.getBlogList();
                PageInfo<Blog> blogs = new PageInfo<>(blogList);
                model.addAttribute("blogList",blogs);
                model.addAttribute("switch","blog");
                break;
            case "comment":
                List<Comment> commentList = user.getCommentList();
                PageInfo<Comment> comments = new PageInfo<>(commentList);
                model.addAttribute("commentList",comments);
                model.addAttribute("switch","comment");
                break;
            case "collect":
                List<Collect> collectList = user.getCollectList();
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
                System.out.println("????????????");
                model.addAttribute("switch","null");
                break;
        }
        model.addAttribute("user",user);
        return "login_only/userinfo";
    }

}
