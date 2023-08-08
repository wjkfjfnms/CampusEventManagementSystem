package com.six.campuseventmanagementsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.joda.time.DateTime;
import sun.security.util.Password;

import java.sql.Date;

/**
 * 实体类
 */
@ApiModel(value = "普通用户实体类",description = "普通用户个人信息，对应数据库中的tb_user表")
@TableName("tb_user")
public class User {
    @TableField("username")
    private String UserName;
    private String Sex;
    private String Nation;
    private String Birthday;
    @TableField("documenttype")
    private String DocumentType;
    @TableField("documentnumber")
    private String DocumentNumber;
    @TableField("maddress")
    private String MAddress;
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String Unit;
    private String Address;
    private String Age;
    private String Number;
    private String Account;
    private String Password;
    private String Origin;
    @TableField("usertype")
    private String UserType;
    private String State;

//    public String getToken() {
//        return Token;
//    }
//
//    public void setToken(String token) {
//        Token = token;
//    }

//    private String Token;


    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(String Account, String userName, String sex, String nation,
                String birthday, String documentType, String documentNumber, String MAddress, String unit,
                String number, String origin, String userType) {
        UserName = userName;
        Sex = sex;
        Nation = nation;
        Birthday = birthday;
        DocumentType = documentType;
        DocumentNumber = documentNumber;
        this.MAddress = MAddress;
        this.Account = Account;
        Unit = unit;
        Number = number;
        Origin = origin;
        UserType = userType;
    }

    public User(String Password, String Account, String userName, String sex, String nation,
                String birthday, String documentType, String documentNumber, String MAddress, String unit,
                String number, String origin, String userType) {
        UserName = userName;
        Sex = sex;
        Nation = nation;
        Birthday = birthday;
        DocumentType = documentType;
        DocumentNumber = documentNumber;
        this.MAddress = MAddress;
        this.Account = Account;
        this.Password = Password;
        Unit = unit;
        Number = number;
        Origin = origin;
        UserType = userType;
    }

    public User(String userName, String sex, Integer id,String unit, String address,
                String age, String number,  String origin) {
        UserName = userName;
        Sex = sex;
        this.id = id;
        Unit = unit;
        Address = address;
        Age = age;
        Number = number;
        Origin = origin;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getNation() {
        return Nation;
    }

    public void setNation(String nation) {
        Nation = nation;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }

    public String getDocumentType() {
        return DocumentType;
    }

    public void setDocumentType(String documentType) {
        DocumentType = documentType;
    }

    public String getDocumentNumber() {
        return DocumentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        DocumentNumber = documentNumber;
    }

    public String getMAddress() {
        return MAddress;
    }

    public void setMAddress(String MAddress) {
        this.MAddress = MAddress;
    }

    public Integer getID() {
        return id;
    }

    public void setID(Integer ID) {
        this.id = ID;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
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

    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String origin) {
        Origin = origin;
    }

    public String getUserType() {
        return UserType;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public void setUserType(String userType) {
        UserType = userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserName='" + UserName + '\'' +
                ", Sex='" + Sex + '\'' +
                ", ID=" + id +
                ", Unit='" + Unit + '\'' +
                ", Address='" + Address + '\'' +
                ", Age='" + Age + '\'' +
                ", Number='" + Number + '\'' +
                ", Account='" + Account + '\'' +
                ", Password='" + Password + '\'' +
                ", Origin='" + Origin + '\'' +
                ", UserType='" + UserType + '\'' +
                '}';
    }
}
