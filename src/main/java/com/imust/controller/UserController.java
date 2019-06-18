package com.imust.controller;

import com.github.pagehelper.PageInfo;
import com.imust.domain.PageBeanUI;
import com.imust.domain.User;
import com.imust.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/loginUser")
    public ModelAndView loginUser(ModelAndView mv, User user, HttpSession session){

        User userData = userService.findUserByNameAndPwd(user);
        if (userData == null){
            mv.addObject("errorMsg","用户名或密码错误");
            mv.setViewName("login");
        }else {
            session.setAttribute("loginUser",userData);
            mv.setViewName("redirect:/jsp/main.jsp");
        }
        return mv;
    }

    @RequestMapping("/logoutUser")
    public ModelAndView logoutUser(ModelAndView mv,HttpSession session){
        session.invalidate();
        mv.setViewName("redirect:/jsp/login.jsp");
        return mv;
    }

    @RequestMapping("/userList")
    public ModelAndView userList(ModelAndView mv, PageBeanUI pageBeanUI){
        List<User> list = userService.findUserList(pageBeanUI);
        PageInfo<User> pageBean = new PageInfo<>(list);
        mv.addObject("pageBean",pageBean);
        mv.setViewName("forward:/jsp/user/user.jsp");
        return mv;
    }

    @RequestMapping("/addUser")
    public String addUser(User user,HttpSession session){
        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser !=null && "2".equals(loginUser.getStatus())){
            return "redirect:jsp/500.jsp";
        }else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String createDate = sdf.format(new Date());
            user.setCreateDate(createDate);
            userService.addUser(user);
            return "redirect:userList";
        }
    }

    @RequestMapping("/updateUserUI")
    public ModelAndView updateUserUI(Integer uid,ModelAndView mv) {
        User user = userService.findUserById(uid);
        mv.addObject("user",user);
        mv.setViewName("forward:/jsp/user/showUpdateUser.jsp");
        return mv;
    }

    @RequestMapping("/updateUser")
    public String updateUser(User user) {
        user.setStatus("2");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String createDate = sdf.format(new Date());
        user.setCreateDate(createDate);
        userService.updateUser(user);
        return "redirect:userList";
    }

    @RequestMapping("/deleteById")
    public String deleteById(Integer[] ids) {
        userService.deleteById(ids);
        return "redirect:userList";
    }

}
