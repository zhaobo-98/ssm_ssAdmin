package com.imust.service;

import com.imust.domain.PageBeanUI;
import com.imust.domain.User;

import java.util.List;

public interface IUserService {
    /**
     * 查询用户列表
     * @return
     * @param pageBeanUI
     */
    List<User> findUserList(PageBeanUI pageBeanUI);

    /**
     * 保存用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 根据用户名和密码登录
     * @param user
     * @return
     */
    User findUserByNameAndPwd(User user);

    /**
     * 添加用户
     * @param user
     */
    void addUser(User user);

    /**
     * 修改用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据id查询
     * @param uid
     * @return
     */
    User findUserById(Integer uid);

    /**
     * 根据id删除
     * @param uid
     */
    void deleteById(Integer[] uid);

    /**
     * 根据status查询username
     * @param user
     * @return
     */
    List<User> findUserListByStatus(User user);
}
