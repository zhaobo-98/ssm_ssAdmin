package com.imust.dao;

import com.imust.domain.StuImage;

public interface IStuImageDao {
    /**
     * 添加上传信息
     * @param stuImage
     */
    void saveStuImage(StuImage stuImage);
}
