package com.blog.controller;
import com.blog.entity.Type;
import com.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    TypeService typeService;

    @RequestMapping("index.html")
    public String index(HttpSession session){
        List<Type> typeList = typeService.getAllType();
        session.setAttribute("typeList",typeList);
        return "default/index";
    }

}
