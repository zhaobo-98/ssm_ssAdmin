package com.imust.dao;

import com.imust.domain.Dormitory;
import com.imust.domain.PageBeanUI;
import com.imust.domain.Room;

import java.util.List;

public interface IRoomDao {
    /**
     * 查询所有宿舍
     * @param pageBeanUI
     * @return
     */
    List<Room> findRoomList(PageBeanUI pageBeanUI);

    /**
     * 添加宿舍信息
     * @param room
     */
    void addRoom(Room room);

    /**
     * 查询总记录数
     * @return
     */
    int findTotalRecord();

    List<Room> getAjaxRoomList(Dormitory dormitory);

    /**
     * 根据id删除宿舍
     * @param i
     */
    void deleteRoomById(int i);

    /**
     * 根据id查询room
     * @param i
     * @return
     */
    List<Room> findRoomById(int i);

    /**
     * 根据id查询宿舍信息,进行修改
     * @param room
     * @return
     */
    Room findRoomByRoom(Room room);

    /**
     * 更新宿舍信息
     * @param room
     */
    void updateRoom(Room room);
}
