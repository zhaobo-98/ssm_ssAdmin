package com.imust.controller;

import com.github.pagehelper.PageInfo;
import com.imust.domain.*;
import com.imust.service.IBedroomService;
import com.imust.service.IDormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/bedroom")
public class BedroomController {
    @Autowired
    private IBedroomService bedroomService;

    @Autowired
    private IDormitoryService dormitoryService;
    @RequestMapping("/bedRoomList")
    public ModelAndView bedRoomList(ModelAndView mv, HttpSession session, PageBeanUI pageBeanUI){
        User userData = (User) session.getAttribute("loginUser");
        List<Dormitory> dormitoryList = null;
        if ("2".equals(userData.getStatus())){
            pageBeanUI.setLoginUser(userData);
            dormitoryList = dormitoryService.findDormitoryList(userData);
        }else {
            pageBeanUI.setLoginUser(null);
            dormitoryList = dormitoryService.findDormitoryList(null);
        }
        List<BedRoom> bedRoomList = bedroomService.findBedroomList(pageBeanUI);
        PageInfo<BedRoom> pageBean = new PageInfo<>(bedRoomList,pageBeanUI.getNavigatePages());
        mv.addObject("pageBean",pageBean);
        mv.addObject("dormitoryList",dormitoryList);
        mv.setViewName("forward:/jsp/bedroom/bedroom.jsp");
        return mv;
    }
}
