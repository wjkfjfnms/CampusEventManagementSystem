package com.six.campuseventmanagementsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.six.campuseventmanagementsystem.entity.Player;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author 欣欣
该接口继承了BaseMapper<SPAdmin>接口。该接口用于操作SPAdmin实体类对应的数据表，
可以进行增删改查等操作。BaseMapper是一个通用的MyBatis Mapper接口，提供了基本的CRUD操作方法，
 SPAdminMapper可以通过继承BaseMapper来继承这些基本的操作方法。
 *
 * 隐藏的代码为：
 * import java.util.List;
 *
 * import org.apache.ibatis.annotations.Param;
 *
 *
 *  * 基础的MyBatis Mapper接口，包含通用的增删改查操作
 *  * @param <T> 实体类类型
 *  public interface BaseMapper<T> {
 *
 *    根据主键查询实体类
 //*    @param id 主键
 *    @return 实体类对象
 *   T selectById(@Param("id") Long id);
 *
 *    插入实体类数据
 //*    @param entity 实体类对象
 *    @return 插入记录数
 **    int insert(T entity);
 *
 *   根据主键更新实体类数据
 //*   @param entity 实体类对象
 *   @return 更新记录数
     *int updateById(T entity);
 *
  *    根据主键删除实体类数据
//*   @param id 主键
  *   @return 删除记录数
  **int deleteById(@Param("id") Long id);
 *
 *   查询所有实体类数据
 *   @return 实体类对象列表
     *List<T> selectAll();
 *
 **/


@Mapper
public interface PlayerMapper extends BaseMapper<Player> {
}
