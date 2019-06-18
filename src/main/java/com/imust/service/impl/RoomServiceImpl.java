package com.imust.service.impl;

import com.github.pagehelper.PageHelper;
import com.imust.dao.IBedroomDao;
import com.imust.dao.IRoomDao;
import com.imust.domain.*;
import com.imust.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements IRoomService {

    @Autowired
    private IRoomDao roomDao;

    @Autowired
    private IBedroomDao bedroomDao;

    public List<Room> findRoomList(PageBeanUI pageBeanUI) {

        PageHelper.startPage(pageBeanUI.getPageNumber(),pageBeanUI.getPageSize());
        List<Room> list = roomDao.findRoomList(pageBeanUI);
        return list;
    }


    @Override
    public void addRoom(Room room) {
        roomDao.addRoom(room);
        BedRoom bedRoom = new BedRoom();
        bedRoom.setRoom(room);
        for (int i = 1; i <= 6; i++) {
            bedRoom.setIsFlag("N");
            bedRoom.setRoomBedName("0" + i);
            bedroomDao.addBedroom(bedRoom);
        }
    }

    @Override
    public int findTotalRecord() {
        return roomDao.findTotalRecord();
    }

    @Override
    public List<Room> getAjaxRoomList(Dormitory dormitory) {
        return roomDao.getAjaxRoomList(dormitory);
    }
}
