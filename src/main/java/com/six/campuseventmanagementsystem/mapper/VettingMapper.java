package com.six.campuseventmanagementsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.six.campuseventmanagementsystem.entity.Vetting;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface VettingMapper extends BaseMapper<Vetting> {
    @Select("SELECT MAX(ID) FROM tb_vetting")
    Integer selectMaxId();
}
