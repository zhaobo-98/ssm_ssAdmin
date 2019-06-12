package com.imust.controller;

import com.imust.domain.BedRoom;
import com.imust.domain.Dormitory;
import com.imust.domain.PageBeanUI;
import com.imust.domain.Room;
import com.imust.service.IBedroomService;
import com.imust.service.IDormitoryService;
import com.imust.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView roomList(PageBeanUI pageBeanUI, ModelAndView mv) {
        List<Room> roomList = roomService.findRoomList(pageBeanUI);
        List<Dormitory> dormitoryList = dormitoryService.findDormitoryList();
        mv.addObject("dormitoryList",dormitoryList);
        mv.addObject("roomList",roomList);
        mv.setViewName("forward:/jsp/room/room.jsp");
        return mv;
    }

    @RequestMapping("/addRoomUI")
    public ModelAndView addRoomUI(ModelAndView mv){
        List<Dormitory> dormitoryList = dormitoryService.findDormitoryList();
        mv.addObject("dormitoryList",dormitoryList);
        System.out.println(dormitoryList);
        mv.setViewName("forward:/jsp/room/showAddRoom.jsp");
        return mv;
    }

    @RequestMapping("/addRoom")
    public String addRoom(Room room){
        // 添加宿舍
        roomService.addRoom(room);
        // 添加成功后,扩展6个床位
        BedRoom bedRoom = new BedRoom();
        bedroomService.addBedroom(room,bedRoom);
        return "redirect:roomList";
    }
}
