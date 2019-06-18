package com.imust.service.impl;

import com.github.pagehelper.PageHelper;
import com.imust.dao.IUserDao;
import com.imust.domain.PageBeanUI;
import com.imust.domain.User;
import com.imust.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;
    @Override
    public List<User> findUserList(PageBeanUI pageBeanUI) {
        PageHelper.startPage(pageBeanUI.getPageNumber(),pageBeanUI.getPageSize());
        return userDao.findUserList(pageBeanUI);
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User findUserByNameAndPwd(User user) {
        return userDao.findUserByNameAndPwd(user);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public User findUserById(Integer uid) {
        return userDao.findUserById(uid);
    }

    @Override
    public void deleteById(Integer[] uid) {
        for(int i : uid){
            userDao.deleteById(i);
        }
    }

    @Override
    public List<User> findUserListByStatus(User user) {
        return userDao.findUserListByStatus(user);
    }


}
