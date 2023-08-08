package com.six.campuseventmanagementsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("tb_player2")
public class Player2 {
    private String name;
    private String sex;
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String school;
    private String type;
    private String items;
    private String time;
    private String address;
    private String position;
    private String state;

    public Player2() {
    }

    public Player2(Integer id) {
        this.id = id;
    }

    public Player2(String name, String sex, Integer id,
                   String school, String type, String items,
                   String time, String address, String position, String state) {
        this.name = name;
        this.sex = sex;
        this.id = id;
        this.school = school;
        this.type = type;
        this.items = items;
        this.time = time;
        this.address = address;
        this.position = position;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
