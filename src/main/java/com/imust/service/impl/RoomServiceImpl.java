package com.imust.service.impl;

import com.imust.dao.IRoomDao;
import com.imust.domain.PageBeanUI;
import com.imust.domain.Room;
import com.imust.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements IRoomService {

    @Autowired
    private IRoomDao roomDao;

    public List<Room> findRoomList(PageBeanUI pageBeanUI) {
        return roomDao.findRoomList(pageBeanUI);
    }

    @Override
    public void addRoom(Room room) {
        roomDao.addRoom(room);
    }
}
