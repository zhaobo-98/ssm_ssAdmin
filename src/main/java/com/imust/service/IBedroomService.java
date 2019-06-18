package com.imust.service;

import com.imust.domain.BedRoom;
import com.imust.domain.PageBeanUI;
import com.imust.domain.Room;

import java.util.List;

public interface IBedroomService {

    /**
     * 添加6个床位
     * @param bedRoom
     */
    void addBedroom(BedRoom bedRoom);

    /**
     * 查询床位信息
     * @param pageBeanUI
     * @return
     */
    List<BedRoom> findBedroomList(PageBeanUI pageBeanUI);

    /**
     * 根据id查询
     * @param pageBeanUI
     * @return
     */
    BedRoom findBedroomById(PageBeanUI pageBeanUI);

    /**
     * 入住操作
     * @param pageBeanUI
     */
    void inRoom(PageBeanUI pageBeanUI);

    /**
     * 退住操作
     * @param pageBeanUI
     */
    void outRoom(PageBeanUI pageBeanUI);

    /**
     * 异步查询bedRoom信息
     * @param room
     * @return
     */
    List<BedRoom> getAjaxBedRoomList(Room room);
}
