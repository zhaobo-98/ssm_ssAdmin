package com.imust.service.impl;

import com.github.pagehelper.PageHelper;
import com.imust.dao.IBedroomDao;
import com.imust.dao.IStudentDao;
import com.imust.domain.BedRoom;
import com.imust.domain.PageBeanUI;
import com.imust.domain.Student;
import com.imust.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentDao studentDao;

    @Autowired
    private IBedroomDao bedroomDao;
    @Override
    public List<Student> findStudentList(PageBeanUI pageBeanUI) {
        PageHelper.startPage(pageBeanUI.getPageNumber(),pageBeanUI.getPageSize());
        return studentDao.findStudentList(pageBeanUI);
    }

    @Override
    public void saveStudent(PageBeanUI pageBeanUI) {
        studentDao.saveStudent(pageBeanUI);
        bedroomDao.update(pageBeanUI);
    }

    @Override
    public Student findStudentById(PageBeanUI pageBeanUI) {
        return studentDao.findStudentById(pageBeanUI);
    }
}
