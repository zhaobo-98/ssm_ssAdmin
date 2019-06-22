package com.imust.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.imust.domain.*;
import com.imust.service.IBedroomService;
import com.imust.service.IDormitoryService;
import com.imust.service.IRoomService;
import com.imust.service.IUserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private IRoomService roomService;

    @Autowired
    private IDormitoryService dormitoryService;

    @Autowired
    private IBedroomService bedroomService;

    @Autowired
    private IUserService userService;
    @RequestMapping("/roomList")
    public ModelAndView roomList(ModelAndView mv, HttpSession session, PageBeanUI pageBeanUI) {
        //获取当前登录的用户
        User userData = (User) session.getAttribute("loginUser");
        List<Room> roomList = null;
        List<Dormitory> dormitoryList = null;
        List<User> userList = null;
        if ("2".equals(userData.getStatus())){
            pageBeanUI.setLoginUser(userData);
            roomList = roomService.findRoomList(pageBeanUI);
            dormitoryList = dormitoryService.findDormitoryList(userData);
        }else {
            pageBeanUI.setLoginUser(null);
            roomList = roomService.findRoomList(pageBeanUI);
            dormitoryList = dormitoryService.findDormitoryList(null);
            userList = userService.findUsers();
        }
        PageInfo<Room> pageInfo = new PageInfo<>(roomList);
        mv.addObject("dormitoryList",dormitoryList);
        mv.addObject("userList",userList);
        mv.addObject("pageBean",pageInfo);
        //回显数据
        mv.addObject("pageBeanUI",pageBeanUI);
        mv.setViewName("forward:/jsp/room/room.jsp");
        return mv;
    }

    @RequestMapping("/addRoomUI")
    public ModelAndView addRoomUI(Dormitory dormitory,ModelAndView mv, HttpSession session){
        User userData = (User) session.getAttribute("loginUser");
        if ("2".equals(userData.getStatus())){
            dormitory.setUser(userData);
        }
        List<Dormitory> dormitoryList = dormitoryService.findDormitoryListByUser(dormitory);
        mv.addObject("dormitoryList",dormitoryList);
        System.out.println(dormitoryList);
        mv.setViewName("forward:/jsp/room/showAddRoom.jsp");
        return mv;
    }

    @RequestMapping("/addRoom")
    public String addRoom(Room room){
        // 添加宿舍
        roomService.addRoom(room);
        return "redirect:roomList";
    }

    @RequestMapping("/getAjaxRoomList")
    public @ResponseBody List<Room> getAjaxRoomList(@RequestBody Dormitory dormitory){
        List<Room> roomList = roomService.getAjaxRoomList(dormitory);
        return roomList;
    }

    @RequestMapping("/deleteByRoomId")
    public ModelAndView deleteByRoomId(ModelAndView mv,int[] ids){
        roomService.deleteRoomById(ids);
        mv.setViewName("redirect:/room/roomList");
        return mv;
    }

    @RequestMapping("/updateRoomUI")
    public ModelAndView updateRoomUI(Room room,ModelAndView mv){
        Room rooms = roomService.findRoomByRoom(room);
        mv.addObject("rooms",rooms);
        mv.setViewName("forward:/jsp/room/showUpdateRoom.jsp");
        return mv;
    }

    @RequestMapping("/updateRoom")
    public String updateRoom(Room room){
        // 添加宿舍
        roomService.updateRoom(room);
        return "redirect:roomList";
    }
}
