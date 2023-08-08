package com.six.campuseventmanagementsystem.service;

import com.alibaba.druid.support.http.util.IPAddress;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.six.campuseventmanagementsystem.entity.History;
import io.jsonwebtoken.Claims;

import java.io.File;
import java.util.ArrayList;

public interface LoginService {
    String verify(String Account, String Password, String how, String ip);
    String refresh(String token);
    boolean sign(String Name, String Account, String Password);
    String generateToken(Integer id, String usertype, String account);
    Claims getClaimsByToken(String token);
    Integer getTokenId(String token);
    String getTokenUserType(String token);
    String getTokenAccount(String token);

    /**
     * 根据 用户账号 查找登陆记录
     * @return 返回IPage类型消息记录
     */
    IPage<History> SeleteByToken(Integer page, Integer size, String token);

    ArrayList<String> test(Integer id, String usertype, String account);

}
