package com.blog.controller;
import com.blog.entity.User;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("login")
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

    @RequestMapping("reg")
    public String reg(User user,HttpSession session){
        User loginUser = userService.reg(user.getName(),user.getPassword());
        session.setAttribute("loginUser",loginUser);
        return "redirect:/index.html";
    }

    @RequestMapping("userinfo.html")
    public String userinfo(HttpSession session, Model model){
        User loginUser = (User)session.getAttribute("loginUser");
        User user = userService.getUserInfo(loginUser.getId());
        model.addAttribute("user",user);
        return "login_only/userinfo";
    }

}
