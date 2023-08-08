package com.six.campuseventmanagementsystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.six.campuseventmanagementsystem.service.NoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Api(value = "通知信息操作接口",tags = "通知信息接口")
@RequestMapping("/CEMS/Notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    //删除通知消息
    @ApiOperation(value = "删除通知消息接口，单参数",notes ="输入赛事信息的id")
    @DeleteMapping("/DeleteByid")
    public Integer DeleteById(@ApiParam(value = "赛事信息的id", required = true, example = "1")Integer id){
        return noticeService.DeleteById(id);
    }

    //查询通知消息 UserType = 管理员 or 主办方 or 赞助商
    @ApiOperation(value = "赛事信息查询接口，多参数",notes ="输入需要查询的用户类型和用户account")
    @PostMapping("/SelectByToken")
    public IPage SelectByToken(@ApiParam(value = "当前页数", required = true, example = "1")Integer page,
                                 @ApiParam(value = "单页查询的消息条数", required = true, example = "1")Integer size,
                                 @ApiParam(value = "用户token", required = true, example = "1")String token){
        return noticeService.SelectByToken(page, size, token);
    }
}
