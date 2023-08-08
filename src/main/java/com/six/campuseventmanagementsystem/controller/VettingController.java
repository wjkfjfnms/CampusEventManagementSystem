package com.six.campuseventmanagementsystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.six.campuseventmanagementsystem.mapper.MatchMapper;
import com.six.campuseventmanagementsystem.service.MatchService;
import com.six.campuseventmanagementsystem.service.VettingService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Api(value = "审核信息操作接口",tags = "审核信息的一般操作")
@RequestMapping("/CEMS/Vetting")
public class VettingController {

    @Autowired
    private VettingService vettingService;
    @Autowired
    private MatchService matchService;

    //审核用户的申请
    @PutMapping("/ChangeUserState")
    public Integer ChangeUserState(Integer id, String State){
        return vettingService.ChangeUserState(id, State);
    }

    //审核赛事的申请
    @PutMapping("/ChangeMatchState")
    public Integer ChangeMatchState(Integer MatchId, String Account, String State){
        return vettingService.ChangeMatchState(MatchId, Account, State);
    }

    //整合审核
    @PutMapping("/ChangeState")
    public Integer ChangeState(Integer id, Integer MatchId, String Account, String State){
        return vettingService.ChangeState(id, MatchId, Account, State);
    }

    //删除审核消息
    @DeleteMapping("/DeleteById")
    public Integer DeleteById(Integer id){
        return vettingService.DeleteById(id);
    }

    //根据用户类型（超级管理员 or 管理员）查询审核消息
    @PostMapping("/SeleteByToken")
    public IPage SelectByToken(Integer page, Integer size, String token){
        return vettingService.SelectByToken(page, size, token);
    }
}
