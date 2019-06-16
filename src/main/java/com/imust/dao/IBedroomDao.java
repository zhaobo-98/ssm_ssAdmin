package com.imust.dao;

import com.imust.domain.BedRoom;
import com.imust.domain.PageBeanUI;

import java.util.List;

public interface IBedroomDao {

    /**
     * 添加6个床位
     */
    void addBedroom(BedRoom bedRoom);

    /**
     * 查询床位信息
     * @param pageBeanUI
     * @return
     */
    List<BedRoom> findBedroomList(PageBeanUI pageBeanUI);
}
