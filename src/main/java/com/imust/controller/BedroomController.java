package com.imust.controller;

import com.github.pagehelper.PageInfo;
import com.imust.domain.*;
import com.imust.service.IBedroomService;
import com.imust.service.IDormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
        System.err.println(pageBeanUI);
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

    /**
     * 跳转入住页面
     * @param mv
     * @return
     */
    @RequestMapping("/inRoomUI")
    public ModelAndView inRoomUI(ModelAndView mv,HttpSession session,PageBeanUI pageBeanUI,Integer bedId){
        User userData = (User) session.getAttribute("loginUser");
        BedRoom bedRoom = new BedRoom();
        bedRoom.setBedId(bedId);
        pageBeanUI.setBedRoom(bedRoom);
        if ("2".equals(userData.getStatus())){
            pageBeanUI.setLoginUser(userData);
        }else {
            pageBeanUI.setLoginUser(null);
        }
        BedRoom bedRoomData = bedroomService.findBedroomById(pageBeanUI);
        mv.addObject("bedRoom",bedRoomData);
        mv.setViewName("forward:/jsp/bedroom/showAddBedRoom.jsp");
        return mv;
    }

    @RequestMapping("/inRoom")
    public ModelAndView inRoom(ModelAndView mv,PageBeanUI pageBeanUI){
        bedroomService.inRoom(pageBeanUI);
        mv.setViewName("redirect:bedRoomList");
        return mv;
    }

    @RequestMapping("/outRoom")
    public ModelAndView outRoom(ModelAndView mv,PageBeanUI pageBeanUI){
        bedroomService.outRoom(pageBeanUI);
        mv.setViewName("redirect:bedRoomList");
        return mv;
    }

    @RequestMapping("/getAjaxBedRoomList")
    public @ResponseBody List<BedRoom> getAjaxBedRoomList(@RequestBody Room room){
        List<BedRoom> bedRoomList = bedroomService.getAjaxBedRoomList(room);
        return bedRoomList;
    }

    @RequestMapping("/deleteBedRoomById")
    public ModelAndView deleteBedRoomById(ModelAndView mv,BedRoom bedRoom){
        bedroomService.deleteBedRoomByBedRoom(bedRoom);
        mv.setViewName("redirect:/bedroom/bedRoomList");
        return mv;
    }
}
