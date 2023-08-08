package com.six.campuseventmanagementsystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.six.campuseventmanagementsystem.service.AdminService;
import com.six.campuseventmanagementsystem.service.SPAdminService;
import com.six.campuseventmanagementsystem.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Api(value = "普通管理员接口",tags = "普通管理员基本功能")
@RequestMapping("/CEMS/Admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private SPAdminService spAdminService;
    @Autowired
    private UserService userService;

    //查询管理员个人信息
    @ApiOperation(value = "已登录管理员的个人信息查询接口，多参数",notes ="输入管理员个人账号")
    @PostMapping("/SeleteByAccount")
    public IPage SeleteByAccount(@ApiParam(value = "管理员的个人Account", required = true, example = "1")String Account,
                                 @ApiParam(value = "管理员的登录token", required = true, example = "1")String token){
        return adminService.SelectByAccount(Account, token);
    }

    //注销普通用户
    @ApiOperation(value = "管理员权限下注销用户，多参数",notes ="输入需要注册的用户的id和usertype")
    @PutMapping("/LogoutUser")
    Boolean LogoutUser(@ApiParam(value = "需要注销的user对应的id", required = true, example = "1")Integer ID,
                       @ApiParam(value = "需要注销的user的usertype", required = true, example = "1")String UserType){
        return spAdminService.LogoutUser(ID, UserType);
    }

    //启用普通用户
    @ApiOperation(value = "管理员权限下启用用户，多参数",notes ="输入需要启用的用户的id和usertype")
    @PutMapping("/EnableUser")
    Boolean EnableUser(@ApiParam(value = "需要启用的user对应的id", required = true, example = "1")Integer ID,
                       @ApiParam(value = "需要启用的user的usertype", required = true, example = "1")String UserType){
        return spAdminService.EnableUser(ID, UserType);
    }

    //对部分用户进行删除
    @DeleteMapping("/DeletePart")
    Integer DeletePart(Integer id, String usertype){
        return userService.DeletePartById(id, usertype);
    }




}
