package com.six.campuseventmanagementsystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.six.campuseventmanagementsystem.service.MatchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin
@Api(value = "赛事信息操作接口",tags = "管理赛事信息接口")
@RequestMapping("/CEMS/Match")
public class MatchController {

    @Autowired
    private MatchService matchService;

    //提交
    @ApiOperation(value = "赛事的申请接口，多参数",notes ="输入赛事申请表内的信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Unit", value = "单位", dataType = "String", required = true, paramType = "body"),
            @ApiImplicitParam(name = "UnitAddress", value = "单位地址", dataType = "String", required = true, paramType = "body"),
            @ApiImplicitParam(name = "Type", value = "比赛类型", dataType = "String", required = true, paramType = "body"),
            @ApiImplicitParam(name = "Items", value = "比赛事项", dataType = "String", required = true, paramType = "body"),
            @ApiImplicitParam(name = "MatchTime", value = "比赛开始时间", dataType = "String", required = true, paramType = "body"),
            @ApiImplicitParam(name = "Place", value = "比赛地点", dataType = "String", required = true, paramType = "body"),
            @ApiImplicitParam(name = "Number", value = "电话号码", dataType = "String", required = true, paramType = "body"),
            @ApiImplicitParam(name = "DocumentNumber", value = "身份证号码", dataType = "String", required = true, paramType = "body"),
            @ApiImplicitParam(name = "Account", value = "当前登录的主办方账号", dataType = "String", required = true, paramType = "body")
    })
    @PostMapping("/BuildMatch")
    public Integer BuildMatch(String Unit, String UnitAddress, String Type, String Items, String MatchTime, String Place, String Number, String DocumentNumber, String token){
        return matchService.BuildMatch(Unit, UnitAddress, Type, Items, MatchTime, Place, Number, DocumentNumber, token);
    }

    //根据ID删除
    @ApiOperation(value = "赛事信息的删除接口，单参数",notes ="输入赛事信息的id")
    @DeleteMapping("DeleteById")
    public Integer DeleteById(Integer ID){
        return matchService.DeleteById(ID);
    }

    //查询所有赛事信息
    @ApiOperation(value = "查询所有赛事信息接口，多参数",notes ="输入当前页数，单页查询数据量，token")
    @PostMapping("SeleteAll")
    public IPage SeleteAll(Integer page, Integer size, String token, String sponsors, String type){
        return matchService.SelectAll(page, size, token, sponsors, type);
    }

    //根据ID修改赛事信息
    @ApiOperation(value = "修改赛事信息接口，多参数",notes ="输入赛事信息id，赛事信息数据")
    @PutMapping("UpdateById")
    public Integer UpdateById(String unit, Integer id, String unitAddress, String type,
                              String items, String matchTime, String place, String number,
                              String documentNumber, String state){
        return matchService.UpdateById(unit, id, unitAddress, type, items, matchTime, place, number, documentNumber, state);
    }
}
