package com.six.campuseventmanagementsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.six.campuseventmanagementsystem.entity.*;
import com.six.campuseventmanagementsystem.mapper.*;
import com.six.campuseventmanagementsystem.service.SPAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SPAdminServiceImpl implements SPAdminService {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private SPAdminMapper spAdminMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PlayerMapper playerMapper;
    @Autowired
    private Player2Mapper player2Mapper;

    //添加管理员
    @Override
    public Boolean InsertAdmin(String AdminName, String Account, String Password, String UserType) {
        Admin admin = new Admin();
        admin.setAdminName(AdminName);
        admin.setAccount(Account);
        admin.setPassword(Password);
        admin.setUserType(UserType);
        adminMapper.insert(admin);
        return true;
    }

    //更改管理员信息
    @Override
    public Boolean UpdateAdmin(Integer ID,String AdminName, String Account, String Password, String UserType) {
        Admin admin = new Admin();
        admin.setID(ID);
        admin.setAdminName(AdminName);
        admin.setAccount(Account);
        admin.setPassword(Password);
        admin.setUserType(UserType);
        adminMapper.updateById(admin);
        return true;
    }

    //删除管理员
    @Override
    public Boolean DeleteAdmin(Integer ID) {
        adminMapper.deleteById(ID);
        return true;
    }

    //注销管理员
    @Override
    public Boolean LogoutAdmin(Integer ID){
        QueryWrapper<Admin> AqueryWrapper = new QueryWrapper<>();
        AqueryWrapper.eq("id",ID);
        if(adminMapper.selectOne(AqueryWrapper) != null){
            Admin admin = new Admin();
            admin.setID(ID);
            admin.setState("N");
            adminMapper.updateById(admin);
            return true;
        }else
            return false;
    }

    //注销普通用户
    @Override
    public Boolean LogoutUser(Integer ID, String UserType){
        QueryWrapper<User> UqueryWrapper = new QueryWrapper<>();
        UqueryWrapper.eq("id",ID).eq("UserType",UserType);
        if(userMapper.selectOne(UqueryWrapper) != null) {
            User user = new User();
            user.setID(ID);
            user.setState("N");
            userMapper.updateById(user);
            return true;
        }else
            return false;
    }

    //启用管理员
    @Override
    public Boolean EnableAdmin(Integer ID){
        QueryWrapper<Admin> AqueryWrapper = new QueryWrapper<>();
        AqueryWrapper.eq("id",ID);
        if(adminMapper.selectOne(AqueryWrapper) != null) {
            Admin admin = new Admin();
            admin.setID(ID);
            admin.setState("Y");
            adminMapper.updateById(admin);
            return true;
        }else
            return false;
    }

    //启用普通用户
    @Override
    public Boolean EnableUser(Integer ID,String UserType){
        QueryWrapper<User> UqueryWrapper = new QueryWrapper<>();
        UqueryWrapper.eq("id",ID).eq("UserType",UserType);
        if(userMapper.selectOne(UqueryWrapper) != null) {
            User user = new User();
            user.setID(ID);
            user.setState("Y");
            userMapper.updateById(user);
            return true;
        }else
            return false;
    }

    //注销
    @Override
    public Boolean Logout(Integer ID,String UserType){
        if(UserType.equals("管理员")){
            return LogoutAdmin(ID);
        }
        else if(UserType.equals("主办方")||UserType.equals("赞助商")){
            return LogoutUser(ID, UserType);
        }else
            return false;
    }

    //启用
    @Override
    public Boolean Enable(Integer ID, String UserType){
        if(UserType.equals("管理员")){
            return EnableAdmin(ID);
        }
        else if(UserType.equals("主办方")||UserType.equals("赞助商")){
            return EnableUser(ID, UserType);
        }else
            return false;
    }
    //查询管理员
    @Override
    public IPage SelectAdmin(Integer page, Integer size, String token, String sponsors, String type){
        if(!token.equals(null)){
            Page<Admin> adminpage = new Page<>(page,size);
            if(sponsors.equals(null)) {
                IPage adminipage = adminMapper.selectPage(adminpage, null);
                return adminipage;
            }
            else{
                QueryWrapper<Admin> adminQueryWrapper = new QueryWrapper<>();
                if(type.equals("姓名")){
                    adminQueryWrapper.like("AdminName", sponsors);
                }
                else if(type.equals("单位")){
                    adminQueryWrapper.like("Unit", sponsors);
                }
                IPage<Admin> adminIPage = adminMapper.selectPage(adminpage, adminQueryWrapper);
                return adminIPage;
            }
        }else
            return null;
    }

    //查询普通用户
    public IPage SelectUser(Integer page, Integer size, String token, String sponsors, String type){
        if(!token.equals(null)){
            Page<User> userpage = new Page<>(page,size);
            if(sponsors.equals(null)) {
                IPage useripage = userMapper.selectPage(userpage, null);
                return useripage;
            }
            else{
                QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
                if(type.equals("姓名")){
                    userQueryWrapper.like("UserName", sponsors);
                }
                else if(type.equals("单位")){
                    userQueryWrapper.like("Unit", sponsors);
                }
                IPage<User> userIPage = userMapper.selectPage(userpage, userQueryWrapper);
                return userIPage;
            }

        }else
            return null;
    }

    //查询赛事选手
    public IPage SelectPlayer(Integer page, Integer size, String token, String sponsors, String type){
        if(!token.equals(null)){
            Page<Player2> playerpage = new Page<>(page, size);
            if(sponsors.equals(null)) {
                IPage<Player2> playeripage = player2Mapper.selectPage(playerpage, null);
                return playeripage;
            }
            else{
                QueryWrapper<Player2> playerQueryWrapper = new QueryWrapper<>();
                if(type.equals("姓名")){
                    playerQueryWrapper.like("name", sponsors);
                }
                else if(type.equals("类型")){
                    playerQueryWrapper.like("type", sponsors);
                }
                else if(type.equals("事项")){
                    playerQueryWrapper.like("items", sponsors);
                }
                else if(type.equals("选手编号")){
                    playerQueryWrapper.like("id", sponsors);
                }
                IPage<Player2> playerIPage = player2Mapper.selectPage(playerpage, playerQueryWrapper);
                return playerIPage;
            }
        }else
            return null;
    }

    //查询赛事选手
    public IPage SelectPlayer1(Integer page, Integer size, String token, String sponsors, String type){
        if(!token.equals(null)){
            Page<Player> playerpage = new Page<>(page, size);
            if(sponsors.equals(null)) {
                IPage<Player> playeripage = playerMapper.selectPage(playerpage, null);
                return playeripage;
            }
            else{
                QueryWrapper<Player> playerQueryWrapper = new QueryWrapper<>();
                if(type.equals("姓名")){
                    playerQueryWrapper.like("name", sponsors);
                }
                else if(type.equals("单位")){
                    playerQueryWrapper.like("school", sponsors);
                }
                IPage<Player> playerIPage = playerMapper.selectPage(playerpage, playerQueryWrapper);
                return playerIPage;
            }
        }else
            return null;
    }

    //更新超级管理员信息
    @Override
    public Boolean UpdateSPAdmin(Integer ID,String SPAdminName, String Account, String Password, String OldType, String NewType) {
        SPAdmin spadmin = new SPAdmin();
        spadmin.setID(ID);
        spadmin.setSPAdminName(SPAdminName);
        spadmin.setAccount(Account);
        spadmin.setPassword(Password);
        spadmin.setOldType(OldType);
        spadmin.setNewType(NewType);
        spAdminMapper.updateById(spadmin);
        return true;
    }

    /**
     * 根据SPAdmin的Account查找SPAdmin  个人信息
     * @return 返回IPage类型的SPAdmin信息
     */
    @Override
    public IPage SelectByAccount(String Account,String token){
        if(!token.equals(null)){
            Page<SPAdmin> spadminpage = new Page<>(1, 1);
            QueryWrapper<SPAdmin> spadminQueryWrapper = new QueryWrapper<>();
            spadminQueryWrapper.eq("Account", Account);
            IPage spadminipage = spAdminMapper.selectPage(spadminpage,spadminQueryWrapper);
            return spadminipage;
        }else
            return null;
    }




}
