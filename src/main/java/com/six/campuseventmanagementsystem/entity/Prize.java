package com.six.campuseventmanagementsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "奖品实体类",description = "奖品信息，对应数据库中的tb_prize表")
@Data
@TableName("tb_prize")
public class Prize {
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "主键，唯一识别一条奖品信息",name = "id")
    private Integer id;
    @ApiModelProperty(value = "赞助源",name = "Sponsorshipfeeds")
    private String Sponsorshipfeeds;
    @ApiModelProperty(value = "赞助目标",name = "Sponsorshipgoals")
    private String Sponsorshipgoals;
    @ApiModelProperty(value = "外键，所属赛事活动名称",name = "activityname")
    private String activityname; //外键
    @TableField("raceid")
    @ApiModelProperty(value = "外键，所属赛事活动id",name = "raceID")
    private Integer raceID; //外键
    @ApiModelProperty(value = "奖品级别",name = "level")
    private String level;
    @ApiModelProperty(value = "奖品的文字描述信息，250字以内",name = "details")
    private String details;
    @ApiModelProperty(value = "奖品的图片地址",name = "image")
    private String image;
    @ApiModelProperty(value = "审核状态",name = "state")
    private String state;
}
