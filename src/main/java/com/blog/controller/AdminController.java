package com.blog.controller;

import com.blog.controller.support.SimpleResult;
import com.blog.entity.Sex;
import com.blog.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    Logger logger = LoggerFactory.getLogger(getClass());
    @GetMapping("/index")
    public String admin(Model model){
        SimpleResult simpleResult = new SimpleResult();
        simpleResult.setUserNum(14);
        simpleResult.setBlogNum(15);
        simpleResult.setTypeNum(16);
        model.addAttribute("simpleResult",simpleResult) ;
        return "admin/admin" ;
    }

    @GetMapping("/user")
    public String userArrange(Model model, HttpSession session){
        //得到第一页的用户数据
        List<User> users = new ArrayList<>() ;
        List<Integer> pageNum = new ArrayList<>();
        for (int i= 0 ; i<5 ;i++){
            pageNum.add(i+1);
            User user = new User();
            user.setId(i+1);
            user.setName("yong"+i);
            user.setSex(Sex.MALE);
            user.setStatus("正常");
            users.add(user);
        }
        //得到页数
        session.setAttribute("pageNow",1);
        session.setAttribute("pageNum",pageNum);
        //设置数据
        model.addAttribute("users",users);
        return "admin/userArrange" ;
    }
    @GetMapping("/user/page")
    public String pageIndex(int index,HttpSession session,Model model){
        List<Integer> pageNum =(List<Integer>) session.getAttribute("pageNum");
        if (index>pageNum.size())
            return "error/404" ;
        //得到该页数据
        List<User> users = new ArrayList<>() ;
        for (int i= 0 ; i<5 ;i++){

            User user = new User();
            user.setId(i+1);
            user.setName("ming"+i);
            user.setSex(Sex.MALE);
            user.setStatus("正常");
            users.add(user);
        }
        //设置数据
        model.addAttribute("users",users);
        session.setAttribute("pageNow",index);

        return "admin/userArrange";
    }
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable(name = "id") int id){
        //调用service
       logger.info("delete方法调用");
        return "redirect:/admin/user";
    }
}
