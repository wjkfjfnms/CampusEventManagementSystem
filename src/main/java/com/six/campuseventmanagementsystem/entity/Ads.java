package com.six.campuseventmanagementsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 实体类
 */
@ApiModel(value = "广告实体类",description = "广告信息，对应数据库中的tb_ads表")
@Data
@TableName("tb_ads")
public class Ads {
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "主键，唯一识别一条广告",name = "ads_id")
    private int ads_id;
    @ApiModelProperty(value = "赞助商名字",name = "sponsors")
    private String sponsors;
    @ApiModelProperty(value = "广告类型",name = "adsType")
    @TableField("adstype")
    private String adsType;
    @ApiModelProperty(value = "视频广告链接",name = "videoAdress")
    @TableField("videoadress")
    private String videoAdress;
    @ApiModelProperty(value = "海报广告地址",name = "imageAdress")
    @TableField("imageadress")
    private String imageAdress;
    @ApiModelProperty(value = "审核状态",name = "state")
    private String state;
    @ApiModelProperty(value = "赛事id",name = "id")
    private int id;
    @ApiModelProperty(value = "赛事名称",name = "Items")
    private String Items;

}
