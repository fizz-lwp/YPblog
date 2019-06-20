package com.blog.controller;

import com.blog.entity.Type;
import com.blog.service.TypeService;
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
public class AdminTypeController {
    @Autowired
    private TypeService typeService;

    @GetMapping("/type")
    public String adminType(Model model, HttpSession session){
        PageHelper.startPage(1,5);
        List<Type> allTypes = typeService.getAllTypes();
        PageInfo<Type> typePageInfo = new PageInfo<>(allTypes);

        model.addAttribute("typeInfo",typePageInfo);
        session.setAttribute("pageNow",1);
        session.setAttribute("pageNum",typePageInfo.getPages());

        return "admin/typeArrange" ;
    }
    @DeleteMapping("/type/{name}")
    public String deleteType(@PathVariable(name = "name") String name){
        typeService.deleteType(name);
        return "redirect:/admin/type";
    }
    @PostMapping("/type")
    public String addType(String name){
        typeService.addType(name);
        return "redirect:/admin/type";
    }
    @GetMapping("/type/page")
    public String typeIndex(int index,Model model,HttpSession session){
        PageHelper.startPage(index,5);
        List<Type> allTypes = typeService.getAllTypes();
        PageInfo<Type> typePageInfo = new PageInfo<>(allTypes);

        model.addAttribute("typeInfo",typePageInfo);
        session.setAttribute("pageNow",index);
        return "redirect:/admin/type" ;
    }
}
