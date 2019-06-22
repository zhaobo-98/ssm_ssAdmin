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


    /**
     * 根据id查询床位信息
     * @param bedRoom
     * @return
     */
    BedRoom findBedroomByBedRoom(BedRoom bedRoom);


    /**
     * 根据id删除床位信息
     * @param bedRoom
     */
    void deleteBedRoomByBedRoom(BedRoom bedRoom);

    /**
     * 根据id查询床位信息
     * @return
     * @param i
     */
    List<BedRoom> findBedroomByIds(int i);

    /**
     * 根据id删除床位
     * @param i
     */
    void deleteBedRoomByRoomId(int i);
}
