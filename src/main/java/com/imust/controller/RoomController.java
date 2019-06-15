package com.imust.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.imust.domain.*;
import com.imust.service.IBedroomService;
import com.imust.service.IDormitoryService;
import com.imust.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping("/roomList")
    public ModelAndView roomList(ModelAndView mv, HttpSession session, @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNumber, @RequestParam(value = "pageSize",defaultValue = "2") Integer pageSize,Dormitory dormitory) {
        User userData = (User) session.getAttribute("loginUser");
        List<Room> roomList = null;
        List<Dormitory> dormitoryList = null;
        if ("2".equals(userData.getStatus())){
            dormitory.setUser(userData);
            roomList = roomService.findRoomList(dormitory,pageNumber,pageSize);
            dormitoryList = dormitoryService.findDormitoryList(userData);
        }else {
            dormitory.setUser(null);
            roomList = roomService.findRoomList(dormitory,pageNumber,pageSize);
            dormitoryList = dormitoryService.findDormitoryList(null);
        }
        PageInfo<Room> pageInfo = new PageInfo<>(roomList);
        mv.addObject("dormitoryList",dormitoryList);
        mv.addObject("pageBean",pageInfo);
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
}
