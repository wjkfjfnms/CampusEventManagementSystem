package com.six.campuseventmanagementsystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.six.campuseventmanagementsystem.entity.Prize;
import com.six.campuseventmanagementsystem.service.PrizeService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "赞助商管理奖品信息接口",tags = "赞助商管理奖品信息接口")
@RestController
@CrossOrigin
@RequestMapping("/CEMS/Prize")
public class PrizeController {
    @Autowired
    private PrizeService prizeService;
    //赞助商新建奖品
    @ApiOperation(value = "赞助商创建奖品信息接口，多参数",notes ="输入广告信息和传递当前登录的账号")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Sponsorshipfeeds", value = "赞助商", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "Sponsorshipgoals", value = "赞助目标", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "activityname", value = "所属赛事名称", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "level", value = "奖品级别", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "details", value = "奖品文字描述，250字以内", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "image", value = "奖品图片地址", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "state", value = "审核状态", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "raceID", value = "赛事id", dataType = "Integer", required = true, paramType = "query"),
            @ApiImplicitParam(name = "UAccount", value = "当前登录的账号", dataType = "String", required = true, paramType = "query"),
    })
    @PostMapping("/InsertPrize")
    public Integer InsertPrize(String Sponsorshipfeeds,String Sponsorshipgoals,String activityname,
                               String level,String details,String image,String state,Integer raceID,String UAccount){
        return prizeService.InsertPrize(Sponsorshipfeeds,Sponsorshipgoals,activityname,level,details,image,state,raceID,UAccount);
    }
    //赞助商修改奖品
    @ApiOperation(value = "赞助商根据id修改奖品信息接口，多参数",notes ="输入广告信息和传递当前登录的账号")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Sponsorshipfeeds", value = "赞助商", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "Sponsorshipgoals", value = "赞助目标", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "activityname", value = "所属赛事名称", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "level", value = "奖品级别", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "details", value = "奖品文字描述，250字以内", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "image", value = "奖品图片地址", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "state", value = "审核状态", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "raceID", value = "赛事id", dataType = "Integer", required = true, paramType = "query"),
            @ApiImplicitParam(name = "UAccount", value = "当前登录的账号", dataType = "String", required = true, paramType = "query"),
    })
    @PutMapping("/UpdatePrize")
    public Integer UpdatePrize(String Sponsorshipfeeds,String Sponsorshipgoals,String activityname,
                               String level,String details,String image,String state,Integer raceID,String UAccount){
        return prizeService.UpdatePrize(Sponsorshipfeeds,Sponsorshipgoals,activityname,level,details,image,state,raceID,UAccount);
    }
    //赞助商删除奖品
    @ApiOperation(value = "赞助商根据id删除奖品信息接口，多参数",notes ="输入赛事id，奖品id，传递当前登录的账号")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "raceID", value = "赛事id", dataType = "Integer", required = true, paramType = "query"),
            @ApiImplicitParam(name = "id", value = "奖品id", dataType = "Integer", required = true, paramType = "query"),
            @ApiImplicitParam(name = "UAccount", value = "当前登录的账号", dataType = "String", required = true, paramType = "query")
    })
    @DeleteMapping("/DeletePrize")
    public Integer DeletePrize(Integer raceID,Integer id,String UAccount){
        return prizeService.DeletePrize(raceID,id,UAccount);
    }

    //管理员新建奖品
    @ApiOperation(value = "管理员新建奖品信息接口，多参数",notes ="输入奖品信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Sponsorshipfeeds", value = "赞助商", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "Sponsorshipgoals", value = "赞助目标", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "activityname", value = "所属赛事名称", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "level", value = "奖品级别", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "details", value = "奖品文字描述，250字以内", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "image", value = "奖品图片地址", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "state", value = "审核状态", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "raceID", value = "赛事id", dataType = "Integer", required = true, paramType = "query")
    })
    @PostMapping("/adminInsertPrize")
    public Integer adminInsertPrize(String Sponsorshipfeeds,String Sponsorshipgoals,String activityname,
                                    String level,String details,String image,String state,Integer raceID){
        return prizeService.adminInsertPrize(Sponsorshipfeeds,Sponsorshipgoals,activityname,level,details,image,state,raceID);
    }

    //管理员修改奖品
    @ApiOperation(value = "管理员根据id更新奖品信息接口，多参数",notes ="输入奖品信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "奖品id", dataType = "Integer", required = true, paramType = "query"),
            @ApiImplicitParam(name = "Sponsorshipfeeds", value = "赞助商", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "Sponsorshipgoals", value = "赞助目标", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "activityname", value = "所属赛事名称", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "level", value = "奖品级别", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "details", value = "奖品文字描述，250字以内", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "image", value = "奖品图片地址", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "state", value = "审核状态", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "raceID", value = "赛事id", dataType = "Integer", required = true, paramType = "query")
    })
    @PutMapping("/adminUpdatePrize")
    public Integer adminUpdatePrize(Integer id,String Sponsorshipfeeds,String Sponsorshipgoals,String activityname,
                                    String level,String details,String image,String state,Integer raceID){
        return prizeService.adminUpdatePrize(id,Sponsorshipfeeds,Sponsorshipgoals,activityname,level,details,image,state,raceID);
    }

    //管理员删除奖品
    @ApiOperation(value = "管理员根据id删除奖品信息接口，单参数",notes ="输入奖品信息id")
    @DeleteMapping("/adminDeletePrize")
    public Integer adminDeletePrize(@ApiParam(value = "奖品id", required = true, example = "1")Integer id){
        return prizeService.adminDeletePrize(id);
    }

    @ApiOperation(value = "查询奖品信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNumber", value = "页码", dataType = "Integer", required = true, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页面大小", dataType = "Integer", required = true, paramType = "query"),
            @ApiImplicitParam(name = "activityname", value = "活动名", dataType = "Integer", required = false, paramType = "query")})
    @GetMapping("/seleteByPage")
    public IPage seleteByPage(int pageNumber, int pageSize, String activityname){
        return prizeService.seleteByPage(pageNumber,pageSize,activityname);
    }

}
