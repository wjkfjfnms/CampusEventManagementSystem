package com.six.campuseventmanagementsystem.service.impl;

import com.six.campuseventmanagementsystem.entity.Player;
import com.six.campuseventmanagementsystem.entity.Player2;
import com.six.campuseventmanagementsystem.mapper.Player2Mapper;
import com.six.campuseventmanagementsystem.mapper.PlayerMapper;
import com.six.campuseventmanagementsystem.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PlayerServiceImpl implements PlayerService {
    /**
     * 注入Mapper实例
     */
    @Autowired
    private PlayerMapper playerMapper;
    @Autowired
    private Player2Mapper player2Mapper;


    /**
     * 修改个人账户信息
     * @return 返回更新记录数
     */

    @Override
    public Integer changePMess(Integer id,String headshot, String nickname, String name, String school, String address, String sex, String phone, String age) {
        Player player=new Player();
        Integer result;
        player.setId(id);
        player.setHeadshot(headshot);
        player.setNickname(nickname);
        player.setName(name);
        player.setSchool(school);
        player.setAddress(address);
        player.setSex(sex);
        player.setPhone(phone);
        player.setAge(age);
        result=playerMapper.updateById(player);
        if (result==1){
            System.out.println("修改个人信息成功！");
        }
        else {
            System.out.println("修改个人信息失败！");
        }
        return result;
    }

    /**
     * 删除个人账户信息:即注销账户
     * @return 返回删除记录数
     */

    @Override
    public Integer delePMess(Integer id) {
        Integer result;
        result=playerMapper.deleteById(id);
        if (result==1){
            System.out.println("注销账户成功！");
        }
        else {
            System.out.println("注销账户失败！");
        }
        return result;
    }

    /**
     * 查询个人账户信息:根据主键ID查询
     * @return 返回实体类对象
     */

    @Override
    public Player selePMess(Integer id) {
        return playerMapper.selectById(id);
    }

    //删除赛事选手
    @Override
    public Integer DeleteById(Integer id){
        Player2 player2 = new Player2(id);
        Integer result = player2Mapper.deleteById(player2);
        return result;
    }

    //修改赛事选手
    @Override
    public Integer UpDateById(String name, String sex, Integer id, String school, String type,
                              String items, String time, String address, String position, String state){
        Player2 player2 = new Player2(name, sex, id, school, type, items, time, address, position, state);
        Integer result = player2Mapper.updateById(player2);
        return result;
    }


}
