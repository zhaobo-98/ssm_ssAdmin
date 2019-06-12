package com.imust.service.impl;

import com.imust.dao.IBedroomDao;
import com.imust.domain.BedRoom;
import com.imust.domain.Room;
import com.imust.service.IBedroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BedroomServiceImpl implements IBedroomService {
    @Autowired
    private IBedroomDao bedroomDao;

    @Override
    public void addBedroom(Room room, BedRoom bedRoom) {
        for (int i = 0; i < 6; i++) {
            bedRoom.setIsFlag("N");
            bedRoom.setRoomBedName(String.valueOf(1+1));
            bedroomDao.addBedroom(room, bedRoom);
        }
    }
}
