package com.imust.dao;

import com.imust.domain.BedRoom;
import com.imust.domain.Room;

public interface IBedroomDao {

    /**
     * 添加6个床位
     */
    void addBedroom(Room room, BedRoom bedRoom);
}
