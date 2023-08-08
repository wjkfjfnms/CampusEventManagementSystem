package com.six.campuseventmanagementsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.six.campuseventmanagementsystem.entity.Ads;
import com.six.campuseventmanagementsystem.entity.Prize;
import com.six.campuseventmanagementsystem.mapper.MatchMapper;
import com.six.campuseventmanagementsystem.mapper.PrizeMapper;
import com.six.campuseventmanagementsystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PrizeServiceImpl implements PrizeService {

    /**
     * 注入Mapper实例
     */
    @Autowired
    private PrizeMapper prizeMapper;
    @Autowired
    private VettingService vettingService;
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private AdsService adsService;


    /**
     * 赞助商创建奖品信息
     * @param Sponsorshipfeeds 赞助源
     * @param Sponsorshipgoals 赞助目标
     * @param activityname 所属赛事活动名称
     * @param level 奖品级别
     * @param details 奖品文字描述，250字内
     * @param image 奖品的图片地址
     * @param state 审核状态
     * @param raceID 所属赛事活动的id
     * @param UAccount 当前登录的账号
     * @return 返回创建的奖品信息条数
     */
    @Override
    public Integer InsertPrize(String Sponsorshipfeeds,String Sponsorshipgoals,String activityname,
                               String level,String details,String image,String state,Integer raceID,String UAccount) {
        //先调用方法判断比赛是否开始
        Boolean re=adsService.isBegin(raceID);
        //      生成一个奖品id
        Integer id = prizeMapper.selectMaxprizeID() + 1;
        if (re==false){
//            发送通知给超级管理员
            String message="奖品内容为：奖品ID:"+ String.valueOf(id) +",赞助目标:"+Sponsorshipgoals+",活动:"+activityname+",级别:"+level+",内容:"+details+",图片地址："+image+",审核状态:"+state+",赛事id:"+String.valueOf(raceID);
            vettingService.sendNoticeToAdmin("赞助商创建奖品信息申请",message,"超级管理员",UAccount,raceID,"");
//            发送通知给普通管理员
            vettingService.sendNoticeToAdmin("赞助商创建奖品信息申请",message,"管理员",UAccount,raceID,"");
//            发送通知给自己
            noticeService.sendNoticeToSelf("赞助商创建奖品信息申请",message,"赞助商",UAccount,"");
            return 0;
        }else {
            Prize prize=new Prize();
            prize.setSponsorshipfeeds(Sponsorshipfeeds);
            prize.setId(id);
            prize.setSponsorshipgoals(Sponsorshipgoals);
            prize.setActivityname(activityname);
            prize.setLevel(level);
            prize.setDetails(details);
            prize.setImage(image);
            prize.setState(state);
            prize.setRaceID(raceID);
            return prizeMapper.insert(prize);
        }
    }

    /**
     * 赞助商更新奖品信息
     * @param Sponsorshipfeeds 赞助源
     * @param Sponsorshipgoals 赞助目标
     * @param activityname 所属赛事活动名称
     * @param level 奖品级别
     * @param details 奖品文字描述，250字内
     * @param image 奖品的图片地址
     * @param state 审核状态
     * @param raceID 所属赛事活动的id
     * @param UAccount 当前登录的账号
     * @return 返回更新的奖品信息条数
     */
    @Override
    public Integer UpdatePrize(String Sponsorshipfeeds,String Sponsorshipgoals,String activityname,
                               String level,String details,String image,String state,Integer raceID,String UAccount) {
        //先调用方法判断比赛是否开始
        Boolean re=adsService.isBegin(raceID);
        //      生成一个广告id
        Integer id = prizeMapper.selectMaxprizeID() + 1;
        if (re==false){
//            发送通知给超级管理员
            String message="奖品内容为：奖品ID:"+ String.valueOf(id) +",赞助目标:"+Sponsorshipgoals+",活动:"+activityname+",级别:"+level+",内容:"+details+",图片地址："+image+",审核状态:"+state+",赛事id:"+String.valueOf(raceID);
            vettingService.sendNoticeToAdmin("赞助商修改奖品信息申请",message,"超级管理员",UAccount,raceID,"");
//            发送通知给普通管理员
            vettingService.sendNoticeToAdmin("赞助商修改奖品信息申请",message,"管理员",UAccount,raceID,"");
//            发送通知给自己
            noticeService.sendNoticeToSelf("赞助商修改奖品信息申请",message,"赞助商",UAccount,"");
            return 0;
        }else {
            Prize prize=new Prize();
            prize.setSponsorshipfeeds(Sponsorshipfeeds);
            prize.setId(id);
            prize.setSponsorshipgoals(Sponsorshipgoals);
            prize.setActivityname(activityname);
            prize.setLevel(level);
            prize.setDetails(details);
            prize.setImage(image);
            prize.setState(state);
            prize.setRaceID(raceID);
            return prizeMapper.updateById(prize);
        }
    }

    /**
     * 赞助商删除奖品信息
     * @param raceID 所属赛事id
     * @param id 奖品id
     * @param UAccount 当前登录的账号
     * @return 返回删除的奖品信息条数
     */
    @Override
    public Integer DeletePrize(Integer raceID,Integer id,String UAccount) {
        //先调用方法判断比赛是否开始
        Boolean re=adsService.isBegin(raceID);
//      如果比赛已开始则返回0，提醒请找管理员
        if (re==false){
//            发送通知给超级管理员
            String message="要删除的奖品信息为：奖品id:"+String.valueOf(id)+"赛事id:"+String.valueOf(raceID);
            vettingService.sendNoticeToAdmin("赞助商删除奖品信息申请",message,"超级管理员",UAccount,raceID,"");
//            发送通知给普通管理员
            vettingService.sendNoticeToAdmin("赞助商删除奖品信息申请",message,"管理员",UAccount,raceID,"");
//            发送通知给自己
            noticeService.sendNoticeToSelf("赞助商删除奖品信息申请",message,"赞助商",UAccount,"");
            return 0;
        }else {
            return prizeMapper.deleteById(id);
        }
    }

    /**
     * 管理员新建奖品信息
     * @param Sponsorshipfeeds 赞助源
     * @param Sponsorshipgoals 赞助目标
     * @param activityname 所属赛事活动名称
     * @param level 奖品级别
     * @param details 奖品文字描述，250字内
     * @param image 奖品的图片地址
     * @param state 审核状态
     * @param raceID 所属赛事活动的id
     * @return 返回新建的奖品信息条数
     */
    @Override
    public Integer adminInsertPrize(String Sponsorshipfeeds,String Sponsorshipgoals,String activityname,
                                    String level,String details,String image,String state,Integer raceID) {
        //      生成一个广告id
        Integer id = prizeMapper.selectMaxprizeID() + 1;
        Prize prize=new Prize();
        prize.setSponsorshipfeeds(Sponsorshipfeeds);
        prize.setId(id);
        prize.setSponsorshipgoals(Sponsorshipgoals);
        prize.setActivityname(activityname);
        prize.setLevel(level);
        prize.setDetails(details);
        prize.setImage(image);
        prize.setState(state);
        prize.setRaceID(raceID);
        return prizeMapper.insert(prize);
    }

    /**
     * 管理员更新奖品信息
     * @param id 奖品id
     * @param Sponsorshipfeeds 赞助源
     * @param Sponsorshipgoals 赞助目标
     * @param activityname 所属赛事活动名称
     * @param level 奖品级别
     * @param details 奖品文字描述，250字内
     * @param image 奖品的图片地址
     * @param state 审核状态
     * @param raceID 所属赛事活动的id
     * @return 返回更新的奖品信息条数
     */
    @Override
    public Integer adminUpdatePrize(Integer id,String Sponsorshipfeeds,String Sponsorshipgoals,String activityname,
                                    String level,String details,String image,String state,Integer raceID) {
        Prize prize=new Prize();
        prize.setId(id);
        prize.setSponsorshipfeeds(Sponsorshipfeeds);
        prize.setSponsorshipgoals(Sponsorshipgoals);
        prize.setActivityname(activityname);
        prize.setLevel(level);
        prize.setDetails(details);
        prize.setImage(image);
        prize.setState(state);
        prize.setRaceID(raceID);
        return prizeMapper.updateById(prize);
    }

    /**
     * 管理员删除奖品信息
     * @param id 奖品id
     * @return 返回删除的奖品条数
     */
    @Override
    public Integer adminDeletePrize(Integer id) {
        return prizeMapper.deleteById(id);
    }

    /**
     * 根据活动的名称模糊查询奖品
     * @param pageNumber  表示页码
     * @param pageSize   表示一页显示的条数
     * @param activityname 表示所属活动赛事的名称
     * @return  返回查询到的奖品信息
     */
    @Override
    public IPage<Prize> seleteByPage(int pageNumber, int pageSize, String activityname) {
        //        计算偏移量
        int offset = (pageNumber - 1) * pageSize;
        if(activityname.equals(null)){
            //        查询全部
            Page<Prize> prizePage = new Page<>(offset,pageSize);
            IPage prizeepage = prizeMapper.selectPage(prizePage,null);
            return prizeepage;
        }else {
//            模糊查询
            Page<Prize> prizePage=new Page<>(offset,pageSize);
            QueryWrapper<Prize> queryWrapper=new QueryWrapper<>();
            queryWrapper.like("activityname", activityname);
            IPage<Prize> prizeepage=prizeMapper.selectPage(prizePage,queryWrapper);
            return prizeepage;
        }
    }


}
