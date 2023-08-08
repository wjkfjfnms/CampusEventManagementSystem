package com.six.campuseventmanagementsystem.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.six.campuseventmanagementsystem.entity.SPAdmin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SPAdminMapper extends BaseMapper<SPAdmin> {
//    @Select("select UserName,Account,State,UserType,Number from tb_user union all select AdminName,Account,State,UserType,Number from tb_admin limit 0,#{size}")
//    public IPage SelectAll(int size);
}
