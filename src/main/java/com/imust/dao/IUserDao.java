package com.imust.dao;

import com.imust.domain.PageBeanUI;
import com.imust.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserDao {
    /**
     * 查询用户列表
     * @return
     */
    List<User> findUserList(PageBeanUI pageBeanUI);

    /**
     * 根据用户名和密码登录
     * @param user
     * @return
     */
    User findUserByNameAndPwd(User user);

    /**
     * 保存用户
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
    void deleteById(int uid);

    /**
     * 根据status查询
     * @param user
     * @return
     */
    List<User> findUserListByStatus(User user);

    List<User> findUsers();
}
