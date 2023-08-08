package com.six.campuseventmanagementsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.six.campuseventmanagementsystem.entity.*;
import com.six.campuseventmanagementsystem.mapper.*;
import com.six.campuseventmanagementsystem.service.LoginService;
import com.six.campuseventmanagementsystem.service.NoticeService;
import com.six.campuseventmanagementsystem.service.TimeService;
import com.six.campuseventmanagementsystem.service.VettingService;
import com.six.campuseventmanagementsystem.verify.StrVetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VettingServiceImpl implements VettingService {

    @Autowired
    private VettingMapper vettingMapper;
    @Autowired
    private NoticeMapper noticeMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private VisitorMapper visitorMapper;
    @Autowired
    private MatchMapper matchMapper;
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private TimeService timeService;
    @Autowired
    private LoginService loginService;

    /**
     * 根据审核类型和审核内容来生成审核消息  发给所有类型管理员
     * @return 返回更新记录数
     */
    @Override
    public Integer BuildAllVetting(String Account, String VettingType, String VettingAction){
        Integer result;
        StrVetting strVetting = new StrVetting();
        String Time=timeService.getPresentlyTime();
        Vetting avetting = new Vetting(Account+strVetting.Type(VettingType, VettingAction), Account+strVetting.Message(VettingType, VettingAction), Time, "管理员", Account);
        Vetting svetting = new Vetting(Account+strVetting.Type(VettingType, VettingAction), Account+strVetting.Message(VettingType, VettingAction), Time, "超级管理员", Account);
        result = vettingMapper.insert(avetting)+vettingMapper.insert(svetting);
        return result;
    }

    /**
     * 根据审核类型和审核内容来生成审核消息  只发给普通管理员
     * @return 返回更新记录数
     */
    @Override
    public Integer BuildAdminVetting(String Account, String VettingType, String VettingAction){
        Integer result;
        StrVetting strVetting = new StrVetting();
        String Time=timeService.getPresentlyTime();
        Vetting avetting = new Vetting(Account+strVetting.Type(VettingType, VettingAction), Account+strVetting.Message(VettingType, VettingAction), Time, "管理员", Account);
        result = vettingMapper.insert(avetting);
        return result;
    }

    /**
     * 根据 id 删除消息
     * @return 返回更新记录数
     */
    @Override
    public Integer DeleteById(Integer id){
        Integer result;
        Vetting vetting = new Vetting();
        vetting.setId(id);
        result = vettingMapper.deleteById(vetting);
        return result;
    }


    /**
     * 根据管理员类型来查找审核消息
     * @return 返回IPage类型的审核消息
     */
    @Override
    public IPage SelectByToken(Integer page, Integer size, String token){
        if(!token.equals(null)){
            String UserType = loginService.getTokenUserType(token);
            if(UserType.equals("管理员")||UserType.equals("超级管理员")){
                Page<Vetting> vettingpage = new Page<>(page, size);
                QueryWrapper<Vetting> vettingQueryWrapper = new QueryWrapper<>();
                vettingQueryWrapper.eq("Sendto", UserType);
                IPage vettingipage = vettingMapper.selectPage(vettingpage,vettingQueryWrapper);
                return vettingipage;
            }else
                return null;
        }else {
            return null;
        }

    }


    /**
     * 根据 审核消息的id 来同意或拒绝 游客 的申请
     * @return 返回更改记录数
     */
    @Override
    public Integer ChangeUserState(Integer id, String State){
        Integer result;
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        QueryWrapper<Visitor> visitorQueryWrapper = new QueryWrapper<>();
        QueryWrapper<Vetting> vettingQueryWrapper = new QueryWrapper<>();
        vettingQueryWrapper.eq("id", id);
        Vetting vetting = vettingMapper.selectOne(vettingQueryWrapper);
        String Account = vetting.getAccount();
        userQueryWrapper.eq("Account", Account);
        visitorQueryWrapper.eq("Account", Account);
        vetting.setState(State);
        User user = new User();
        Visitor visitor;
        if(State.equals("Y")){
            user.setState(State);
            result = userMapper.update(user, userQueryWrapper) + visitorMapper.delete(visitorQueryWrapper);
            User usertype = userMapper.selectOne(userQueryWrapper);
            if(usertype.getUserType().equals("赞助商")){
                result += noticeService.BulidUserNotice(usertype.getUserType(), Account, "RealName", "zzs") + vettingMapper.update(vetting,vettingQueryWrapper);
            }
            else if(usertype.getUserType().equals("主办方")){
                result += noticeService.BulidUserNotice(usertype.getUserType(), Account, "RealName", "zbf") + vettingMapper.update(vetting,vettingQueryWrapper);
            }else {
                result = 2000;
            }

        }
        else if(State.equals("N")){
            visitor = visitorMapper.selectOne(visitorQueryWrapper);
            result = userMapper.delete(userQueryWrapper);
            result += noticeService.BulidUserNotice(visitor.getUserType(), Account, "RealName", "fail") + vettingMapper.update(vetting,vettingQueryWrapper);
        }else {
            result = 2000;
        }
        return result;
    }


    /**
     * 根据 审核消息的id 来同意或拒绝 主办方赛事 的申请
     * @return 返回更改记录数
     */
    @Override
    public Integer ChangeMatchState(Integer MatchId, String Account, String State){
        Match match = new Match();
        Vetting vetting = new Vetting();
        vetting.setState(State);
        match.setState(State);
        QueryWrapper<Match> matchQueryWrapper = new QueryWrapper<>();
        QueryWrapper<Vetting> vettingQueryWrapper = new QueryWrapper<>();
        vettingQueryWrapper.eq("MatchId", MatchId);
        matchQueryWrapper.eq("id", MatchId);
        Integer result = vettingMapper.update(vetting, vettingQueryWrapper) + matchMapper.update(match, matchQueryWrapper);
        if(State.equals("Y")){
            result += noticeService.BulidMatchNotice(MatchId,"主办方",Account,"Match", "success");
            return result;
        }else if(State.equals("N")){
            result += noticeService.BulidMatchNotice(MatchId,"主办方",Account,"Match", "fail");
            return result;
        }else {
            return null;
        }
    }

    //整合审核
    @Override
    public Integer ChangeState(Integer id, Integer MatchId, String Account, String State){
        Integer result;
        if(id != null){
            result = this.ChangeUserState(id, State);
        }
        else if(MatchId != null&& Account != null){
            result = this.ChangeMatchState(MatchId, Account, State);
        }
        else
            result = 2000;
        return result;
    }


    /**
     * 根据 matchid 生成审核消息  发送给管理员和超级管理员
     * @return 返回更新记录数
     */
    @Override
    public Integer BuildByMatchId(Integer MatchId, String Account, String VettingType, String VettingAction){
        Integer result;
        StrVetting strVetting = new StrVetting();
        String Time=timeService.getPresentlyTime();
        QueryWrapper<Match> matchQueryWrapper = new QueryWrapper<>();
        matchQueryWrapper.eq("id", MatchId);
        Match match = matchMapper.selectOne(matchQueryWrapper);
        String mstr = match.getAccount() + "," + match.getMatchTime() + "," + match.getItems() + " ";
        Vetting pvetting = new Vetting(match.getAccount()+strVetting.Type(VettingType, VettingAction), mstr+strVetting.Message(VettingType, VettingAction), Time, "管理员", Account, MatchId);
        Vetting cvetting = new Vetting(match.getAccount()+strVetting.Type(VettingType, VettingAction), mstr+strVetting.Message(VettingType, VettingAction), Time, "超级管理员", Account, MatchId);
        result = vettingMapper.insert(pvetting) + vettingMapper.insert(cvetting);
        return result;
    }

    /**
     * 赞助商发送消息给超级管理员
     */

    @Override
    public Integer sendNoticeToAdmin(String Type, String Message, String Sendto, String Account, Integer Matchid, String State) {
        //        获取当前时间
        String Time=timeService.getPresentlyTime();
//        自动生成消息ID
        Notice notice = new Notice(Type, Message, Time, Sendto);
        notice.setAAccount(Account);
        notice.setState(State);
        return noticeMapper.insert(notice);
    }

}
