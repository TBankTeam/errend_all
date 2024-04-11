package com.example.mapper;

import com.example.entity.Evaluate;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 操作comment相关数据接口
 */
public interface EvaluateMapper {

    /**
     * 新增
     */
    int insert(Evaluate evaluate);

    /**
     * 删除
     */
    int deleteById(Integer id);

    /**
     * 修改
     */
    int updateById(Evaluate evaluate);

    /**
     * 根据ID查询
     */
    Evaluate selectById(Integer id);

    /**
     * 查询所有
     */
    List<Evaluate> selectAll(Evaluate evaluate);

    // userId: 表示当前登录的用户ID
    List<Evaluate> selectComment(Integer userId);


    @Select("select * from evaluate where user_id = #{userId}")
    List<Evaluate> selectUserComment(Integer userId);

    @Select("select * from evaluate where accept_id = #{userId}")
    List<Evaluate> selectAcceptComment(Integer userId);
}
