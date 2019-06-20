package com.blog.controller;

import com.blog.controller.support.SimpleResult;
import com.blog.entity.User;
import com.blog.service.BlogService;
import com.blog.service.TypeService;
import com.blog.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminUserController {
    @Autowired
    private UserService userService ;
    @Autowired
    private BlogService blogService ;
    @Autowired
    private TypeService typeService ;
    Logger logger = LoggerFactory.getLogger(getClass());
    @GetMapping("/index")
    public String admin(Model model){

        SimpleResult simpleResult = new SimpleResult();
        simpleResult.setUserNum(userService.countUser());
        simpleResult.setBlogNum(blogService.countBlog());
        simpleResult.setTypeNum(typeService.countType());
        model.addAttribute("simpleResult",simpleResult) ;
        return "admin/admin" ;
    }

    @GetMapping("/user")
    public String userArrange(Model model, HttpSession session){
        //得到第一页的用户数据
        //默认第一页，数量5
        PageHelper.startPage(1, 5);
        List<User> allUsers = userService.getAllUsers();
        PageInfo<User> pageInfo = new PageInfo<>(allUsers);
       //得到页数
       session.setAttribute("pageNow",1);
       session.setAttribute("pageNum",pageInfo.getPages());
        //设置数据
        model.addAttribute("pageInfo",pageInfo);
        return "admin/userArrange" ;
    }
    @GetMapping("/user/page")
    public String pageIndex(int index,HttpSession session,Model model){
        int pageNum = (int)session.getAttribute("pageNum");
        if (index>pageNum)
            return "error/404" ;
        //得到该页数据
        PageHelper.startPage(index,5);
        List<User> allUsers = userService.getAllUsers();
        PageInfo<User> pageInfo = new PageInfo<>();
        //设置数据
        model.addAttribute("pageInfo",pageInfo);
        session.setAttribute("pageNow",index);

        return "admin/userArrange";
    }
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable(name = "id") int id){
        //调用service
       userService.deleteUserById(id);
        return "redirect:/admin/user";
    }
    @PutMapping("/user/{id}")
    public String setUsetStatus(@PathVariable(name = "id") int id){
        String status = userService.getUserInfo(id).getStatus();
        if (status.equals("正常"))
            userService.lockUserById(id);
        else
            userService.unlockUserById(id);
        return "redirect:/admin/user" ;
    }
}
