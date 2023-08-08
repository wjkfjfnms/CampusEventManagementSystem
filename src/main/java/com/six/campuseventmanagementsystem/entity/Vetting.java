package com.six.campuseventmanagementsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import org.joda.time.DateTime;

/**
 * 实体类
 */
@ApiModel(value = "审核信息实体类",description = "普通用户和游客提交的审核信息，对应数据库中的tb_vetting表")
@TableName("tb_vetting")
public class Vetting {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String Type;
    private String Message;
    private String Time;
    private String Sendto;
    private String Account;
    @TableField("Matchid")
    private Integer Matchid;
    private String State;

    public Vetting(String type, String message, String time, String sendto, String account) {
        Type = type;
        Message = message;
        Time = time;
        Sendto = sendto;
        Account = account;
    }

    public Vetting(String type, String message, String time, String sendto, String account, Integer matchid) {
        Type = type;
        Message = message;
        Time = time;
        Sendto = sendto;
        Account = account;
        Matchid = matchid;
    }

    public Vetting() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getSendto() {
        return Sendto;
    }

    public void setSendto(String sendto) {
        Sendto = sendto;
    }

    public String getAccount() {
        return Account;
    }

    public void setAccount(String account) {
        Account = account;
    }

    public Integer getMatchid() {
        return Matchid;
    }

    public void setMatchid(Integer matchid) {
        Matchid = matchid;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    @Override
    public String toString() {
        return "Vetting{" +
                "id=" + id +
                ", Type='" + Type + '\'' +
                ", Message='" + Message + '\'' +
                ", Time=" + Time +
                ", Sendto='" + Sendto + '\'' +
                ", State='" + State + '\'' +
                '}';
    }
}
