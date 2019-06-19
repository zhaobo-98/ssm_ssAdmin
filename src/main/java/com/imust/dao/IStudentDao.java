package com.imust.dao;

import com.imust.domain.PageBeanUI;
import com.imust.domain.Student;

import java.util.List;

public interface IStudentDao {

    /**
     * 添加学生信息
     * @param pageBeanUI
     */
    void addStudent(PageBeanUI pageBeanUI);

    /**
     * 根据id删除学生信息
     * @param stuId
     */
    void deleteById(int stuId);

    /**
     * 查询学生信息
     * @param pageBeanUI
     * @return
     */
    List<Student> findStudentList(PageBeanUI pageBeanUI);

    /**
     * 添加学生信息
     * @param pageBeanUI
     */
    void saveStudent(PageBeanUI pageBeanUI);


    Student findStudentById(PageBeanUI pageBeanUI);

    /**
     * 更新学生信息
     * @param pageBeanUI
     */
    void updateStudent(PageBeanUI pageBeanUI);
}
