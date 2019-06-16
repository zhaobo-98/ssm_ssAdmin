package com.imust.service;

import com.imust.domain.BedRoom;
import com.imust.domain.PageBeanUI;

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
}
