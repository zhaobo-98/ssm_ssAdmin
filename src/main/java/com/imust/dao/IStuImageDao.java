package com.imust.dao;

import com.imust.domain.StuImage;

public interface IStuImageDao {
    /**
     * 添加上传信息
     * @param stuImage
     */
    void saveStuImage(StuImage stuImage);


    /**
     * 根据学生id从数据库进行查询
     * @param stuImage
     * @return
     */
    StuImage findStuImageByStuId(StuImage stuImage);

    /**
     * 修改学生头像
     * @param stuImage
     */
    void updateStuImageByStuId(StuImage stuImage);

    /**
     * 删除头像信息
     * @param stuId
     */
    void deleteStuImageById(int stuId);
}
