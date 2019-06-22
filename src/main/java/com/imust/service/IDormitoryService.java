package com.imust.service;

import com.imust.domain.Dormitory;
import com.imust.domain.User;

import java.util.List;

public interface IDormitoryService {
    /**
     * 添加宿舍楼
     * @param dormitory
     */
    void addDormitory(Dormitory dormitory);

    /**
     * 查询所有宿舍楼
     * @return
     */
    List<Dormitory> findDormitoryList(User user);


    /**
     * 根据id查询
     * @param dorId
     * @return
     */
    Dormitory findDormitoryListById(Integer dorId);

    /**
     * 更新宿舍楼信息
     * @param dormitory
     */
    void updateDormitory(Dormitory dormitory);

    /**
     * 根据id删除
     * @param ids
     */
    void deleteDormitoryById(int[] ids);

    /**
     * 查询宿舍楼信息
     * @param dormitory
     * @return
     */
    List<Dormitory> findDormitoryListByUser(Dormitory dormitory);
}
