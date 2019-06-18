package com.imust.service;

import com.imust.domain.Dormitory;
import com.imust.domain.PageBeanUI;
import com.imust.domain.Room;

import java.util.List;

public interface IRoomService {

    /**
     * 查询宿舍信息
     * @param pageBeanUI
     * @return
     */
    List<Room> findRoomList(PageBeanUI pageBeanUI);

    /**
     * 添加宿舍
     * @param room
     */
    void addRoom(Room room);

    /**
     * 查询总记录数
     * @return
     */
    int findTotalRecord();

    /**
     * 异步查询room信息
     * @param dormitory
     * @return
     */
    List<Room> getAjaxRoomList(Dormitory dormitory);
}
