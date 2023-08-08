package com.six.campuseventmanagementsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "登陆记录实体类",description = "登录记录消息，对应数据库中的tb_history表")
@TableName("tb_history")
public class History {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String Account;

    private String how;

    private String ip;

    private String time;

    public History(String account, String how, String ip, String time) {
        Account = account;
        this.how = how;
        this.ip = ip;
        this.time = time;
    }

    public History() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return Account;
    }

    public void setAccount(String account) {
        Account = account;
    }

    public String getHow() {
        return how;
    }

    public void setHow(String how) {
        this.how = how;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
