package com.six.campuseventmanagementsystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.six.campuseventmanagementsystem.entity.Admin;
import com.six.campuseventmanagementsystem.entity.Player;
import com.six.campuseventmanagementsystem.entity.SPAdmin;
import com.six.campuseventmanagementsystem.entity.User;

public interface SPAdminService {
    //添加管理员
    Boolean InsertAdmin(String AdminName,String Account,String Password, String NewType);
    //修改管理员
    Boolean UpdateAdmin(Integer ID,String AdminName,String Account,String Password, String NewType);
    //删除管理员
    Boolean DeleteAdmin(Integer ID);
    //注销管理员
    Boolean LogoutAdmin(Integer ID);
    //注销普通用户
    Boolean LogoutUser(Integer ID, String UserType);
    //启用管理员
    Boolean EnableAdmin(Integer ID);
    //启用普通用户
    Boolean EnableUser(Integer ID, String UserType);
    //注销
    Boolean Logout(Integer ID, String UserType);
    //启用
    Boolean Enable(Integer ID, String UserType);
    //查询管理员
    IPage<Admin> SelectAdmin(Integer page, Integer size, String token, String sponsors, String type);
    //查询普通用户
    IPage<User> SelectUser(Integer page, Integer size, String token, String sponsors, String type);
    //查询赛事选手表2
    IPage<Player> SelectPlayer(Integer page, Integer size, String token,String sponsors, String type);
    //查询赛事选手表1
    IPage SelectPlayer1(Integer page, Integer size, String token, String sponsors, String type);
    //修改超级管理员
    Boolean UpdateSPAdmin(Integer ID,String SPAdminName,String Account,String Password,String OldType,String NewType);

    /**
     * 根据SPAdmin的Account查找SPAdmin  个人信息
     * @return 返回IPage类型的SPAdmin信息
     */
    IPage<SPAdmin> SelectByAccount(String Account, String token);
}
