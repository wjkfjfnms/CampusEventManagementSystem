package com.six.campuseventmanagementsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;

/**
 * 实体类
 */
@ApiModel(value = "游客实体类",description = "游客个人信息，对应数据库中的tb_visitor表")
@TableName("tb_visitor")
public class Visitor {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("username")
    private String UserName;
    private String Account;
    private String Password;
    @TableField("usertype")
    private String UserType;

    public Visitor() {
    }

    public Visitor(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getAccount() {
        return Account;
    }

    public void setAccount(String account) {
        Account = account;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String userType) {
        UserType = userType;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "id=" + id +
                ", UserName='" + UserName + '\'' +
                ", Account='" + Account + '\'' +
                ", Password='" + Password + '\'' +
                ", UserType='" + UserType + '\'' +
                '}';
    }
}
