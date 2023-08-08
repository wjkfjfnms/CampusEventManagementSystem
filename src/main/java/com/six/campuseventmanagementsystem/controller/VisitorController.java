package com.six.campuseventmanagementsystem.controller;

import com.six.campuseventmanagementsystem.entity.User;
import com.six.campuseventmanagementsystem.service.VisitorService;
import io.swagger.annotations.Api;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@CrossOrigin
@Api(value = "游客操作接口",tags = "游客可以执行的操作")
@RequestMapping("/CEMS/Visitor")
public class VisitorController {
    @Autowired
    private VisitorService visitorService;
    @PostMapping("/RealName")
    public Integer Submit(String token, String UserName, String Sex, String Nation, String birthday, String DocumentType, String DocumentNumber, String Unit, String Number, String Origin, String MAddress, String UserType){
        return visitorService.Submit(token, UserName, Sex, Nation, birthday, DocumentType, DocumentNumber, Unit, Number, Origin, MAddress, UserType);
    }

    @DeleteMapping("DeleteById")
    public Integer DeleteById(Integer ID){
        return visitorService.DeleteById(ID);
    }
}
