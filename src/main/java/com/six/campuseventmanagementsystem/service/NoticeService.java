package com.six.campuseventmanagementsystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;

public interface NoticeService {
    /**
     * 根据消息的 发送对象和用户账号 发送消息
     * @return 返回更新记录数
     */
    Integer BulidUserNotice(String Sendto, String Account, String NoticeType, String NoticeAction);


    /**
     * 根据消息的 发送对象和用户账号 创建消息
     * @return 返回更新记录数
     */
    public Integer BulidMatchNotice(Integer MatchId, String Sendto, String Account, String NoticeType, String NoticeAction);
    /**
     * 根据 id 删除消息
     * @return 返回更新记录数
     */
    public Integer DeleteById(Integer id);

    /**
     * 根据 用户账号 查找消息
     * @return 返回IPage类型消息记录
     */
    IPage SelectByToken(Integer page, Integer size, String token);

    /**
     * 赞助商发送消息给自己
     */
    Integer sendNoticeToSelf(String Type,String Message,String Sendto,String UAccount,String State);


}
