package com.six.campuseventmanagementsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.six.campuseventmanagementsystem.entity.Admin;
import com.six.campuseventmanagementsystem.entity.Match;
import com.six.campuseventmanagementsystem.entity.Player2;
import com.six.campuseventmanagementsystem.entity.Vetting;
import com.six.campuseventmanagementsystem.mapper.MatchMapper;
import com.six.campuseventmanagementsystem.mapper.VettingMapper;
import com.six.campuseventmanagementsystem.service.LoginService;
import com.six.campuseventmanagementsystem.service.MatchService;
import com.six.campuseventmanagementsystem.service.NoticeService;
import com.six.campuseventmanagementsystem.service.VettingService;
import com.six.campuseventmanagementsystem.verify.StrNotice;
import com.six.campuseventmanagementsystem.verify.StrVetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchMapper matchMapper;
    @Autowired
    private VettingMapper vettingMapper;
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private VettingService vettingService;
    @Autowired
    private LoginService loginService;

    /**
     * 根据 创建赛事活动信息 内的数据生成 赛事消息 ，并发送通知和审核申请
     * @return 返回更新记录数
     */
    @Override
    public Integer BuildMatch(String Unit, String UnitAddress, String Type, String Items, String MatchTime, String Place, String Number, String DocumentNumber, String token){
        Integer result;
        String Account = loginService.getTokenAccount(token);
        Match match = new Match(Unit, UnitAddress, Type, Items, MatchTime, Place, Number, DocumentNumber, Account);
        result = matchMapper.insert(match);
        result +=noticeService.BulidMatchNotice(match.getId(), "主办方", Account, "Match", "submit")+
                 vettingService.BuildByMatchId(match.getId(), Account, "Match", "submit");
        return result;
    }

    /**
     * 根据 ID 删除赛事信息
     * @return 返回更新记录数
     */
    @Override
    public Integer DeleteById(Integer ID){
        Integer result = matchMapper.deleteById(ID);
        return result;
    }

    /**
     * 查找所有赛事信息
     * @return 返回更新记录数
     */
    @Override
    public IPage SelectAll(Integer page, Integer size, String token, String sponsors, String type){
        if(!token.equals(null)){
            Page<Match> matchpage = new Page<>(page, size);
            if(sponsors.equals(null)) {
                IPage<Match> matchipage = matchMapper.selectPage(matchpage, null);
                return matchipage;
            }
            else{
                QueryWrapper<Match> matchQueryWrapper = new QueryWrapper<>();
                if(type.equals("单位")){
                    matchQueryWrapper.like("Unit", sponsors);
                }
                else if(type.equals("类型")){
                    matchQueryWrapper.like("Type", sponsors);
                }
                else if(type.equals("事项")){
                    matchQueryWrapper.like("Items", sponsors);
                }
                IPage<Match> matchIPage = matchMapper.selectPage(matchpage, matchQueryWrapper);
                return matchIPage;
            }
        }else
            return null;
    }

    /**
     * 根据ID更改比赛信息
     * @return 返回更新记录数
     */
    @Override
    public Integer UpdateById(String unit, Integer id, String unitAddress, String type,
                       String items, String matchTime, String place, String number,
                       String documentNumber, String state){
        Match match = new Match(unit, id, unitAddress, type, items, matchTime, place, number, documentNumber, state);
        Integer result = matchMapper.updateById(match);
        return result;
    }


}
