package com.six.campuseventmanagementsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.six.campuseventmanagementsystem.entity.Admin;
import com.six.campuseventmanagementsystem.entity.Ads;
import com.six.campuseventmanagementsystem.entity.Match;
import com.six.campuseventmanagementsystem.mapper.AdsMapper;
import com.six.campuseventmanagementsystem.mapper.MatchMapper;
import com.six.campuseventmanagementsystem.service.AdsService;
import com.six.campuseventmanagementsystem.service.NoticeService;
import com.six.campuseventmanagementsystem.service.TimeService;
import com.six.campuseventmanagementsystem.service.VettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.AbstractList;
import java.util.List;

@Service
public class AdsServiceImpl implements AdsService {

    /**
     * 注入Mapper实例
     */
    @Autowired
    private AdsMapper adsMapper;
    @Autowired
    private MatchMapper matchMapper;
    @Autowired
    private TimeService timeService;
    @Autowired
    private VettingService vettingService;
    @Autowired
    private NoticeService noticeService;

    String presentlyTime;
    String raceBeginTime;



    /**
     * 获取该比赛的开始时间
     * @param raceID 赛事id
     * @return 返回该比赛的开始时间
     */
    @Override
    public String getRaceBeginTime(Integer raceID) {
        Match match=matchMapper.selectById(raceID);
        raceBeginTime=match.getMatchTime();
        return raceBeginTime;
    }

    /**
     * 根据赛事的id和比赛的开始时间，判断比赛是否已经开始
     * @param raceID：赛事id（来自前端）
     * @return true 比赛未开始，可以修改广告信息
     * @return false 比赛已开始，修改广告信息请找管理员
     */
    @Override
    public Boolean isBegin(Integer raceID) {
//        获取系统当前时间
        presentlyTime=timeService.getPresentlyDate();
//        根据赛事id获取比赛开始时间
        raceBeginTime=this.getRaceBeginTime(raceID);

//        比较赛事是否开始
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.print(presentlyTime);
        System.out.print(raceBeginTime);
        LocalDate localDateTime1 = LocalDate.parse(presentlyTime, formatter);
        LocalDate localDateTime2 = LocalDate.parse(raceBeginTime, formatter);

        if (localDateTime1.isBefore(localDateTime2)){
            System.out.println("比赛未开始");
            return true;
        } else {
            System.out.println("比赛已开始");
            return false;
        }

    }

    /**
     * 赞助商新建广告信息
     * @param sponsors 赞助商名称
     * @param adsType 广告类型
     * @param videoAdress 视频广告地址
     * @param imageAdress 图片海报广告地址
     * @param state 广告审核状态
     * @param Items 该广告所属的赛事项目名称
     * @param id 该广告所属的赛事项目id
     * @param UAccount 正在登录的用户账号
     * @return 返回创建的广告条数
     */
    @Override
    public Integer createAds(String sponsors,String adsType,String videoAdress,String imageAdress,String state,String Items,Integer id,String UAccount) {
//        先调用方法判断比赛是否开始
        Boolean re = this.isBegin(id);
//      如果比赛已开始则返回0，发送通知给自己和两种管理员
//      生成一个广告id
        Integer ads_id = adsMapper.selectMaxadsID() + 1;
        if (re == false) {
//            发送通知给超级管理员
            String message = "广告内容为：广告ID:" + String.valueOf(ads_id) + ",赞助商:" + sponsors + ",广告类型:" + adsType + ",视频地址:" + videoAdress + ",图片地址:" + imageAdress + ",审核状态:" + state + ",赛事项目:" + Items + ",赛事id:" + String.valueOf(id);
            vettingService.sendNoticeToAdmin("赞助商创建广告信息申请", message, "超级管理员", UAccount, id, "");
//            发送通知给普通管理员
            vettingService.sendNoticeToAdmin("赞助商创建广告信息申请", message, "管理员", UAccount, id, "");
//            发送通知给自己
            noticeService.sendNoticeToSelf("赞助商创建广告信息申请", message, "赞助商", UAccount, "");
            return 0;
        } else {
            Ads ads = new Ads();
            ads.setAds_id(ads_id);
            ads.setSponsors(sponsors);
            ads.setAdsType(adsType);
            ads.setVideoAdress(videoAdress);
            ads.setImageAdress(imageAdress);
            ads.setState(state);
            ads.setItems(Items);
            ads.setId(id);
            return adsMapper.insert(ads);
        }
    }

    /**
     * 管理员创建广告信息
     * @param sponsors 赞助商名称
     * @param adsType 广告类型
     * @param videoAdress 视频广告地址
     * @param imageAdress 图片海报广告地址
     * @param state 广告审核状态
     * @param Items 该广告所属的赛事项目名称
     * @param id 该广告所属的赛事项目id
     * @return 返回创建的广告条数
     */

    @Override
    public Integer adminCreateAds(String sponsors, String adsType, String videoAdress, String imageAdress, String state, String Items, Integer id) {
        //      生成一个广告id
        Integer ads_id =adsMapper.selectMaxadsID() + 1;
        Ads ads=new Ads();
        ads.setAds_id(ads_id);
        ads.setSponsors(sponsors);
        ads.setAdsType(adsType);
        ads.setVideoAdress(videoAdress);
        ads.setImageAdress(imageAdress);
        ads.setState(state);
        ads.setItems(Items);
        ads.setId(id);
        return adsMapper.insert(ads);
    }

