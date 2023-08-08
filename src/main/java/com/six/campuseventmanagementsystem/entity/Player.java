package com.six.campuseventmanagementsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author 欣欣
 * headshot头像,nickname昵称,name姓名,school学校,address地址,sex性别,phone电话,origin籍贯;
 */
@ApiModel(value = "参赛者实体类",description = "参赛者信息，对应数据库中的tb_player表")
@Data
@TableName("tb_player")
public class Player {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String age;
    private String headshot,nickname,name,school,address,sex,phone,origin;

    public Player() {
    }

    public Player(int id) {
        this.id = id;
    }

    public Player(String name, String sex, Integer id, String school, String address,
                  String age, String phone, String origin) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.school = school;
        this.address = address;
        this.sex = sex;
        this.phone = phone;
        this.origin = origin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHeadshot() {
        return headshot;
    }

    public void setHeadshot(String headshot) {
        this.headshot = headshot;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
