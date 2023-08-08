package com.six.campuseventmanagementsystem.controller;

import com.six.campuseventmanagementsystem.entity.Player;
import com.six.campuseventmanagementsystem.service.PlayerService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "参赛方管理个人信息接口",tags = "参赛方管理个人信息接口")
@RestController
@CrossOrigin
@RequestMapping("/CEMS/Player")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    //修改个人账户信息
    @ApiOperation(value = "参赛者修改个人账户信息接口，多参数",notes ="输入个人信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "参赛者账号id", dataType = "Integer", required = true, paramType = "query"),
            @ApiImplicitParam(name = "headshot", value = "头像地址", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "nickname", value = "昵称", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "name", value = "姓名", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "school", value = "学校", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "address", value = "居住地址", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "sex", value = "性别", dataType = "Integer", required = true, paramType = "query"),
            @ApiImplicitParam(name = "phone", value = "电话", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "age", value = "年龄", dataType = "Integer", required = true, paramType = "query")
    })
    @PutMapping("/changePMess")
    public Integer changePMess(Integer id,String headshot,String nickname,String name,String school,
                               String address,String sex,String phone,String age){
        return playerService.changePMess(id,headshot,nickname,name,school,address,sex,phone,age);
    }

    //删除个人账户信息：注销账户
    @ApiOperation(value = "参赛者注销个人账户接口，单参数",notes ="输入个人账号id")
    @DeleteMapping("/delePMess")
    public Integer delePMess(@ApiParam(value = "参赛者的账号id", required = true, example = "1")Integer id){
        return playerService.delePMess(id);
    }

    //查询个人账户信息
    @ApiOperation(value = "参赛者查询个人账户接口，单参数",notes ="传入当前登录的个人账号id")
    @GetMapping("/selePMess")
    public Player selePMess(@ApiParam(value = "参赛者的账号id", required = true, example = "1")Integer id){
        return playerService.selePMess(id);
    }

    @DeleteMapping("/Delete2ById")
    public Integer DeleteById(Integer id){
        return playerService.DeleteById(id);
    }

    @PutMapping("Update2ById")
    public Integer UpDateById(String name, String sex, Integer id, String school, String type,
                                      String items, String time, String address, String position, String state){
        return playerService.UpDateById(name, sex, id, school, type, items, time, address, position, state);
    }
}
