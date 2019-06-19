package com.imust.dao;

import com.imust.domain.BedRoom;
import com.imust.domain.PageBeanUI;
import com.imust.domain.Room;

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

    /**
     * 根据id查询
     * @param pageBeanUI
     * @return
     */
    BedRoom findBedroomById(PageBeanUI pageBeanUI);

    /**
     * 更新操作
     * @param pageBeanUI
     */
    void updateBedroom(PageBeanUI pageBeanUI);

    /**
     * 异步查询bedRoom信息
     * @param room
     * @return
     */
    List<BedRoom> getAjaxBedRoomList(Room room);

    /**
     * 更新床位信息
     * @param pageBeanUI
     */
    void update(PageBeanUI pageBeanUI);

    /**
     * 恢复旧的bedRoom记录
     * @param pageBeanUI
     */
    void updateOldBedRoom(PageBeanUI pageBeanUI);
}
