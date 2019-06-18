package com.imust.service.impl;

import com.github.pagehelper.PageHelper;
import com.imust.dao.IDormitoryDao;
import com.imust.domain.Dormitory;
import com.imust.domain.User;
import com.imust.service.IDormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DormitoryServiceImpl implements IDormitoryService {
    @Autowired
    private IDormitoryDao dormitoryDao;

    @Override
    public void addDormitory(Dormitory dormitory) {
        dormitoryDao.addDormitory(dormitory);
    }

    @Override
    public List<Dormitory> findDormitoryList(User user) {
        return dormitoryDao.findDormitoryList(user);
    }

    @Override
    public Dormitory findDormitoryListById(Integer dorId) {
        return dormitoryDao.findDormitoryListById(dorId);
    }

    @Override
    public void updateDormitory(Dormitory dormitory) {
        dormitoryDao.updateDormitory(dormitory);
    }

    @Override
    public void deleteDormitoryById(Integer[] ids) {
        for (int i : ids) {
            dormitoryDao.deleteDormitoryById(i);
        }
    }

    @Override
    public List<Dormitory> findDormitoryListByUser(Dormitory dormitory) {
        return dormitoryDao.findDormitoryListByUser(dormitory);
    }
}
