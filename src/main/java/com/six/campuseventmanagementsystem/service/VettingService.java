package com.six.campuseventmanagementsystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;

public interface VettingService {
    /**
     * 根据审核类型和审核内容来生成审核消息 发给所有类型管理员
     * @return 返回更新记录数
     */
    Integer BuildAllVetting(String Account, String VettingType, String VettingAction);


    /**
     * 根据审核类型和审核内容来生成审核消息  只发给普通管理员
     * @return 返回更新记录数
     */
    public Integer BuildAdminVetting(String Account, String VettingType, String VettingAction);


    /**
     * 根据 id 删除消息
     * @return 返回更新记录数
     */
    public Integer DeleteById(Integer id);


    /**
     * 根据用户类型来查找审核消息
     * @return 返回IPage类型的审核消息
     */
    IPage SelectByToken(Integer page, Integer size, String token);


    /**
     * 根据 审核消息的id 来 同意or拒绝 申请
     * @return 返回更改记录数
     */
    Integer ChangeUserState(Integer id, String State);


    /**
     * 根据 审核消息的id 来 同意or拒绝 主办方赛事 的申请
     * @return 返回更改记录数
     */
    Integer ChangeMatchState(Integer MatchId, String Account, String State);

    //整合审核
    Integer ChangeState(Integer id, Integer MatchId, String Account, String State);


    /**
     * 根据 matchid 生成审核消息  发送给管理员和超级管理员
     * @return 返回更新记录数
     */
    Integer BuildByMatchId(Integer MatchId, String Account, String VettingType, String VettingAction);

    /**
     * 赞助商发送消息给超级管理员和管理员
     */
    Integer sendNoticeToAdmin(String Type,String Message,String Sendto,String Account,Integer Matchid,String State);

}