    /**
     * 赞助商修改广告信息
     * @param ads_id :广告id
     * @param sponsors 赞助商名称
     * @param adsType 广告类型
     * @param videoAdress 视频广告地址
     * @param imageAdress 图片海报广告地址
     * @param state 广告审核状态
     * @param Items 该广告所属的赛事项目名称
     * @param id 该广告所属的赛事项目id
     * @param UAccount 正在登录的用户账号
     * @return 返回更新的广告条数
     */
    @Override
    public Integer updateAds(Integer ads_id,String sponsors,String adsType,String videoAdress,String imageAdress,String state,String Items,Integer id,String UAccount) {
        //先调用方法判断比赛是否开始
        Boolean re=this.isBegin(id);
//      如果比赛已开始则返回0，提醒请找管理员
        if (re==false){
//            发送通知给超级管理员
            String message="广告内容为：广告ID:"+String.valueOf(ads_id)+",赞助商:"+sponsors+",广告类型:"+adsType+",视频地址:"+videoAdress+",图片地址:"+imageAdress+",审核状态:"+state+",赛事项目:"+Items+",赛事id:"+String.valueOf(id);
            vettingService.sendNoticeToAdmin("赞助商修改广告信息申请",message,"超级管理员",UAccount,id,"");
//            发送通知给普通管理员
            vettingService.sendNoticeToAdmin("赞助商修改广告信息申请",message,"管理员",UAccount,id,"");
//            发送通知给自己
            noticeService.sendNoticeToSelf("赞助商修改广告信息申请",message,"赞助商",UAccount,"");
            return 0;
        }else {
            Ads ads=new Ads();
            ads.setAds_id(ads_id);
            ads.setSponsors(sponsors);
            ads.setAdsType(adsType);
            ads.setVideoAdress(videoAdress);
            ads.setImageAdress(imageAdress);
            ads.setState(state);
            ads.setItems(Items);
            ads.setId(id);
            return adsMapper.updateById(ads);
        }
    }

    /**
     * 管理员修改广告信息
     * @param ads_id :广告id
     * @param sponsors 赞助商名称
     * @param adsType 广告类型
     * @param videoAdress 视频广告地址
     * @param imageAdress 图片海报广告地址
     * @param state 广告审核状态
     * @param Items 该广告所属的赛事项目名称
     * @param id 该广告所属的赛事项目id
     * @return 返回更新的广告条数
     */

    @Override
    public Integer adminUpdateAds(Integer ads_id, String sponsors, String adsType, String videoAdress, String imageAdress, String state, String Items, Integer id) {
        Ads ads=new Ads();
        ads.setAds_id(ads_id);
        ads.setSponsors(sponsors);
        ads.setAdsType(adsType);
        ads.setVideoAdress(videoAdress);
        ads.setImageAdress(imageAdress);
        ads.setState(state);
        ads.setItems(Items);
        ads.setId(id);
        return adsMapper.updateById(ads);
    }

    /**
     * 赞助商根据广告id和赛事id删除广告信息
     * @param ads_id:广告id
     * @param id 赛事id
     * @param UAccount 正在登录的用户账号
     * @return 返回删除的广告条数
     */
    @Override
    public Integer deleteAds(Integer ads_id,Integer id,String UAccount) {
        //先调用方法判断比赛是否开始
        Boolean re=this.isBegin(id);
//      如果比赛已开始则返回0，提醒请找管理员
        if (re==false){
//            发送通知给超级管理员
            String message="要删除的广告为：广告ID:"+String.valueOf(ads_id)+"赛事id:"+String.valueOf(id);
            vettingService.sendNoticeToAdmin("赞助商删除广告信息申请",message,"超级管理员",UAccount,id,"");
//            发送通知给普通管理员
            vettingService.sendNoticeToAdmin("赞助商删除广告信息申请",message,"管理员",UAccount,id,"");
//            发送通知给自己
            noticeService.sendNoticeToSelf("赞助商删除广告信息申请",message,"赞助商",UAccount,"");
            return 0;
        }else {
            return adsMapper.deleteById(ads_id);
        }
    }

    /**
     * 管理员删除广告信息
     * @param ads_id:广告id
     * @return 返回删除的广告条数
     */

    @Override
    public Integer adminDeleteAds(Integer ads_id) {
        return adsMapper.deleteById(ads_id);
    }



    @Override
    public IPage seleteByPage(int pageNumber, int pageSize, String sponsors) {
//        计算偏移量
        int offset = (pageNumber - 1) * pageSize;
        if(sponsors.equals(null)){
            //        查询全部
            Page<Ads> adsPage = new Page<>(offset,pageSize);
            IPage adsspage = adsMapper.selectPage(adsPage,null);
            return adsspage;
        }else {
//            模糊查询
            Page<Ads> adsPage=new Page<>(offset,pageSize);
            QueryWrapper<Ads> queryWrapper=new QueryWrapper<>();
            queryWrapper.like("sponsors", sponsors);
            IPage<Ads> adsspage=adsMapper.selectPage(adsPage,queryWrapper);
            return adsspage;
        }

    }
}
