package com.six.campuseventmanagementsystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;

public interface UserService {
    Integer SPUpdateUserType(Integer id, String usertype);

    Integer UpdateUserType(Integer ID,String UserType);

    /**
     * 根据User的ID删除User
     * @return 返回更改数据条数
     */
    Integer DeleteById(Integer ID);
    /**
     * 根据User的Account查找User的通知
     * @return 返回IPage类型的User通知
     */
    IPage SelectUserNotice(String Account, Integer page, Integer size, String token);


    /**
     * 根据Admin的Account查找Admin的通知
     * @return 返回IPage类型的Admin通知
     */
    IPage SelectAdminNotice(String Account, Integer page, Integer size, String token);

    /**
     * 根据User的Account查找User  个人信息
     * @return 返回IPage类型的User信息
     */
    IPage SelectByAccount(String Account,String token);

    /**
     * 根据User的ID修改  个人信息
     * @return 返回更改数据条数
     */
    Integer UpdateById(String usertype, String account, String username, String sex, Integer id,String unit, String address,
                       String age, String number,  String origin);

    /**
     * 根据User的token修改  个人信息
     * @return 返回更改数据条数
     */
    Integer UpdateByToken(String token, String username, String sex,String unit, String address,
                          String age, String number,  String origin);

    /**
     * 根据ID删除  所有个人信息
     * @return 返回更改数据条数
     */
    Integer DeleteAllById(Integer id, String usertype);

    /**
     * 根据ID删除  部分个人信息
     * @return 返回更改数据条数
     */
    Integer DeletePartById(Integer id, String usertype);

    /**
     * 根据用户的Token查找  个人信息
     * @return 返回IPage类型的信息
     */
    IPage SelectByToken(String token);
}
