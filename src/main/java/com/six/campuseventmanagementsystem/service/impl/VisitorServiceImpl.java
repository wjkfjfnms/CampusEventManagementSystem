package com.six.campuseventmanagementsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.six.campuseventmanagementsystem.entity.User;
import com.six.campuseventmanagementsystem.entity.Visitor;
import com.six.campuseventmanagementsystem.mapper.*;
import com.six.campuseventmanagementsystem.service.LoginService;
import com.six.campuseventmanagementsystem.service.NoticeService;
import com.six.campuseventmanagementsystem.service.VettingService;
import com.six.campuseventmanagementsystem.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VisitorServiceImpl implements VisitorService {
    @Autowired
    private VisitorMapper visitorMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private NoticeMapper noticeMapper;
    @Autowired
    private VettingMapper vettingMapper;
    @Autowired
    private VettingService vettingService;
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private LoginService loginService;

    //游客提交申请成为主办方/赞助商的审核
    @Override
    public Integer Submit(String token, String UserName, String Sex, String Nation, String birthday, String DocumentType, String DocumentNumber, String Unit, String Number, String Origin, String MAddress, String UserType) {
        Integer result;
        String Account = loginService.getTokenAccount(token);
        QueryWrapper<Visitor> visitorQueryWrapper = new QueryWrapper<>();
        visitorQueryWrapper.eq("Account", Account);
        Visitor visitor = visitorMapper.selectOne(visitorQueryWrapper);
        String Password = visitor.getPassword();
        User user = new User(Password, Account, UserName, Sex, Nation, birthday, DocumentType, DocumentNumber, MAddress, Unit, Number, Origin, UserType);
        user.setState("N");
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("Account", Account);
        User selectuser = userMapper.selectOne(userQueryWrapper);
        if (selectuser == null) {
            userMapper.insert(user);
            if (UserType.equals("赞助商")) {
                result = vettingService.BuildAllVetting(Account, "RealName", "zzs") +
                        noticeService.BulidUserNotice(UserType, Account, "RealName", "submit");
                return result;
            } else if (UserType.equals("主办方")) {
                result = vettingService.BuildAllVetting(Account, "RealName", "zbf") +
                        noticeService.BulidUserNotice(UserType, Account, "RealName", "submit");
                return result;
            } else
                return null;

        } else
            return null;
    }

    //根据ID删除visitor
    @Override
    public Integer DeleteById(Integer ID){
        Integer result = vettingMapper.deleteById(ID);
        return result;
    }
}



