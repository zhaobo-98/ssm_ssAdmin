package com.imust.controller;

import com.imust.domain.Dormitory;
import com.imust.domain.PageBean;
import com.imust.domain.PageBeanUI;
import com.imust.domain.User;
import com.imust.service.IDormitoryService;
import com.imust.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/dormitory")
public class DormitoryController {

    @Autowired
    private IDormitoryService dormitoryService;
    @Autowired
    private IUserService userService;

    @RequestMapping("/showAdd")
    public ModelAndView showAdd(ModelAndView mv, PageBeanUI pageBeanUI){
        List<User> list = userService.findUserList(pageBeanUI);
        mv.addObject("userList",list);
        mv.setViewName("forward:/jsp/dormitory/dormitoryAdd.jsp");
        return mv;
    }

    @RequestMapping("/addDormitory")
    public ModelAndView addDormitory(ModelAndView mv,Dormitory dormitory) {
        dormitoryService.addDormitory(dormitory);
        mv.setViewName("redirect:dormitoryList");
        return mv;
    }
    @RequestMapping("/dormitoryList")
    public ModelAndView dormitoryList(ModelAndView mv) {
        List<Dormitory> dormitoryList = dormitoryService.findDormitoryList();
        mv.addObject("dormitoryList",dormitoryList);
        mv.setViewName("forward:/jsp/dormitory/dormitory.jsp");
        return mv;
    }
    @RequestMapping("/updateDormitoryUI")
    public ModelAndView updateDormitoryUI(Integer dorId,ModelAndView mv){
        Dormitory dormitory = dormitoryService.findDormitoryListById(dorId);
        List<User> userList = userService.findUserList(null);
        mv.addObject("dormitory",dormitory);
        mv.addObject("userList",userList);
        mv.setViewName("forward:/jsp/dormitory/showUpdateDormitory.jsp");
        return mv;
    }

    @RequestMapping("/updateDormitory")
    public String updateDormitory(Dormitory dormitory){
        dormitoryService.updateDormitory(dormitory);
        return "redirect:dormitoryList";
    }

    @RequestMapping("/deleteById")
    public String deleteById(Integer[] ids){
        dormitoryService.deleteDormitoryById(ids);
        return "redirect:dormitoryList";
    }
}
