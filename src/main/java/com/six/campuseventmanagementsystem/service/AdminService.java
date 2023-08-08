package com.six.campuseventmanagementsystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;

public interface AdminService {

    /**
     * 根据Admin的Account查找Admin  个人信息
     * @return 返回IPage类型的Admin信息
     */
    IPage SelectByAccount(String Account, String token);
}
