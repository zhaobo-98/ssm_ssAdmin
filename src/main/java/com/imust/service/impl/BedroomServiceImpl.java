package com.imust.service.impl;

import com.github.pagehelper.PageHelper;
import com.imust.constant.Constant;
import com.imust.dao.IBedroomDao;
import com.imust.dao.IStudentDao;
import com.imust.domain.BedRoom;
import com.imust.domain.PageBeanUI;
import com.imust.domain.Room;
import com.imust.service.IBedroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BedroomServiceImpl implements IBedroomService {
    @Autowired

    private IBedroomDao bedroomDao;

    @Autowired
    private IStudentDao studentDao;
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

    @Override
    public BedRoom findBedroomById(PageBeanUI pageBeanUI) {
        return bedroomDao.findBedroomById(pageBeanUI);
    }

    @Override
    public void inRoom(PageBeanUI pageBeanUI) {

        studentDao.addStudent(pageBeanUI);
        bedroomDao.updateBedroom(pageBeanUI);
    }

    @Override
    public void outRoom(PageBeanUI pageBeanUI) {
        // 修改入住状态
        bedroomDao.updateBedroom(pageBeanUI);
        //删除学生信息
        studentDao.deleteById(pageBeanUI.getStuId());
    }

    @Override
    public List<BedRoom> getAjaxBedRoomList(Room room) {
        return bedroomDao.getAjaxBedRoomList(room);
    }

    @Override
    public BedRoom findBedroomByBedRoom(BedRoom bedRoom) {
        return bedroomDao.findBedroomByBedRoom(bedRoom);
    }

    @Override
    public void deleteBedRoomByBedRoom(BedRoom bedRoom) {
        //先查询当前床位下是否学生居住,如果有抛异常,如果没有真实删除床位
        BedRoom bedroom = bedroomDao.findBedroomByBedRoom(bedRoom);
        if (bedroom != null){
            throw new RuntimeException(Constant.BEDROOM_HAVE_STUDENT);
        }else {
            bedroomDao.deleteBedRoomByBedRoom(bedRoom);
        }
    }

}
