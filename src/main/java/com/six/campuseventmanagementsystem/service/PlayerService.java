package com.six.campuseventmanagementsystem.service;

import com.six.campuseventmanagementsystem.entity.Player;


public interface PlayerService {
    /**
     * 根据ID修改个人账户信息
     * @return 返回更新记录数
     */

    Integer changePMess(Integer id, String headshot, String nickname, String name, String school,
                        String address, String sex, String phone, String age);

    /**
     *根据ID删除个人账户信息：注销账户
     * @return 返回删除记录数
     */
    Integer delePMess(Integer id);

    /**
     *根据ID查询个人账户信息
     * @return 返回实体类对象
     */
    Player selePMess(Integer id);

    /**
     *根据ID删除player2账户信息：注销账户
     * @return 返回删除记录数
     */
    Integer DeleteById(Integer id);

    /**
     *根据ID修改pleayer2个人账户信息
     * @return 返回修改记录数
     */
    Integer UpDateById(String name, String sex, Integer id, String school, String type,
                       String items, String time, String address, String position, String state);
}
