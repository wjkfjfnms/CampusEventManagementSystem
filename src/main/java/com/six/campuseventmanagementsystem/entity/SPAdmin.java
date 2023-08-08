package com.six.campuseventmanagementsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;

/**
 * 实体类
 */
@ApiModel(value = "超级管理员实体类",description = "超级管理员个人信息，对应数据库中的tb_spadmin表")
@TableName("tb_spadmin")
public class SPAdmin {

    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("spadminname")
    private String SPAdminName;
    private String Account;
    private String Password;
    @TableField("oldtype")
    private String OldType;
    @TableField("usertype")
    private String NewType;

    public Integer getID() {
        return id;
    }

    public void setID(Integer ID) {
        this.id = ID;
    }

    public String getSPAdminName() {
        return SPAdminName;
    }

    public void setSPAdminName(String SPAdminName) {
        this.SPAdminName = SPAdminName;
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

    public String getOldType() {
        return OldType;
    }

    public void setOldType(String oldType) {
        OldType = oldType;
    }

    public String getNewType() {
        return NewType;
    }

    public void setNewType(String newType) {
        NewType = newType;
    }

    @Override
    public String toString() {
        return "SPAdmin{" +
                "ID=" + id +
                ", SPAdminName='" + SPAdminName + '\'' +
                ", Account='" + Account + '\'' +
                ", Password='" + Password + '\'' +
                ", OldType='" + OldType + '\'' +
                ", NewType='" + NewType + '\'' +
                '}';
    }
}
