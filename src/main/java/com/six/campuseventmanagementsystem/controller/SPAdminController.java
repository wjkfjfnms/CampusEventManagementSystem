package com.six.campuseventmanagementsystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.six.campuseventmanagementsystem.entity.Admin;
import com.six.campuseventmanagementsystem.service.SPAdminService;
import com.six.campuseventmanagementsystem.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Api(value = "超级管理员操作接口",tags = "超级管理员可以执行的操作")
@RequestMapping("/CEMS/SPAdmin")
public class SPAdminController {
    @Autowired
    private SPAdminService spAdminService;

    @Autowired
    private UserService userService;

    //新建普通管理员
    @PostMapping("/add")
    public Boolean InsertAdmin(String AdminName,String Account,String Password,String NewType){
        return spAdminService.InsertAdmin(AdminName, Account, Password, NewType);
    }

    //修改普通管理员
    @PutMapping("/UpdateAdmin")
    public Boolean UpdateAdmin(Integer ID,String AdminName,String Account,String Password,String NewType){
        return spAdminService.UpdateAdmin(ID, AdminName, Account, Password, NewType);
    }

    //删除普通管理员
    @DeleteMapping("/DeleteAdmin")
    public Boolean DeleteAdmin(Integer ID){
        return spAdminService.DeleteAdmin(ID);
    }

    //注销用户,到时还需添加发送通知功能
    @PutMapping("/Logout")
    public Boolean Logout(Integer ID, String UserType){
        return spAdminService.Logout(ID, UserType);
    }

    //启用用户
    @PutMapping("/Enable")
    public Boolean Enable(Integer ID, String UserType){
        return spAdminService.Enable(ID, UserType);
    }

    //查询超级管理员个人信息
    @PostMapping("/SeleteByAccount")
    public IPage SeleteByAccount(String Account, String token){
        return spAdminService.SelectByAccount(Account, token);
    }

    //查询普通管理员
    @PostMapping("/SelectAdmin")
    public IPage SelectAdmin(Integer page, Integer size, String token, String sponsors, String type){
        return spAdminService.SelectAdmin(page,size,token,sponsors,type);
    }

    //查询普通用户
    @PostMapping("/SelectUser")
    public IPage SelectUser(Integer page, Integer size, String token, String sponsors, String type){
        return spAdminService.SelectUser(page,size,token,sponsors,type);
    }

    //查询赛事选手
    @PostMapping("/SelectPlayer")
    public IPage SelectPlayer(Integer page, Integer size, String token,String sponsors, String type){
        return spAdminService.SelectPlayer(page,size,token,sponsors,type);
    }
    //查询赛事选手1
    @PostMapping("/SelectPlayer1")
    public IPage SelectPlayer1(Integer page, Integer size, String token, String sponsors, String type){
        return spAdminService.SelectPlayer1(page, size, token, sponsors, type);
    }
    //修改超级管理员
    @PutMapping("/UpdateSPAdmin")
    public Boolean UpdateSPAdmin(Integer ID,String SPAdminName,String Account,String Password,String OldType,String NewType){
        return spAdminService.UpdateSPAdmin(ID, SPAdminName, Account, Password, OldType, NewType);
    }

    //对所有用户进行删除
    @DeleteMapping("/DeleteAll")
    public Integer DeleteAll(Integer id, String usertype){
        return userService.DeleteAllById(id, usertype);
    }


}
