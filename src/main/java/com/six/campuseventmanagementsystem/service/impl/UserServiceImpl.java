package com.six.campuseventmanagementsystem.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.six.campuseventmanagementsystem.entity.*;
import com.six.campuseventmanagementsystem.mapper.*;
import com.six.campuseventmanagementsystem.service.LoginService;
import com.six.campuseventmanagementsystem.service.NoticeService;
import com.six.campuseventmanagementsystem.service.SPAdminService;
import com.six.campuseventmanagementsystem.service.UserService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private NoticeMapper noticeMapper;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private PlayerMapper playerMapper;
    @Autowired
    private VisitorMapper visitorMapper;
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private SPAdminMapper spAdminMapper;


    //超级管理员更改用户权限
    @Override
    public Integer SPUpdateUserType(Integer id, String usertype) {
        Integer result;
        if(usertype.equals("赞助商")||usertype.equals("主办方")){
            User user = new User();
            user.setID(id);
            user.setUserType(usertype);
            QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
            userQueryWrapper.eq("ID", id);
            User acuser = userMapper.selectOne(userQueryWrapper);
            if(usertype.equals("赞助商")){
                result = userMapper.updateById(user) + noticeService.BulidUserNotice(usertype, acuser.getAccount(), "Change", "zzs");
            }
            else if(usertype.equals("主办方")){
                result = userMapper.updateById(user) + noticeService.BulidUserNotice(usertype, acuser.getAccount(), "Change", "zbf");
            }
            else
                result = null;
        }
        else if(usertype.equals("管理员")){
            QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
            userQueryWrapper.eq("ID", id);
            User user = userMapper.selectOne(userQueryWrapper);
            Admin admin = new Admin(user.getUserName(), user.getSex(), user.getNation(), user.getBirthday(), user.getDocumentType(),
                    user.getDocumentNumber(), user.getMAddress(), user.getID(), user.getUnit(), user.getAddress(),
                    user.getAge(), user.getNumber(), user.getOrigin(), "管理员", user.getAccount(),
                    user.getPassword(), "Y");
            result = adminMapper.insert(admin) + userMapper.deleteById(user) + noticeService.BulidUserNotice(usertype, user.getAccount(), "Change", "admin");
        }else
            result = null;
        return result;
    }

    //普通管理员更新用户权限
    @Override
    public Integer UpdateUserType(Integer ID,String UserType) {
        Integer result;
        if(UserType.equals("主办方")||!UserType.equals("赞助商")){
            User user = new User();
            user.setID(ID);
            user.setUserType(UserType);
            result = userMapper.updateById(user);
            return result;
        }else
            return null;
    }

    //删除普通用户
    @Override
    public Integer DeleteById(Integer ID) {
        Integer result = userMapper.deleteById(ID);
        return result;
    }

    /**
     * 根据User的Account查找User的通知
     * @return 返回IPage类型的User通知
     */
    @Override
    public IPage SelectUserNotice(String Account, Integer page, Integer size, String token){
        if(!token.equals(null)){
            Page<Notice> noticepage = new Page<>(page,size);
            QueryWrapper<Notice> noticeQueryWrapper = new QueryWrapper<>();
            noticeQueryWrapper.eq("UAccount", Account);
            IPage noticeipage = noticeMapper.selectPage(noticepage,noticeQueryWrapper);
            return noticeipage;
        }else
            return null;
    }

    /**
     * 根据Admin的Account查找Admin的通知
     * @return 返回IPage类型的Admin通知
     */
    @Override
    public IPage SelectAdminNotice(String Account, Integer page, Integer size, String token){
        if(!token.equals(null)){
            Page<Notice> noticepage = new Page<>(page,size);
            QueryWrapper<Notice> noticeQueryWrapper = new QueryWrapper<>();
            noticeQueryWrapper.eq("AAccount", Account);
            IPage noticeipage = noticeMapper.selectPage(noticepage,noticeQueryWrapper);
            return noticeipage;
        }else
            return null;
    }

    /**
     * 根据User的Account查找User  个人信息
     * @return 返回IPage类型的User信息
     */
    @Override
    public IPage SelectByAccount(String Account,String token){
        if(!token.equals(null)){
            Page<User> userpage = new Page<>(1, 1);
            QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
            userQueryWrapper.eq("Account", Account);
            IPage useripage = userMapper.selectPage(userpage,userQueryWrapper);
            return useripage;
        }else
            return null;
    }

    /**
     * 根据用户的Token查找  个人信息
     * @return 返回IPage类型的信息
     */
    @Override
    public IPage SelectByToken(String token){
        String usertype = loginService.getTokenUserType(token);
        String Account = loginService.getTokenAccount(token);
        IPage iPage;
        if(usertype.equals("超级管理员")){
            Page<SPAdmin> spadminpage = new Page<>(1, 1);
            QueryWrapper<SPAdmin> spadminQueryWrapper = new QueryWrapper<>();
            spadminQueryWrapper.eq("Account", Account);
            iPage = spAdminMapper.selectPage(spadminpage,spadminQueryWrapper);
        }
        else if(usertype.equals("管理员")){
            Page<Admin> adminpage = new Page<>(1, 1);
            QueryWrapper<Admin> adminQueryWrapper = new QueryWrapper<>();
            adminQueryWrapper.eq("Account", Account);
            iPage = adminMapper.selectPage(adminpage,adminQueryWrapper);
        }
        else if(usertype.equals("主办方")||usertype.equals("赞助商")){
            Page<User> userpage = new Page<>(1, 1);
            QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
            userQueryWrapper.eq("Account", Account);
            iPage = userMapper.selectPage(userpage,userQueryWrapper);
        }
        else
            iPage = null;
        return iPage;

    }

    /**
     * 根据用户的ID修改  个人信息
     * @return 返回更改数据条数
     */
    @Override
    public Integer UpdateById(String usertype, String account, String username, String sex, Integer id,String unit, String address,
                       String age, String number,  String origin){
        Integer result;
        if(usertype.equals("管理员")){
            Admin admin = new Admin(username, sex, id, unit, address, age, number, origin);
            result = adminMapper.updateById(admin) + noticeService.BulidUserNotice(usertype, account, "Update", "admin");
        }
        else if(usertype.equals("主办方") || usertype.equals("赞助商")){
            User user = new User(username, sex, id, unit, address, age, number, origin);
            result = userMapper.updateById(user) + noticeService.BulidUserNotice(usertype, account, "Update", "admin");
        }
        else if(usertype.equals("参赛者")){
            Player player = new Player(username, sex, id, unit, address, age, number, origin);
            result = playerMapper.updateById(player) + noticeService.BulidUserNotice(usertype, account, "Update", "admin");
        }
        else
            result = 2000;
        return result;
    }

    //根据token修改个人信息
    @Override
    public Integer UpdateByToken(String token, String username, String sex, String unit, String address,
                              String age, String number,  String origin){
        Integer result;
        String usertype = loginService.getTokenUserType(token);
        String account = loginService.getTokenAccount(token);
        Integer id = loginService.getTokenId(token);
        if(usertype.equals("管理员")){
            Admin admin = new Admin(username, sex, id, unit, address, age, number, origin);
            result = adminMapper.updateById(admin) + noticeService.BulidUserNotice(usertype, account, "Update", "admin");
        }
        else if(usertype.equals("主办方") || usertype.equals("赞助商")){
            User user = new User(username, sex, id, unit, address, age, number, origin);
            result = userMapper.updateById(user) + noticeService.BulidUserNotice(usertype, account, "Update", "admin");
        }
        else if(usertype.equals("参赛者")){
            Player player = new Player(username, sex, id, unit, address, age, number, origin);
            result = playerMapper.updateById(player) + noticeService.BulidUserNotice(usertype, account, "Update", "admin");
        }
        else
            result = 2000; //用户类型不正确
        return result;
    }

    //超级管理员 根据id删除所有用户功能
    @Override
    public Integer DeleteAllById(Integer id, String usertype){
        Integer result;
        if(usertype.equals("管理员")){
            Admin admin = new Admin(id);
            result = adminMapper.deleteById(admin);
        }
        else if(usertype.equals("主办方") || usertype.equals("赞助商")){
            User user = new User(id);
            result = userMapper.deleteById(user);
        }
        else if(usertype.equals("游客")){
            Visitor visitor = new Visitor(id);
            result = visitorMapper.deleteById(visitor);
        }
        else if(usertype.equals("参赛者")){
            Player player = new Player(id);
            result = playerMapper.deleteById(player);
        }
        else
            result = 2000;
        return result;
    }

    //管理员 根据id删除所有用户功能
    @Override
    public Integer DeletePartById(Integer id, String usertype){
        Integer result;
        if(usertype.equals("主办方") || usertype.equals("赞助商")){
            User user = new User(id);
            result = userMapper.deleteById(user);
        }
        else if(usertype.equals("游客")){
            Visitor visitor = new Visitor(id);
            result = visitorMapper.deleteById(visitor);
        }
        else if(usertype.equals("参赛者")){
            Player player = new Player(id);
            result = playerMapper.deleteById(player);
        }
        else
            result = null;
        return result;
    }
}
