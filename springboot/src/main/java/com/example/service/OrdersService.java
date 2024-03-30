package com.example.service;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.example.common.enums.OrderStatusEnum;
import com.example.common.enums.RecordsTypeEnum;
import com.example.common.enums.ResultCodeEnum;
import com.example.entity.*;
import com.example.exception.CustomException;
import com.example.mapper.OrdersMapper;
import com.example.utils.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 订单信息业务处理
 **/
@Service
@Slf4j
public class OrdersService {

    @Resource
    private OrdersMapper ordersMapper;

    @Resource
    UserService userService;

    @Resource
    AddressService addressService;

    @Resource
    CertificationService certificationService;


    /**
     * 新增
     */
    public void add(Orders orders) {
        ordersMapper.insert(orders);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        ordersMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            ordersMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    @Transactional
    public void updateById(Orders orders) {
        if (OrderStatusEnum.DONE.getValue().equals(orders.getStatus())) {
            // 志愿者完成后,需求者点击完成后再评价完，订单完成
            //  打钱(志愿者加钱，需求者减钱)
            Integer userId = orders.getUserId();
            User user = userService.selectById(userId);
            user.setAccount(user.getAccount().subtract(BigDecimal.valueOf(orders.getPrice())));
            user.setPassword(null);
            userService.updateById(user);
            Integer acceptId = orders.getAcceptId();
            User accept = userService.selectById(acceptId);
            accept.setAccount(accept.getAccount().add(BigDecimal.valueOf(orders.getPrice())));
            accept.setAvailableFunds(accept.getAvailableFunds().add(BigDecimal.valueOf(orders.getPrice())));
            user.setPassword(null);
            accept.setPassword(null);
            userService.updateById(accept);
            // 记录收支明细
            RecordsService.addRecord( orders.getName(),userId,acceptId, BigDecimal.valueOf(orders.getPrice()), RecordsTypeEnum.SERVE.getValue());
        } else if(OrderStatusEnum.CANCEL.getValue().equals(orders.getStatus())) {
            // 记录收支明细
//            RecordsService.addRecord("取消订单" + orders.getName(),orders.getUserId(), BigDecimal.valueOf(orders.getPrice()), RecordsTypeEnum.CANCEL.getValue());
            //取消订单，需求者冻结账户加钱
            Date date = new Date();
            Integer userId = orders.getUserId();
            User user = userService.selectById(userId);
            user.setId(userId);
            user.setUpdateTime(date);
            log.error(String.valueOf(user.getAvailableFunds()));
            user.setAvailableFunds(user.getAvailableFunds().add(BigDecimal.valueOf(orders.getPrice())));
            user.setPassword(null);
            userService.updateById(user);
        }
        ordersMapper.updateById(orders);
    }

    /**
     * 根据ID查询
     */
    public Orders selectById(Integer id) {
        Orders orders = ordersMapper.selectById(id);
        Address address = addressService.selectById(orders.getAddressId());
        orders.setAddress(address);  // 取货地址
        Address targetAddress = addressService.selectById(orders.getTargetId());
        orders.setTargetAddress(targetAddress);  // 收货地址
        Certification certification = certificationService.selectByUserId(orders.getAcceptId());
        orders.setCertification(certification);
        return orders;
    }

    /**
     * 查询所有
     */
    public List<Orders> selectAll(Orders orders) {
        Account currentUser = TokenUtils.getCurrentUser();
        List<Orders> ordersList = new ArrayList<>();
        log.error(orders.toString());
        if(orders.getStatus() == null || !orders.getStatus().equals("待接单")) {
            orders.setAcceptId(currentUser.getId());
            List<Orders> ordersList1 = ordersMapper.selectAll(orders);
            orders.setAcceptId(null);
            orders.setUserId(currentUser.getId());
            List<Orders> ordersList2 = ordersMapper.selectAll(orders);
            for (Orders order : ordersList1) {
                String time = order.getTime();
                Date date = new Date();
                int range = (int) DateUtil.between(DateUtil.parseDateTime(time), date, DateUnit.MINUTE);
                order.setRange(range);
            }
            for (Orders order : ordersList2) {
                String time = order.getTime();
                Date date = new Date();
                int range = (int) DateUtil.between(DateUtil.parseDateTime(time), date, DateUnit.MINUTE);
                order.setRange(range);
            }
            ordersList.addAll(ordersList1);
            ordersList.addAll(ordersList2);
        }else if (orders.getStatus().equals("待接单")){
            ordersList = ordersMapper.selectAll(orders).stream()
                    .filter(orders1 -> !orders1.getUserId().equals(currentUser.getId()))
                    .collect(Collectors.toList());
            for (Orders order : ordersList) {
                String time = order.getTime();
                Date date = new Date();
                int range = (int) DateUtil.between(DateUtil.parseDateTime(time), date, DateUnit.MINUTE);
                order.setRange(range);
            }
            return ordersList;
        }

        return ordersList;
    }



    /**
     * 分页查询
     */
    public PageInfo<Orders> selectPage(Orders orders, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Orders> res = ordersMapper.selectAll(orders);
        List<Orders> list = new ArrayList<>();
        for (int i = 0; i < res.size(); i++) {
            if(!res.get(i).getStatus().equals(OrderStatusEnum.NO_EXAMINE.getValue())){
                list.add(res.get(i));
            }
        }
        return PageInfo.of(list);
    }

    /**
     * 订单审核
     */
    public PageInfo<Orders> selectPageExamine(Orders orders, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        orders.setStatus(OrderStatusEnum.NO_EXAMINE.getValue());
        List<Orders> list = ordersMapper.selectAll(orders);
        return PageInfo.of(list);
    }

    public void addOrder(Orders orders) {
        Account currentUser = TokenUtils.getCurrentUser();
        Certification certification = certificationService.selectByUserId(currentUser.getId());
        if(certification.getStatus().equals("通过")){
            currentUser.setIsRider(true);
        }else {
            throw new CustomException(ResultCodeEnum.USER_NOT_EXAMINE);
        }
        log.error(String.valueOf(currentUser.toString()));
        if (!currentUser.getIsRider()) {
            throw new CustomException(ResultCodeEnum.USER_NOT_EXAMINE);
        }
        BigDecimal available_funds = currentUser.getAvailableFunds();
        log.error(orders.toString());
        log.error("available_funds:" + available_funds);
        Double price = orders.getPrice();
        if (price > available_funds.doubleValue()) {
            throw new CustomException(ResultCodeEnum.ACCOUNT_LIMIT_ERROR);
        }
        // 更新冻结资金余额
        currentUser.setAvailableFunds(available_funds.subtract(BigDecimal.valueOf(price)));
        User user = new User();
        user = (User) currentUser;
        user.setPassword(null);
        userService.updateById(user);

        orders.setUserId(currentUser.getId());
        orders.setOrderNo(IdUtil.getSnowflakeNextIdStr());  // 设置唯一的订单编号
        orders.setStatus(OrderStatusEnum.NO_EXAMINE.getValue());
        orders.setTime(DateUtil.now());
        ordersMapper.insert(orders);

        // 记录收支明细
//        RecordsService.addRecord("下单" + orders.getName(),orders.getUserId(), BigDecimal.valueOf(orders.getPrice()), RecordsTypeEnum.OUT.getValue());
    }

    public void accept(Orders orders) {
        Account currentUser = TokenUtils.getCurrentUser();  // 认证用户
        if(currentUser.getId() == orders.getUserId()){
            throw new CustomException(ResultCodeEnum.ACCOUNT_LIMIT_ERROR);
        }
        orders.setAcceptId(currentUser.getId());
        orders.setAcceptTime(DateUtil.now());
        orders.setStatus(OrderStatusEnum.NO_ACHIEVE.getValue());
        this.updateById(orders);
    }


}