package com.example.mapper;

import com.example.entity.NurseHouse;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 操作nurseHouse相关数据接口
*/
public interface NurseHouseMapper {

    /**
      * 新增
    */
    int insert(NurseHouse nurseHouse);

    /**
      * 删除
    */
    int deleteById(Integer id);

    /**
      * 修改
    */
    int updateById(NurseHouse nurseHouse);

    /**
      * 根据ID查询
    */
    NurseHouse selectById(Integer id);

    /**
      * 查询所有
    */
    List<NurseHouse> selectAll(NurseHouse nurseHouse);

    @Update("update nurse_house set count = count + 1 where id = #{id}")
    void updateCount(Integer id);

}
