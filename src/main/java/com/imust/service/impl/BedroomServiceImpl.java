package com.imust.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imust.dao.IBedroomDao;
import com.imust.domain.BedRoom;
import com.imust.domain.PageBeanUI;
import com.imust.service.IBedroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BedroomServiceImpl implements IBedroomService {
    @Autowired
    private IBedroomDao bedroomDao;

    @Override
    public void addBedroom(BedRoom bedRoom) {
        bedroomDao.addBedroom(bedRoom);
    }

    @Override
    public List<BedRoom> findBedroomList(PageBeanUI pageBeanUI) {

        PageHelper.startPage(pageBeanUI.getPageNumber(),pageBeanUI.getPageSize());
        List<BedRoom> bedRoomList = bedroomDao.findBedroomList(pageBeanUI);
        return bedRoomList;
    }

}
