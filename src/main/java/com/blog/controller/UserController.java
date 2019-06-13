package com.blog.controller;
import com.blog.entity.User;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
            return "default/index";
        }
        else{
            return "default/login";
        }
    }

}
