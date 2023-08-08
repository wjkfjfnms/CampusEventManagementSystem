package com.six.campuseventmanagementsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.six.campuseventmanagementsystem.entity.*;
import com.six.campuseventmanagementsystem.mapper.*;
import com.six.campuseventmanagementsystem.service.LoginService;
import com.six.campuseventmanagementsystem.service.TimeService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SPAdminMapper spAdminMapper;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private VisitorMapper visitorMapper;

    @Autowired
    private HistoryMapper historyMapper;

    @Autowired
    private TimeService timeService;
    //1天过期
    private static int expire = 86400;
    //32位密钥
    private static String secret = "abcdfghiabcdfghiabcdfghiabcdfghi";

    @Override
    public String verify(String Account, String Password, String how, String ip){
        QueryWrapper<User> UqueryWrapper = new QueryWrapper<>();
        QueryWrapper<Admin> AqueryWrapper = new QueryWrapper<>();
        QueryWrapper<SPAdmin> SqueryWrapper = new QueryWrapper<>();
        QueryWrapper<Visitor> VqueryWrapper = new QueryWrapper<>();
        UqueryWrapper.eq("Account",Account).eq("Password",Password);
        AqueryWrapper.eq("Account",Account).eq("Password",Password);
        SqueryWrapper.eq("Account",Account).eq("Password",Password);
        VqueryWrapper.eq("Account", Account).eq("Password", Password);
        History history = new History(Account, how, ip, timeService.getPresentlyTime());
        User user = userMapper.selectOne(UqueryWrapper);
        Admin admin = adminMapper.selectOne(AqueryWrapper);
        SPAdmin spAdmin = spAdminMapper.selectOne(SqueryWrapper);
        Visitor visitor = visitorMapper.selectOne(VqueryWrapper);
        if(user != null&&user.getState().equals("Y")){
            if(user.getUserType().equals("主办方")){
                historyMapper.insert(history);
                String organizer = "{\n" +
                        "  \"code\": 20000,\n" +
                        "  \"data\": {\n" +
                        "    \"menu\": [\n" +
                        "      {\n" +
                        "        \"path\": \"/\",\n" +
                        "        \"name\": \"home\",\n" +
                        "        \"label\": \"首页\",\n" +
                        "        \"icon\": \"s-home\",\n" +
                        "        \"url\": \"home/index\"\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"label\": \"赛事管理\",\n" +
                        "        \"icon\": \"video-play\",\n" +
                        "        \"path\": \"/match\",\n" +
                        "        \"children\": [\n" +
                        "          {\n" +
                        "            \"path\": \"/activity\",\n" +
                        "            \"name\": \"activity\",\n" +
                        "            \"label\": \"赛事活动管理\",\n" +
                        "            \"icon\": \"setting\",\n" +
                        "            \"url\": \"match/activity.vue\"\n" +
                        "          },\n" +
                        "          {\n" +
                        "            \"path\": \"/competitor\",\n" +
                        "            \"name\": \"competitor\",\n" +
                        "            \"label\": \"赛事选手管理\",\n" +
                        "            \"icon\": \"setting\",\n" +
                        "            \"url\": \"match/competitor.vue\"\n" +
                        "          }\n" +
                        "        ]\n" +
                        "      }\n" +
                        "    ],\n" +
                        "    \"token\":" +"\""+generateToken(user.getID(), "主办方", user.getAccount())+"\""+","+
                        "    \"message\": \"获取成功\"\n" +
                        "  }\n" +
                        "}";
                return organizer;
            }
            else if(user.getUserType().equals("赞助商")){
                historyMapper.insert(history);
                String sponsor = "{\n" +
                        "  \"code\": 20000,\n" +
                        "  \"data\": {\n" +
                        "    \"menu\": [\n" +
                        "      {\n" +
                        "        \"path\": \"/\",\n" +
                        "        \"name\": \"home\",\n" +
                        "        \"label\": \"首页\",\n" +
                        "        \"icon\": \"s-home\",\n" +
                        "        \"url\": \"home/index\"\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"label\": \"赞助管理\",\n" +
                        "        \"icon\": \"location\",\n" +
                        "        \"path\": \"/sponsor\",\n" +
                        "        \"children\": [\n" +
                        "          {\n" +
                        "            \"path\": \"/ad\",\n" +
                        "            \"name\": \"ad\",\n" +
                        "            \"label\": \"广告信息管理\",\n" +
                        "            \"icon\": \"setting\",\n" +
                        "            \"url\": \"sponsor/ad.vue\"\n" +
                        "          },\n" +
                        "          {\n" +
                        "            \"path\": \"/price\",\n" +
                        "            \"name\": \"price\",\n" +
                        "            \"label\": \"奖品信息管理\",\n" +
                        "            \"icon\": \"setting\",\n" +
                        "            \"url\": \"sponsor/price.vue\"\n" +
                        "          }\n" +
                        "        ]\n" +
                        "      }\n" +
                        "    ],\n" +
                        "    \"token\":" +"\""+generateToken(user.getID(), "赞助商", user.getAccount()
                )+"\""+","+
                        "    \"message\": \"获取成功\"\n" +
                        "  }\n" +
                        "}";
                return sponsor;
            }
            else
                return null;
        }
        else if(admin != null&&admin.getState().equals("Y")){
            historyMapper.insert(history);
            String ad = "{\n" +
                    "  \"code\": 20000,\n" +
                    "  \"data\": {\n" +
                    "    \"menu\": [\n" +
                    "      {\n" +
                    "        \"path\": \"/home\",\n" +
                    "        \"name\": \"home\",\n" +
                    "        \"label\": \"首页\",\n" +
                    "        \"icon\": \"s-home\",\n" +
                    "        \"url\": \"home/index\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"label\": \"赛事管理\",\n" +
                    "        \"icon\": \"video-play\",\n" +
                    "        \"path\": \"/match\",\n" +
                    "        \"children\": [\n" +
                    "          {\n" +
                    "            \"path\": \"/activity\",\n" +
                    "            \"name\": \"activity\",\n" +
                    "            \"label\": \"赛事活动管理\",\n" +
                    "            \"icon\": \"setting\",\n" +
                    "            \"url\": \"match/activity.vue\"\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"path\": \"/competitor\",\n" +
                    "            \"name\": \"competitor\",\n" +
                    "            \"label\": \"赛事选手管理\",\n" +
                    "            \"icon\": \"setting\",\n" +
                    "            \"url\": \"match/competitor.vue\"\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"label\": \"用户管理\",\n" +
                    "        \"icon\": \"user\",\n" +
                    "        \"path\": \"/user\",\n" +
                    "        \"children\": [\n" +
                    "          {\n" +
                    "            \"path\": \"/account\",\n" +
                    "            \"name\": \"account\",\n" +
                    "            \"label\": \"账号管理\",\n" +
                    "            \"icon\": \"setting\",\n" +
                    "            \"url\": \"user/account.vue\"\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"path\": \"/user\",\n" +
                    "            \"name\": \"user\",\n" +
                    "            \"label\": \"用户信息管理\",\n" +
                    "            \"icon\": \"setting\",\n" +
                    "            \"url\": \"user/user.vue\"\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"label\": \"赞助管理\",\n" +
                    "        \"icon\": \"location\",\n" +
                    "        \"path\": \"/sponsor\",\n" +
                    "        \"children\": [\n" +
                    "          {\n" +
                    "            \"path\": \"/ad\",\n" +
                    "            \"name\": \"ad\",\n" +
                    "            \"label\": \"广告信息管理\",\n" +
                    "            \"icon\": \"setting\",\n" +
                    "            \"url\": \"sponsor/ad.vue\"\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"path\": \"/price\",\n" +
                    "            \"name\": \"price\",\n" +
                    "            \"label\": \"奖品信息管理\",\n" +
                    "            \"icon\": \"setting\",\n" +
                    "            \"url\": \"sponsor/price.vue\"\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"token\":" +"\""+generateToken(admin.getID(), "管理员", admin.getAccount())+"\""+","+
                    "    \"message\": \"获取成功\"\n" +
                    "  }\n" +
                    "}";
            return ad;
        }
        else if(visitor != null){
            historyMapper.insert(history);
            String organizer = "{\n" +
                    "  \"code\": 20000,\n" +
                    "  \"data\": {\n" +
                    "    \"menu\": [\n" +
                    "      {\n" +
                    "        \"path\": \"/\",\n" +
                    "        \"name\": \"home\",\n" +
                    "        \"label\": \"首页\",\n" +
                    "        \"icon\": \"s-home\",\n" +
                    "        \"url\": \"home/index\"\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"token\":" +"\""+generateToken(visitor.getId(), "游客", visitor.getAccount())+"\""+","+
                    "    \"message\": \"获取成功\"\n" +
                    "  }\n" +
                    "}";
            return organizer;
        }
        else if(spAdmin != null) {
            historyMapper.insert(history);
            String spad = "{\n" +
                    "  \"code\": 20000,\n" +
                    "  \"data\": {\n" +
                    "    \"menu\": [\n" +
                    "      {\n" +
                    "        \"path\": \"/home\",\n" +
                    "        \"name\": \"home\",\n" +
                    "        \"label\": \"首页\",\n" +
                    "        \"icon\": \"s-home\",\n" +
                    "        \"url\": \"home/index\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"label\": \"赛事管理\",\n" +
                    "        \"icon\": \"video-play\",\n" +
                    "        \"path\": \"/match\",\n" +
                    "        \"children\": [\n" +
                    "          {\n" +
                    "            \"path\": \"/activity\",\n" +
                    "            \"name\": \"activity\",\n" +
                    "            \"label\": \"赛事活动管理\",\n" +
                    "            \"icon\": \"setting\",\n" +
                    "            \"url\": \"match/activity.vue\"\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"path\": \"/competitor\",\n" +
                    "            \"name\": \"competitor\",\n" +
                    "            \"label\": \"赛事选手管理\",\n" +
                    "            \"icon\": \"setting\",\n" +
                    "            \"url\": \"match/competitor.vue\"\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"label\": \"用户管理\",\n" +
                    "        \"icon\": \"user\",\n" +
                    "        \"path\": \"/user\",\n" +
                    "        \"children\": [\n" +
                    "          {\n" +
                    "            \"path\": \"/account\",\n" +
                    "            \"name\": \"account\",\n" +
                    "            \"label\": \"账号管理\",\n" +
                    "            \"icon\": \"setting\",\n" +
                    "            \"url\": \"user/account.vue\"\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"path\": \"/user\",\n" +
                    "            \"name\": \"user\",\n" +
                    "            \"label\": \"用户信息管理\",\n" +
                    "            \"icon\": \"setting\",\n" +
                    "            \"url\": \"user/user.vue\"\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"label\": \"赞助管理\",\n" +
                    "        \"icon\": \"location\",\n" +
                    "        \"path\": \"/sponsor\",\n" +
                    "        \"children\": [\n" +
                    "          {\n" +
                    "            \"path\": \"/ad\",\n" +
                    "            \"name\": \"ad\",\n" +
                    "            \"label\": \"广告信息管理\",\n" +
                    "            \"icon\": \"setting\",\n" +
                    "            \"url\": \"sponsor/ad.vue\"\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"path\": \"/price\",\n" +
                    "            \"name\": \"price\",\n" +
                    "            \"label\": \"奖品信息管理\",\n" +
                    "            \"icon\": \"setting\",\n" +
                    "            \"url\": \"sponsor/price.vue\"\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"token\":" +"\""+generateToken(spAdmin.getID(), "超级管理员", spAdmin.getAccount())+"\""+","+
                    "    \"message\": \"获取成功\"\n" +
                    "  }\n" +
                    "}";
            return spad;
        }
        else
            return null;
    }

    @Override
    public String refresh(String token){
        String Account = this.getTokenAccount(token);
        QueryWrapper<User> UqueryWrapper = new QueryWrapper<>();
        UqueryWrapper.eq("Account", Account);
        User user = userMapper.selectOne(UqueryWrapper);
        String organizer;
        if(user.getState().equals("Y")){
            if(user.getUserType().equals("主办方")){
                organizer = "{\n" +
                        "  \"code\": 20000,\n" +
                        "  \"data\": {\n" +
                        "    \"menu\": [\n" +
                        "      {\n" +
                        "        \"path\": \"/\",\n" +
                        "        \"name\": \"home\",\n" +
                        "        \"label\": \"首页\",\n" +
                        "        \"icon\": \"s-home\",\n" +
                        "        \"url\": \"home/index\"\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"label\": \"赛事管理\",\n" +
                        "        \"icon\": \"video-play\",\n" +
                        "        \"path\": \"/match\",\n" +
                        "        \"children\": [\n" +
                        "          {\n" +
                        "            \"path\": \"/activity\",\n" +
                        "            \"name\": \"activity\",\n" +
                        "            \"label\": \"赛事活动管理\",\n" +
                        "            \"icon\": \"setting\",\n" +
                        "            \"url\": \"match/activity.vue\"\n" +
                        "          },\n" +
                        "          {\n" +
                        "            \"path\": \"/competitor\",\n" +
                        "            \"name\": \"competitor\",\n" +
                        "            \"label\": \"赛事选手管理\",\n" +
                        "            \"icon\": \"setting\",\n" +
                        "            \"url\": \"match/competitor.vue\"\n" +
                        "          }\n" +
                        "        ]\n" +
                        "      }\n" +
                        "    ],\n" +
                        "    \"token\":" +"\""+generateToken(user.getID(), "主办方", user.getAccount())+"\""+","+
                        "    \"message\": \"获取成功\"\n" +
                        "  }\n" +
                        "}";
            }
            else if(user.getUserType().equals("赞助商")){
                organizer = "{\n" +
                        "  \"code\": 20000,\n" +
                        "  \"data\": {\n" +
                        "    \"menu\": [\n" +
                        "      {\n" +
                        "        \"path\": \"/\",\n" +
                        "        \"name\": \"home\",\n" +
                        "        \"label\": \"首页\",\n" +
                        "        \"icon\": \"s-home\",\n" +
                        "        \"url\": \"home/index\"\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"label\": \"赞助管理\",\n" +
                        "        \"icon\": \"location\",\n" +
                        "        \"path\": \"/sponsor\",\n" +
                        "        \"children\": [\n" +
                        "          {\n" +
                        "            \"path\": \"/ad\",\n" +
                        "            \"name\": \"ad\",\n" +
                        "            \"label\": \"广告信息管理\",\n" +
                        "            \"icon\": \"setting\",\n" +
                        "            \"url\": \"sponsor/ad.vue\"\n" +
                        "          },\n" +
                        "          {\n" +
                        "            \"path\": \"/price\",\n" +
                        "            \"name\": \"price\",\n" +
                        "            \"label\": \"奖品信息管理\",\n" +
                        "            \"icon\": \"setting\",\n" +
                        "            \"url\": \"sponsor/price.vue\"\n" +
                        "          }\n" +
                        "        ]\n" +
                        "      }\n" +
                        "    ],\n" +
                        "    \"token\":" +"\""+generateToken(user.getID(), "赞助商", user.getAccount()
                )+"\""+","+
                        "    \"message\": \"获取成功\"\n" +
                        "  }\n" +
                        "}";
            }
            else
                organizer = "2000";   //用户类型不对
        }else
            organizer = "3000";   //还未通过审核
        return organizer;
    }

    @Override
    public boolean sign(String Name, String Account, String Password) {
        QueryWrapper<Visitor> VqueryWrapper = new QueryWrapper<>();
        QueryWrapper<User> UqueryWrapper = new QueryWrapper<>();
        QueryWrapper<Admin> AqueryWrapper = new QueryWrapper<>();
        QueryWrapper<SPAdmin> SqueryWrapper = new QueryWrapper<>();
        UqueryWrapper.eq("Account",Account);
        AqueryWrapper.eq("Account",Account);
        SqueryWrapper.eq("Account",Account);
        VqueryWrapper.eq("Account",Account);
        User user = userMapper.selectOne(UqueryWrapper);
        Admin admin = adminMapper.selectOne(AqueryWrapper);
        SPAdmin spAdmin = spAdminMapper.selectOne(SqueryWrapper);
        Visitor visitor = visitorMapper.selectOne(VqueryWrapper);
        if(visitor != null||user != null||admin != null||spAdmin != null){
            return false;
        }
        else{
            Visitor visitor1 = new Visitor();
            visitor1.setUserName(Name);
            visitor1.setAccount(Account);
            visitor1.setPassword(Password);
            visitorMapper.insert(visitor1);
            return true;
        }
    }
    //生成token
    @Override
    public String generateToken(Integer id, String usertype, String account){
        Date now = new Date();
        // 设置令牌过期时间
        Date expiration = new Date(now.getTime() + 1000 * expire);
        return Jwts.builder()
                // 在头部设置令牌类型
                .setHeaderParam("type","JWT")
                .setSubject("message")
                .claim("id", id)
                .claim("usertype", usertype)
                .claim("account", account)
                .setIssuedAt(now)
                .setExpiration(expiration)
                // 使用HS512算法和密钥对令牌进行签名
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }
    //解析Token
    @Override
    public Claims getClaimsByToken(String token){
        return Jwts.parser()
                // 使用密钥验证签名
                .setSigningKey(secret)
                // 解析传入的令牌
                .parseClaimsJws(token)
                .getBody();
    }

    //获取token id
    @Override
    public Integer getTokenId(String token){
        Claims claims = getClaimsByToken(token);
        return (Integer)claims.get("id");
    }

    //获取token usertype
    @Override
    public String getTokenUserType(String token){
        Claims claims = getClaimsByToken(token);
        return (String)claims.get("usertype");
    }

    //获取token account
    @Override
    public String getTokenAccount(String token){
        Claims claims = getClaimsByToken(token);
        return (String)claims.get("account");
    }

    /**
     * 根据 用户Token 查找登陆记录
     * @return 返回IPage类型消息记录
     */
    @Override
    public IPage<History> SeleteByToken(Integer page, Integer size, String token){
        if(!token.equals(null)){
            String Account = this.getTokenAccount(token);
            Page<History> historypage = new Page<>(page, size);
            QueryWrapper<History> historyQueryWrapper = new QueryWrapper<>();
            historyQueryWrapper.eq("Account", Account);
            IPage historyipage = historyMapper.selectPage(historypage,historyQueryWrapper);
            return historyipage;
        }else
            return null;
    }

    public ArrayList test(Integer id, String usertype, String account){
        Claims claims = getClaimsByToken(generateToken(id, usertype, account));
         Integer ID = (Integer)claims.get("id");
         String UserType = (String)claims.get("usertype");
         ArrayList arrayList = new ArrayList<>();
         arrayList.add(id);
         arrayList.add(usertype);
         return arrayList;
    }


}
