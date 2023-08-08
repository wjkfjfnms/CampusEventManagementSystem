package com.six.campuseventmanagementsystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.six.campuseventmanagementsystem.entity.History;
import com.six.campuseventmanagementsystem.service.LoginService;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.ArrayList;

@RestController
@CrossOrigin
@Api(value = "登录操作接口",tags = "登录功能相关接口")
@RequestMapping("/CEMS/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    //登录验证  //@RequestParam
    @ApiOperation(value = "用户登录接口，多参数",notes ="输入需要用户的账号密码，登录方式和ip")
    @PostMapping("/verify")
    public String verify(@ApiParam(value = "用户的account", required = true, example = "1")String Account,
                         @ApiParam(value = "用户的password", required = true, example = "1")String Password,
                         @ApiParam(value = "用户的登录方式，前端提供", required = true, example = "1")String how,
                         @ApiParam(value = "用户登录的ip，前端提供", required = true, example = "1")String ip){
        return loginService.verify(Account, Password, how, ip);
    }

    //游客实名验证后，刷新
    @PostMapping("/refresh")
    public String refresh(String token){
        return loginService.refresh(token);
    }

    //注册
    @ApiOperation(value = "用户注册接口，多参数",notes ="输入需要注册的用户名称，account和password")
    @PostMapping("/sign")
    public Boolean Sign(@ApiParam(value = "需要注册的名称", required = true, example = "1")String Name,
                        @ApiParam(value = "需要注册的account", required = true, example = "1")String Account,
                        @ApiParam(value = "需要注册的password", required = true, example = "1")String Password){
        return loginService.sign(Name, Account, Password);
    }

    //生成token
    @ApiOperation(value = "给用户生成token，单参数",notes ="输入用户的usertype，一般是后端使用")
    @PostMapping("/token")
    public String generateToken(Integer id, @ApiParam(value = "已登录的usertype（用户类型）", required = true, example = "1")String usertype, String account){
        return loginService.generateToken(id, usertype, account);
    }

    //解析token
    @ApiOperation(value = "给用户解析token，单参数",notes ="输入用户的token，一般是后端使用")
    @PostMapping("/parse")
    public Claims getClaimsByToken(@ApiParam(value = "已登录的用户token", required = true, example = "1")String token){
        return loginService.getClaimsByToken(token);
    }

    @PostMapping("/getusertype")
    public String getTokenUserType(String token){
        return loginService.getTokenUserType(token);
    }

    //根据登录account查询登录记录
    @ApiOperation(value = "根据account查询用户的登陆记录，多参数",notes ="输入用户account，当前页数，单页数据量，token")
    @PostMapping("/SeleteByToken")

    public IPage<History> SeleteByToken(@ApiParam(value = "当前页数", required = true, example = "1")Integer page,
                                          @ApiParam(value = "单页查询的数据条数", required = true, example = "1")Integer size,
                                          @ApiParam(value = "用户token", required = true, example = "1")String token){
        return loginService.SeleteByToken(page, size, token);
    }
    @RequestMapping("/test")
    public String test(){
        return "成功运行";
    }

    @PostMapping("test2")
    public ArrayList test2(Integer id, String usertype,String account){
        return loginService.test(id, usertype, account);
    }

}
