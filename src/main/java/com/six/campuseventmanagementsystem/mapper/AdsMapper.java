package com.six.campuseventmanagementsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.six.campuseventmanagementsystem.entity.Ads;
import com.six.campuseventmanagementsystem.entity.Prize;
import org.apache.ibatis.annotations.*;

import java.util.List;


/**
 * @author 欣欣
 */
@Mapper
public interface AdsMapper extends BaseMapper<Ads> {
    @Select("SELECT MAX(ads_id) FROM tb_ads")
    Integer selectMaxadsID();

    @Override
    @Update("UPDATE tb_ads SET sponsors=#{sponsors}, adsType=#{adsType}, videoAdress=#{videoAdress},imageAdress=#{imageAdress}, state=#{state}, id=#{id}, Items=#{Items} WHERE ads_id=#{ads_id}")
    int updateById(Ads ads);

    @Override
    @Insert("INSERT tb_ads SET ads_id=#{ads_id},sponsors=#{sponsors}, adsType=#{adsType}, videoAdress=#{videoAdress},imageAdress=#{imageAdress}, state=#{state}, id=#{id}, Items=#{Items}")
    int insert(Ads ads);

    @Delete("DELETE FROM tb_ads WHERE ads_id=#{ads_id}")
    int deleteById(int ads_id);


}
