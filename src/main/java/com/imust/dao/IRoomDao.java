package com.imust.dao;

import com.imust.domain.Dormitory;
import com.imust.domain.Room;

import java.util.List;

public interface IRoomDao {
    /**
     * 查询所有宿舍
     * @param dormitory
     * @return
     */
    List<Room> findRoomList(Dormitory dormitory);

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
}
