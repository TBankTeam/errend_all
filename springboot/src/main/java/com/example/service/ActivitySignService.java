package com.example.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Dict;
import com.example.common.enums.ResultCodeEnum;
import com.example.common.enums.RoleEnum;
import com.example.entity.Account;
import com.example.entity.ActivitySign;
import com.example.exception.CustomException;
import com.example.mapper.ActivitySignMapper;
import com.example.utils.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 活动报名业务处理
 **/
@Service
public class ActivitySignService {

    @Resource
    private ActivitySignMapper activitySignMapper;

    /**
     * 新增
     */
    public void add(ActivitySign activitySign) {
        activitySign.setDate(DateUtil.today());
        // 看看用户有没有报名过
        ActivitySign sign = activitySignMapper.selectByActivityIdAndUserId(activitySign.getActivityId(), activitySign.getUserId());
        if (sign != null) {
            throw new CustomException(ResultCodeEnum.SIGN_ERROR);
        }
        activitySignMapper.insert(activitySign);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        activitySignMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            activitySignMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    public void updateById(ActivitySign activitySign) {
        activitySignMapper.updateById(activitySign);
    }

    /**
     * 根据ID查询
     */
    public ActivitySign selectById(Integer id) {
        return activitySignMapper.selectById(id);
    }

    /**
     * 查询所有
     */
    public List<ActivitySign> selectAll(ActivitySign activitySign) {
        return activitySignMapper.selectAll(activitySign);
    }

    /**
     * 分页查询
     */
    public PageInfo<ActivitySign> selectPage(ActivitySign activitySign, Integer pageNum, Integer pageSize) {
        Account currentUser = TokenUtils.getCurrentUser();
        if (currentUser.getRole().equals(RoleEnum.USER.name())) {  // 普通用户只查询自己的数据
            activitySign.setUserId(currentUser.getId());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<ActivitySign> list = activitySignMapper.selectAll(activitySign);
        return PageInfo.of(list);
    }

    public ActivitySign selectByActivityIdAndUserId(Integer activityId, Integer userId) {
        return activitySignMapper.selectByActivityIdAndUserId(activityId, userId);
    }

    public List<Dict> selectCount() {
        List<ActivitySign> activitySigns = activitySignMapper.selectAll(null);
        activitySigns = activitySigns.stream().filter(activitySign -> "审核通过".equals(activitySign.getStatus())
                || "待审核".equals(activitySign.getStatus())).collect(Collectors.toList());
        Set<String> set = activitySigns.stream().map(ActivitySign::getActivityName).collect(Collectors.toSet());
        List<Dict> list = CollUtil.newArrayList();
        for (String name : set) {
            long count = activitySigns.stream().filter(activitySign -> activitySign.getActivityName().equals(name)).count();
            Dict dict = Dict.create().set("name", name).set("value", count);
            list.add(dict);
        }
        return list;
    }
}
