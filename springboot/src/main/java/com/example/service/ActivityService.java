package com.example.service;

import cn.hutool.core.date.DateUtil;
import com.example.common.enums.ActivityStatusEnum;
import com.example.entity.Account;
import com.example.entity.Activity;
import com.example.entity.ActivitySign;
import com.example.mapper.ActivityMapper;
import com.example.utils.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 公益活动信息表业务处理
 **/
@Service
public class ActivityService {

    @Resource
    private ActivityMapper activityMapper;

    @Resource
    private ActivitySignService activitySignService;

    /**
     * 新增
     */
    public void add(Activity activity) {
        activityMapper.insert(activity);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        activityMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            activityMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    public void updateById(Activity activity) {
        activityMapper.updateById(activity);
    }

    /**
     * 根据ID查询
     */
    public Activity selectById(Integer id) {
        Activity activity = activityMapper.selectById(id);
        Account currentUser = TokenUtils.getCurrentUser();
        ActivitySign activitySign = activitySignService.selectByActivityIdAndUserId(id, currentUser.getId());
        if (activitySign == null) {  // 没报名
            activity.setStatus(ActivityStatusEnum.NOT_SIGN.getValue());
        } else {
            activity.setStatus(ActivityStatusEnum.IS_SIGN.getValue());
        }
        Date date = new Date();
        String start = activity.getStart();
        if (DateUtil.parseDate(start).isAfter(date)) {
            activity.setStatus(ActivityStatusEnum.NOT_START.getValue());
        }
        String end = activity.getEnd();
        if (DateUtil.parseDate(end).isBefore(date)) {
            activity.setStatus(ActivityStatusEnum.IS_END.getValue());
        }
        return activity;
    }

    /**
     * 查询所有
     */
    public List<Activity> selectAll(Activity activity) {
        return activityMapper.selectAll(activity);
    }

    /**
     * 分页查询
     */
    public PageInfo<Activity> selectPage(Activity activity, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Activity> list = activityMapper.selectAll(activity);
        return PageInfo.of(list);
    }

}
