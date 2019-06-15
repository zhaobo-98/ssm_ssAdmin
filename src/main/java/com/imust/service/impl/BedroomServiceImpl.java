package com.imust.service.impl;

import com.imust.dao.IBedroomDao;
import com.imust.domain.BedRoom;
import com.imust.service.IBedroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BedroomServiceImpl implements IBedroomService {
    @Autowired
    private IBedroomDao bedroomDao;

    @Override
    public void addBedroom(BedRoom bedRoom) {
        bedroomDao.addBedroom(bedRoom);
    }

}
