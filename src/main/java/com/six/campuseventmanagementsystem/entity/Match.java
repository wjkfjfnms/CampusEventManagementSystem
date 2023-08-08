package com.six.campuseventmanagementsystem.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;

/**
 * 实体类
 */

/**
 * @author ljc
 * Unit单位, id比赛id,UnitAddress单位地址,Type类型,Items事项,MatchTime起始时间,Place地点,Number手机号码,DocumentNumber身份证号码,State审核状态;
 */

@ApiModel(value = "赛事信息实体类",description = "赛事信息，对应数据库中的tb_match表")
@TableName("tb_match")
public class Match {

    private String Unit;
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("unitaddress")
    private String UnitAddress;
    private String Type;
    private String Items;
    @TableField("matchtime")
    private String MatchTime;
    private String Place;
    private String Number;
    @TableField("documentnumber")
    private String DocumentNumber;
    private String State;
    private String Account;

    public Match(String unit, String unitAddress, String type, String items, String matchTime,
                 String place, String number, String documentNumber, String account) {
        Unit = unit;
        UnitAddress = unitAddress;
        Type = type;
        Items = items;
        MatchTime = matchTime;
        Place = place;
        Number = number;
        DocumentNumber = documentNumber;
        Account = account;
    }

    public Match(String unit, Integer id, String unitAddress, String type, String items, String matchTime,
                 String place, String number, String documentNumber, String state) {
        Unit = unit;
        this.id = id;
        UnitAddress = unitAddress;
        Type = type;
        Items = items;
        MatchTime = matchTime;
        Place = place;
        Number = number;
        DocumentNumber = documentNumber;
        State = state;
    }

    public Match() {
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUnitAddress() {
        return UnitAddress;
    }

    public void setUnitAddress(String unitAddress) {
        UnitAddress = unitAddress;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getItems() {
        return Items;
    }

    public void setItems(String items) {
        Items = items;
    }

    public String getMatchTime() {
        return MatchTime;
    }

    public void setMatchTime(String matchTime) {
        MatchTime = matchTime;
    }

    public String getPlace() {
        return Place;
    }

    public void setPlace(String place) {
        Place = place;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getDocumentNumber() {
        return DocumentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        DocumentNumber = documentNumber;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getAccount() {
        return Account;
    }

    public void setAccount(String account) {
        Account = account;
    }
}
