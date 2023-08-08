package com.six.campuseventmanagementsystem.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.six.campuseventmanagementsystem.mapper.AdminMapper;
import com.six.campuseventmanagementsystem.service.MatchService;
import com.six.campuseventmanagementsystem.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Api(value = "普通用户操作接口",tags = "普通用户可以执行的操作")
@RequestMapping("/CEMS/User")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private MatchService matchService;

    //超级管理员修改用户权限
    @PutMapping("/SPUpUserType")
    public Integer SPUpUserType(Integer id,String usertype){
        return userService.SPUpdateUserType(id, usertype);
    }

    //管理员修改用户权限
    @PutMapping("/UpUserType")
    public Integer UpUserType(Integer ID,String UserType){
        return userService.UpdateUserType(ID,UserType);
    }

    /**
     * 根据User的ID删除 普通用户
     * @return 返回数据更改条数
     */
    @DeleteMapping("/DeleteById")
    public Integer DeleteById(Integer ID){
        return userService.DeleteById(ID);
    }

    /**
     * 根据User的Account查找User的通知
     * @return 返回IPage类型的User通知
     */
    @PostMapping("/SelectUserNotice")
    public IPage SelectUserNotice(String Account, Integer page, Integer size, String token) {
        return userService.SelectUserNotice(Account, page, size, token);
    }

    /**
     * 根据Admin的Account查找Admin的通知
     * @return 返回IPage类型的Admin通知
     */
    @PostMapping("SelectAdminNotice")
    public IPage SelectAdminNotice(String Account, Integer page, Integer size, String token) {
        return userService.SelectAdminNotice(Account, page, size, token);
    }

    /**
     * 根据提交的 赛事申请表单 生成赛事申请
     * @return 返回更改数据条数
     */
    @PostMapping("/BuildMatch")
    public Integer BuildMatch(String Unit, String UnitAddress, String Type, String Items, String MatchTime, String Place, String Number, String DocumentNumber, String Account){
        return matchService.BuildMatch(Unit, UnitAddress, Type, Items, MatchTime, Place, Number, DocumentNumber, Account);
    }

    /**
     * 根据User的Account查找User  个人信息
     * @return 返回IPage类型的User信息
     */
    @PostMapping("/SelectByAccount")
    public IPage SeleteByAccount(String Account, String token){
        return userService.SelectByAccount(Account, token);
    }

    /**
     * 根据User的ID修改  个人信息
     * @return 返回更改数据条数
     */
    @PutMapping("/UpdateById")
    public Integer UpdateById(String usertype, String account, String username, String sex, Integer id,String unit, String address,
                       String age, String number,  String origin){
        return userService.UpdateById(usertype, account, username, sex, id, unit, address, age, number, origin);
    }

    @PutMapping("/UpdateByToken")
    public Integer UpdateByToken(String token, String username, String sex, String unit, String address,
                                 String age, String number,  String origin){
        return userService.UpdateByToken(token, username, sex, unit, address, age, number, origin);
    }

    @PostMapping("/SelectByToken")
    public IPage SelectByToken(String token){
        return userService.SelectByToken(token);
    }


}



