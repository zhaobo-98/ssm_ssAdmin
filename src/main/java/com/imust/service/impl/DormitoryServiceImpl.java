package com.imust.service.impl;

import com.imust.constant.Constant;
import com.imust.dao.IDormitoryDao;
import com.imust.dao.IRoomDao;
import com.imust.domain.Dormitory;
import com.imust.domain.Room;
import com.imust.domain.User;
import com.imust.service.IDormitoryService;
import com.imust.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DormitoryServiceImpl implements IDormitoryService {
    @Autowired
    private IDormitoryDao dormitoryDao;

    @Autowired
    private IRoomDao roomDao;
    @Override
    public void addDormitory(Dormitory dormitory) {
        dormitoryDao.addDormitory(dormitory);
    }

    @Override
    public List<Dormitory> findDormitoryList(User user) {
        return dormitoryDao.findDormitoryList(user);
    }

    @Override
    public Dormitory findDormitoryListById(Integer dorId) {
        return dormitoryDao.findDormitoryListById(dorId);
    }

    @Override
    public void updateDormitory(Dormitory dormitory) {
        dormitoryDao.updateDormitory(dormitory);
    }

    @Override
    public void deleteDormitoryById(int[] ids) {
        for (int i : ids) {
            List<Room> roomList = roomDao.findRoomById(i);
            if (roomList.size() != 0){
                throw new RuntimeException(Constant.DORMITORY_HAVE_ROOM);
            }else {
                dormitoryDao.deleteDormitoryById(i);
            }
        }
    }

    @Override
    public List<Dormitory> findDormitoryListByUser(Dormitory dormitory) {
        return dormitoryDao.findDormitoryListByUser(dormitory);
    }
}
