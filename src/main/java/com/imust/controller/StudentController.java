package com.imust.controller;

import com.github.pagehelper.PageInfo;
import com.imust.domain.Dormitory;
import com.imust.domain.PageBeanUI;
import com.imust.domain.Student;
import com.imust.domain.User;
import com.imust.service.IDormitoryService;
import com.imust.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @Autowired
    private IDormitoryService dormitoryService;
    @RequestMapping("/studentList")
    public ModelAndView studentList(ModelAndView mv, HttpSession session, PageBeanUI pageBeanUI){
        User userData = (User) session.getAttribute("loginUser");
        List<Dormitory> dormitoryList = null;
        System.err.println(pageBeanUI);
        if (userData != null && "2".equals(userData.getStatus())){
            pageBeanUI.setLoginUser(userData);
            dormitoryList = dormitoryService.findDormitoryList(userData);
        }else{
            pageBeanUI.setLoginUser(null);
            dormitoryList = dormitoryService.findDormitoryList(null);
        }
        List<Student> studentList = studentService.findStudentList(pageBeanUI);
        PageInfo<Student> pageBean = new PageInfo<>(studentList,10);
        mv.addObject("pageBean",pageBean);
        mv.addObject("dormitoryList",dormitoryList);
        mv.addObject("pageBeanUI",pageBeanUI);
        mv.setViewName("forward:/jsp/student/student.jsp");
        return mv;
    }

    @RequestMapping("/addStudentUI")
    public ModelAndView addStudent(ModelAndView mv,HttpSession session){
        User userData = (User) session.getAttribute("loginUser");
        List<Dormitory> dormitoryList = null;
        if (userData != null && "2".equals(userData.getStatus())){
            dormitoryList = dormitoryService.findDormitoryList(userData);
        }else{
            dormitoryList = dormitoryService.findDormitoryList(null);
        }
        mv.addObject("dormitoryList",dormitoryList);
        mv.setViewName("forward:/jsp/student/showAddStudent.jsp");
        return mv;
    }

    @RequestMapping("/addStudent")
    public String addStudent(PageBeanUI pageBeanUI){
        System.err.println(pageBeanUI);
        studentService.saveStudent(pageBeanUI);
        return "redirect:/student/studentList";
    }

    @RequestMapping("/updateStudentUI")
    public ModelAndView updateStudentUI(ModelAndView mv,PageBeanUI pageBeanUI){
        Student student = studentService.findStudentById(pageBeanUI);
        mv.addObject("student",student);
        mv.setViewName("forward:/jsp/student/showUpdateStudent.jsp");
        return mv;
    }
}
