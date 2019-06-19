package com.imust.service;

import com.imust.domain.PageBeanUI;
import com.imust.domain.Student;

import java.util.List;

public interface IStudentService {
    /**
     * 查询学生信息
     * @param pageBeanUI
     * @return
     */
    List<Student> findStudentList(PageBeanUI pageBeanUI);

    /**
     * 添加学生信息
     */
    void saveStudent(PageBeanUI pageBeanUI);

    /**
     * 根据id查询student
     * @param pageBeanUI
     * @return
     */
    Student findStudentById(PageBeanUI pageBeanUI);

    /**
     * 更新学生信息
     * @param pageBeanUI
     */
    void updateStudent(PageBeanUI pageBeanUI);
}
