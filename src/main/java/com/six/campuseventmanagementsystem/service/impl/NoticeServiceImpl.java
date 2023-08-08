package com.six.campuseventmanagementsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.six.campuseventmanagementsystem.entity.Notice;
import com.six.campuseventmanagementsystem.entity.Match;
import com.six.campuseventmanagementsystem.mapper.MatchMapper;
import com.six.campuseventmanagementsystem.mapper.NoticeMapper;
import com.six.campuseventmanagementsystem.service.LoginService;
import com.six.campuseventmanagementsystem.service.NoticeService;
import com.six.campuseventmanagementsystem.service.TimeService;
import com.six.campuseventmanagementsystem.verify.StrNotice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;
    @Autowired
    private MatchMapper matchMapper;
    @Autowired
    private TimeService timeService;
    @Autowired
    private LoginService loginService;

    /**
     * 根据消息的 发送对象和用户账号 创建消息
     * @return 返回更新记录数
     */
    @Override
    public Integer BulidUserNotice(String Sendto, String Account, String NoticeType, String NoticeAction){
        Integer result;
        if(Sendto.equals("赞助商")||Sendto.equals("主办方")) {
            StrNotice strNotice = new StrNotice();
            String Time = timeService.getPresentlyTime();
            Notice notice = new Notice(Account + strNotice.Type(NoticeType, NoticeAction), Account + strNotice.Message(NoticeType, NoticeAction), Time, Sendto, Account);
            result = noticeMapper.insert(notice);
        }
        else if(Sendto.equals("管理员")){
            StrNotice strNotice = new StrNotice();
            String Time = timeService.getPresentlyTime();
            Notice notice = new Notice(Account + strNotice.Type(NoticeType, NoticeAction), Account + strNotice.Message(NoticeType, NoticeAction), Time, Sendto);
            notice.setAAccount(Account);
            result = noticeMapper.insert(notice);
        }else
            result = null;
        return result;
    }


    /**
     * 根据消息的 发送对象和用户账号 创建赛事消息
     * @return 返回更新记录数
     */
    @Override
    public Integer BulidMatchNotice(Integer MatchId, String Sendto, String Account, String NoticeType, String NoticeAction){
        Integer result;
        StrNotice strNotice = new StrNotice();
        String Time=timeService.getPresentlyTime();
        QueryWrapper<Match> matchQueryWrapper = new QueryWrapper<>();
        matchQueryWrapper.eq("id", MatchId);
        Match match = matchMapper.selectOne(matchQueryWrapper);
        String mstr = match.getMatchTime() + "," + match.getItems() + " ";
        Notice notice = new Notice(mstr+strNotice.Type(NoticeType, NoticeAction), mstr+strNotice.Message(NoticeType, NoticeAction), Time, Sendto, Account);
        result = noticeMapper.insert(notice);
        return result;
    }


    /**
     * 根据 id 删除消息
     * @return 返回更新记录数
     */
    @Override
    public Integer DeleteById(Integer id){
        Integer result;
        Notice notice = new Notice();
        notice.setId(id);
        result = noticeMapper.deleteById(notice);
        return result;
    }

    /**
     * 根据 用户账号 查找消息
     * @return 返回IPage类型消息记录
     */
    @Override
    public IPage SelectByToken(Integer page, Integer size, String token){
        if(!token.equals(null)){
            String UserType = loginService.getTokenUserType(token);
            String Account = loginService.getTokenAccount(token);
            Page<Notice> noticepage = new Page<>(page,size);
            QueryWrapper<Notice> noticeQueryWrapper = new QueryWrapper<>();
            if(UserType.equals("赞助商")||UserType.equals("主办方")){
                noticeQueryWrapper.eq("UAccount", Account);
                IPage noticeipage = noticeMapper.selectPage(noticepage,noticeQueryWrapper);
                return noticeipage;
            }
            else if(UserType.equals("管理员")){
                noticeQueryWrapper.eq("AAccount", Account);
                IPage noticeipage = noticeMapper.selectPage(noticepage,noticeQueryWrapper);
                return noticeipage;
            }else {
                return null;
            }
        }else {
            return null;
        }
    }

    /**
     * 赞助商发送消息给自己
     */

    @Override
    public Integer sendNoticeToSelf(String Type, String Message, String Sendto, String UAccount,String State) {
//        获取当前时间
        String Time=timeService.getPresentlyTime();
//        自动生成消息ID
        int ID=noticeMapper.selectMaxId()+1;
        Notice notice=new Notice();
        notice.setId(ID);
        notice.setType(Type);
        notice.setMessage(Message);
        notice.setTime(Time);
        notice.setSendto(Sendto);
        notice.setUAccount(UAccount);
        notice.setState(State);
        return noticeMapper.insert(notice);
    }
}
