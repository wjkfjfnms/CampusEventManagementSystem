package com.six.campuseventmanagementsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;

/**
 * 实体类
 */
@ApiModel(value = "通知实体类",description = "通知信息，对应数据库中的tb_notice表")
@TableName("tb_notice")
public class Notice {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String Type;
    private String Message;
    private String Time;
    private String Sendto;
    @TableField("uaccount")
    private String UAccount;
    @TableField("aaccount")
    private String AAccount;
    private String State;

    public Notice(String type, String message, String time, String sendto, String UAccount) {
        Type = type;
        Message = message;
        Time = time;
        Sendto = sendto;
        this.UAccount = UAccount;
    }

    public Notice(String type, String message, String time, String sendto) {
        Type = type;
        Message = message;
        Time = time;
        Sendto = sendto;
    }

    public Notice() {
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

    public String getUAccount() {
        return UAccount;
    }

    public void setUAccount(String UAccount) {
        this.UAccount = UAccount;
    }

    public String getAAccount() {
        return AAccount;
    }

    public void setAAccount(String AAccount) {
        this.AAccount = AAccount;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", Type='" + Type + '\'' +
                ", Message='" + Message + '\'' +
                ", Time=" + Time +
                ", Sendto='" + Sendto + '\'' +
                ", UAccount='" + UAccount + '\'' +
                ", AAccount='" + AAccount + '\'' +
                ", State='" + State + '\'' +
                '}';
    }
}
