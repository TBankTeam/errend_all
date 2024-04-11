package com.example.mapper;

import com.example.entity.ActivitySign;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 操作activity_sign相关数据接口
 */
public interface ActivitySignMapper {

    /**
     * 新增
     */
    int insert(ActivitySign activitySign);

    /**
     * 删除
     */
    int deleteById(Integer id);

    /**
     * 修改
     */
    int updateById(ActivitySign activitySign);

    /**
     * 根据ID查询
     */
    ActivitySign selectById(Integer id);

    /**
     * 查询所有
     */
    List<ActivitySign> selectAll(ActivitySign activitySign);

    @Select("select * from activity_sign where activity_id = #{activityId} and user_id = #{userId} and status != '审核拒绝'")
    ActivitySign selectByActivityIdAndUserId(@Param("activityId") Integer activityId, @Param("userId") Integer userId);
}
