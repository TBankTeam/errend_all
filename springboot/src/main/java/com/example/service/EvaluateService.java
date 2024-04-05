package com.example.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import com.example.common.Constants;
import com.example.common.enums.OrderStatusEnum;
import com.example.entity.Evaluate;
import com.example.entity.Orders;
import com.example.mapper.EvaluateMapper;
import com.example.utils.RedisUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 评价表业务处理
 **/
@Service
@Slf4j
public class EvaluateService {

    @Resource
    private EvaluateMapper evaluateMapper;

    @Resource
    private OrdersService ordersService;

    /**
     * 新增
     */
    @Transactional
    public void add(Evaluate evaluate) throws JsonProcessingException {
        evaluate.setTime(DateUtil.now());  // 设置当前的最新的时间
        evaluateMapper.insert(evaluate);
        // 更新订单状态
        Integer orderId = evaluate.getOrderId();
        Orders orders = ordersService.selectById(orderId);
        orders.setStatus(OrderStatusEnum.DONE.getValue());  // 已完成
        ordersService.updateById(orders);

        this.setCache(evaluate);
    }

    // 更新用户的缓存评论
    public void setCache(Evaluate evaluate) {
        // 查询出当前用户的所有评论信息
        List<Evaluate> evaluateList = evaluateMapper.selectUserComment(evaluate.getUserId());
        List<Evaluate> acceptEvaluateList = evaluateMapper.selectAcceptComment(evaluate.getAcceptId());
        RedisUtils.setCacheObject(Constants.REDIS_COMMENT_KEY + evaluate.getUserId(), evaluateList);  //设置用户缓存
        RedisUtils.setCacheObject(Constants.REDIS_COMMENT_KEY + evaluate.getAcceptId(), acceptEvaluateList);  //设置骑手缓存
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        Evaluate evaluate = this.selectById(id);  // 在删除之前查询评价信息
        evaluateMapper.deleteById(id);
        this.setCache(evaluate);   // 在删除之后设置评价信息
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            this.deleteById(id);
        }
    }

    /**
     * 修改
     */
    public void updateById(Evaluate evaluate) {
        evaluateMapper.updateById(evaluate);
    }

    /**
     * 根据ID查询
     */
    public Evaluate selectById(Integer id) {
        return evaluateMapper.selectById(id);
    }

    /**
     * 查询所有
     */
    public List<Evaluate> selectAll(Evaluate evaluate) {
        return evaluateMapper.selectAll(evaluate);
    }

    /**
     * 分页查询
     */
    public PageInfo<Evaluate> selectPage(Evaluate evaluate, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Evaluate> list = evaluateMapper.selectAll(evaluate);
        return PageInfo.of(list);
    }

    public List<Evaluate> selectComment(Integer userId) {
        log.error("selectComment : " + userId );
        // 先查询缓存
        //List<Evaluate> evaluateList = RedisUtils.getCacheObject(Constants.REDIS_COMMENT_KEY + userId);
        List<Evaluate> evaluateList = new ArrayList<>();
        if (CollUtil.isEmpty(evaluateList)) {  // 以防万一  万一缓存没查询到  从数据库查询下保底
            //  从数据库查询所有的评论信息
            evaluateList = evaluateMapper.selectComment(userId);
            log.error(evaluateList.get(0).toString());
            for (Evaluate evaluate : evaluateList) {
                this.setCache(evaluate);  // 设置缓存
            }
        }
        log.error(evaluateList.get(0).toString());
        return evaluateList;
    }
}
