package com.imust.service.impl;

import com.imust.dao.IStuImageDao;
import com.imust.domain.StuImage;
import com.imust.service.IStuImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StuImageServiceImpl implements IStuImageService {
    @Autowired
    private IStuImageDao stuImageDao;
    @Override
    public void saveStuImage(StuImage stuImage) {
        //从数据库查询
        StuImage stuImages = stuImageDao.findStuImageByStuId(stuImage);
        if (stuImages != null){
            stuImageDao.updateStuImageByStuId(stuImage);
        }else {
            stuImageDao.saveStuImage(stuImage);
        }
    }
}
