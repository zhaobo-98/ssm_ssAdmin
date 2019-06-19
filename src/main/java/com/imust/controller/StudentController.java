package com.imust.controller;

import com.github.pagehelper.PageInfo;
import com.imust.domain.*;
import com.imust.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @Autowired
    private IDormitoryService dormitoryService;

    @Autowired
    private IRoomService roomService;

    @Autowired
    private IBedroomService bedroomService;

    @Autowired
    private IStuImageService stuImageService;
    @RequestMapping("/studentList")
    public ModelAndView studentList(ModelAndView mv, HttpSession session, PageBeanUI pageBeanUI) {
        User userData = (User) session.getAttribute("loginUser");
        List<Dormitory> dormitoryList = null;
        System.err.println(pageBeanUI);
        if (userData != null && "2".equals(userData.getStatus())) {
            pageBeanUI.setLoginUser(userData);
            dormitoryList = dormitoryService.findDormitoryList(userData);
        } else {
            pageBeanUI.setLoginUser(null);
            dormitoryList = dormitoryService.findDormitoryList(null);
        }
        List<Student> studentList = studentService.findStudentList(pageBeanUI);
        PageInfo<Student> pageBean = new PageInfo<>(studentList, 10);
        mv.addObject("pageBean", pageBean);
        mv.addObject("dormitoryList", dormitoryList);
        mv.addObject("pageBeanUI", pageBeanUI);
        mv.setViewName("forward:/jsp/student/student.jsp");
        return mv;
    }

    @RequestMapping("/addStudentUI")
    public ModelAndView addStudent(ModelAndView mv, HttpSession session) {
        User userData = (User) session.getAttribute("loginUser");
        List<Dormitory> dormitoryList = null;
        if (userData != null && "2".equals(userData.getStatus())) {
            dormitoryList = dormitoryService.findDormitoryList(userData);
        } else {
            dormitoryList = dormitoryService.findDormitoryList(null);
        }
        mv.addObject("dormitoryList", dormitoryList);
        mv.setViewName("forward:/jsp/student/showAddStudent.jsp");
        return mv;
    }

    @RequestMapping("/addStudent")
    public String addStudent(PageBeanUI pageBeanUI) {
        System.err.println(pageBeanUI);
        studentService.saveStudent(pageBeanUI);
        return "redirect:/student/studentList";
    }

    @RequestMapping("/updateStudentUI")
    public ModelAndView updateStudentUI(ModelAndView mv, PageBeanUI pageBeanUI, HttpSession session) {
        User userData = (User) session.getAttribute("loginUser");
        //查询当前学生信息
        Student student = studentService.findStudentById(pageBeanUI);
        List<Dormitory> dormitoryList = dormitoryService.findDormitoryList(userData);
        List<Room> roomList = null;
        List<BedRoom> bedRoomList = null;
        if (student.getRoom() != null) {
            roomList = roomService.getAjaxRoomList(student.getRoom().getDormitory());

            bedRoomList = bedroomService.getAjaxBedRoomList(student.getRoom());
        }
        mv.addObject("dormitoryList", dormitoryList);
        mv.addObject("roomList", roomList);
        mv.addObject("bedRoomList", bedRoomList);
        mv.addObject("student", student);
        mv.setViewName("forward:/jsp/student/showUpdateStudent.jsp");
        return mv;
    }

    @RequestMapping("/updateStudent")
    public ModelAndView updateStudent(ModelAndView mv, PageBeanUI pageBeanUI) {
        studentService.updateStudent(pageBeanUI);
        mv.setViewName("redirect:/student/studentList");
        return mv;
    }

    @RequestMapping("/uploadStudentUI")
    public ModelAndView uploadStudentUI(ModelAndView mv,PageBeanUI pageBeanUI){
        //回显学生信息
        Student student = studentService.findStudentById(pageBeanUI);
        mv.addObject("student",student);
        mv.setViewName("forward:/document/fileUploadStudent.jsp");
        return mv;
    }

    @RequestMapping("/uploadStudent")
    public ModelAndView uploadStudent(ModelAndView mv, StuImage stuImage, MultipartFile uploadImage, HttpSession session) throws IOException {
        //完整路径
        String path = session.getServletContext().getRealPath("/upload");
        File file = new File(path);
        if (!file.exists()){
            file.mkdirs();
        }
        //文件名称
        String filename = uploadImage.getOriginalFilename();

        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        filename = uuid +"_"+ filename;
        uploadImage.transferTo(new File(path,filename));

        stuImage.setImgPath("/"+filename);

        stuImageService.saveStuImage(stuImage);
        mv.setViewName("redirect:/student/studentList");
        return mv;
    }

    @RequestMapping("/deleteStudentById")
    public ModelAndView deleteStudentById(ModelAndView mv,int [] ids){
        for (int i = 0; i < ids.length; i++) {
            System.err.println(ids[i]);
        }

        return mv;
    }

}