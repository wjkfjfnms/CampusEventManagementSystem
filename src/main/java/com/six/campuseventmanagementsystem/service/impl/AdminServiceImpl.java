package com.six.campuseventmanagementsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.six.campuseventmanagementsystem.entity.Admin;
import com.six.campuseventmanagementsystem.entity.SPAdmin;
import com.six.campuseventmanagementsystem.mapper.AdminMapper;
import com.six.campuseventmanagementsystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    /**
     * 根据Admin的Account查找Admin  个人信息
     * @return 返回IPage类型的Admin信息
     */
    @Override
    public IPage SelectByAccount(String Account, String token){
        if(!token.equals(null)){
            Page<Admin> adminpage = new Page<>(1, 1);
            QueryWrapper<Admin> adminQueryWrapper = new QueryWrapper<>();
            adminQueryWrapper.eq("Account", Account);
            IPage spadminipage = adminMapper.selectPage(adminpage,adminQueryWrapper);
            return spadminipage;
        }else
            return null;
    }
}
