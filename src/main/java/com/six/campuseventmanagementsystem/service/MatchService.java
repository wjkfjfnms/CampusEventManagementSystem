package com.six.campuseventmanagementsystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;

public interface MatchService {

    /**
     * 根据 创建赛事活动信息 内的数据生成 赛事消息 ，并发送通知和申请
     * @return 返回更新记录数
     */
    Integer BuildMatch(String Unit, String UnitAddress, String Type, String Items, String MatchTime,
                       String Place, String Number, String DocumentNumber, String token);

    /**
     * 根据 ID 删除赛事信息
     * @return 返回更新记录数
     */
    Integer DeleteById(Integer ID);

    /**
     * 查找所有赛事信息
     * @return 返回更新记录数
     */
    IPage SelectAll(Integer page, Integer size, String token, String sponsors, String type);


    /**
     * 根据ID更改比赛信息
     * @return 返回更新记录数
     */
    Integer UpdateById(String unit, Integer id, String unitAddress, String type,
                       String items, String matchTime, String place, String number,
                       String documentNumber, String state);


}
