package com.six.campuseventmanagementsystem.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.six.campuseventmanagementsystem.entity.Ads;
import com.six.campuseventmanagementsystem.service.AdsService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Api(value = "赞助商管理广告信息接口",tags = "赞助商管理广告信息接口")
@RequestMapping("/CEMS/Ads")
public class AdsController {
    @Autowired
    private AdsService adsService;

    //赞助商创建广告信息
    @ApiOperation(value = "赞助商创建广告信息接口，多参数",notes ="输入广告信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sponsors", value = "赞助商", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "adsType", value = "广告类型", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "videoAdress", value = "视频地址", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "imageAdress", value = "图片地址", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "state", value = "审核状态", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "Items", value = "所属赛事名称", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "id", value = "赛事id", dataType = "Integer", required = true, paramType = "query"),
            @ApiImplicitParam(name = "UAccount", value = "当前登录的账号", dataType = "String", required = true, paramType = "query")
    })
    @PostMapping("/createAds")
    public Integer createAds(String sponsors,String adsType,String videoAdress,String imageAdress,String state,String Items,Integer id,String UAccount) {
        return adsService.createAds(sponsors,adsType,videoAdress,imageAdress,state,Items,id,UAccount);
    }

    //赞助商修改广告信息
    @ApiOperation(value = "赞助商修改广告信息接口，多参数",notes ="输入广告信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sponsors", value = "赞助商", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "adsType", value = "广告类型", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "videoAdress", value = "视频地址", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "imageAdress", value = "图片地址", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "state", value = "审核状态", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "Items", value = "所属赛事名称", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "id", value = "赛事id", dataType = "Integer", required = true, paramType = "query"),
            @ApiImplicitParam(name = "UAccount", value = "当前登录的账号", dataType = "String", required = true, paramType = "query")
    })
    @PutMapping("/updateAds")
    public Integer updateAds(Integer ads_id,String sponsors,String adsType,String videoAdress,String imageAdress,String state,String Items,Integer id,String UAccount) {
        return adsService.updateAds(ads_id,sponsors,adsType,videoAdress,imageAdress,state,Items,id,UAccount);
    }

    //赞助商删除广告信息
    @ApiOperation(value = "赞助商删除广告信息接口，多参数",notes ="输入广告信息id")
    @DeleteMapping("/deleteAds")
    public Integer deleteAds(@ApiParam(value = "adsID广告的id", required = true, example = "1")Integer ads_id,
                             @ApiParam(value = "赛事的id", required = true, example = "1")Integer id,
                             @ApiParam(value = "UAccount当前登录的账号", required = true, example = "1")String UAccount){
        return adsService.deleteAds(ads_id,id,UAccount);
    }

    //管理员创建广告信息
    @ApiOperation(value = "管理员创建广告信息接口，多参数",notes ="输入广告信息，传递当前登录的账号")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sponsors", value = "赞助商", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "adsType", value = "广告类型", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "videoAdress", value = "视频地址", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "imageAdress", value = "图片地址", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "state", value = "审核状态", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "Items", value = "所属赛事名称", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "id", value = "赛事id", dataType = "Integer", required = true, paramType = "query")
    })
    @PostMapping("/adminCreateAds")
    public Integer adminCreateAds(String sponsors,String adsType,String videoAdress,String imageAdress,String state,String Items,Integer id) {
        return adsService.adminCreateAds(sponsors,adsType,videoAdress,imageAdress,state,Items,id);
    }

    //管理员修改广告信息
    @ApiOperation(value = "管理员修改广告信息接口，多参数",notes ="输入广告信息，传递当前登录的账号")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ads_id", value = "广告id", dataType = "Integer", required = true, paramType = "query"),
            @ApiImplicitParam(name = "sponsors", value = "赞助商", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "adsType", value = "广告类型", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "videoAdress", value = "视频地址", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "imageAdress", value = "图片地址", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "state", value = "审核状态", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "Items", value = "所属赛事名称", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "id", value = "赛事id", dataType = "Integer", required = true, paramType = "query")
    })
    @PutMapping("/adminUpdateAds")
    public Integer adminUpdateAds(Integer ads_id,String sponsors,String adsType,String videoAdress,String imageAdress,String state,String Items,Integer id) {
        return adsService.adminUpdateAds(ads_id,sponsors,adsType,videoAdress,imageAdress,state,Items,id);
    }

    //管理员删除广告信息
    @ApiOperation(value = "管理员删除广告信息接口，多参数",notes ="输入广告信息id，传递当前登录的账号")
    @DeleteMapping("/adminDeleteAds")
    public Integer adminDeleteAds(@ApiParam(value = "adsID广告的id", required = true, example = "1")Integer ads_id){
        return adsService.adminDeleteAds(ads_id);
    }


    @ApiOperation(value = "查询广告信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNumber", value = "页码", dataType = "Integer", required = true, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页面大小", dataType = "Integer", required = true, paramType = "query"),
            @ApiImplicitParam(name = "sponsors", value = "广告商", dataType = "Integer", required = false, paramType = "query")})
    @GetMapping("/seleteByPage")
    public IPage seleteByPage(int pageNumber, int pageSize, String sponsors){
        return adsService.seleteByPage(pageNumber,pageSize,sponsors);
    }

}
