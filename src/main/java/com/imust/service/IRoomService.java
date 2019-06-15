package com.imust.service;

import com.imust.domain.Dormitory;
import com.imust.domain.Room;

import java.util.List;

public interface IRoomService {

    /**
     * 查询宿舍信息
     * @param dormitory
     * @return
     */
    List<Room> findRoomList(Dormitory dormitory, Integer pageNumber, Integer pageSize);

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
}
