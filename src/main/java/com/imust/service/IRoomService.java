package com.imust.service;

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
}
