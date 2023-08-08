package com.six.campuseventmanagementsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.six.campuseventmanagementsystem.entity.Prize;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface PrizeMapper extends BaseMapper<Prize> {
    @Select("SELECT MAX(id) FROM tb_prize")
    Integer selectMaxprizeID();

    @Override
    @Insert("INSERT tb_prize SET id=#{id},Sponsorshipfeeds=#{Sponsorshipfeeds},Sponsorshipgoals=#{Sponsorshipgoals},activityname=#{activityname},level=#{level},state=#{state},raceID=#{raceID},details=#{details},image=#{image}")
    int insert(Prize prize);

    @Override
    @Update("UPDATE tb_prize SET Sponsorshipfeeds=#{Sponsorshipfeeds},Sponsorshipgoals=#{Sponsorshipgoals},activityname=#{activityname},level=#{level},state=#{state},raceID=#{raceID},details=#{details},image=#{image} WHERE id=#{id}")
    int updateById(Prize prize);

    @Select("SELECT * FROM tb_prize LIMIT #{pageSize} OFFSET #{offset}")
    List<Prize> seleteByPage(int offset, int pageSize);
}
