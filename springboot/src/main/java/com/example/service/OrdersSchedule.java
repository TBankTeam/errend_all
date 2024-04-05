package com.example.service;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.example.common.enums.OrderStatusEnum;
import com.example.common.enums.RecordsTypeEnum;
import com.example.entity.Orders;
import com.example.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class OrdersSchedule {

    @Resource
    OrdersService ordersService;

    @Resource
    UserService userService;

    @Scheduled(fixedRate = 300000)
    public void task() throws JsonProcessingException {
        log.info("========================订单扫描任务开始========================");
        Orders params = new Orders();
        params.setStatus(OrderStatusEnum.NO_ACCEPT.getValue());
        List<Orders> ordersList = ordersService.selectAll(params);
        for (Orders orders : ordersList) {
            String time = orders.getTime();
            DateTime dateTime = DateUtil.parseDateTime(time);
            long seconds = DateUtil.between(dateTime, new Date(), DateUnit.SECOND);// 计算下单的时间跟当前时间的间隔秒数
            if (seconds >= 86400) {  // 超过了24小时   自动取消
                orders.setStatus(OrderStatusEnum.CANCEL.getValue());
                ordersService.updateById(orders);

                // 取消订单后需要归还用户金额
                User dbuser = userService.selectById(orders.getUserId());
                User user = new User();
                user.setId(dbuser.getId());
                user.setPassword(null);
//                user.setAvailable_funds(user.getAvailable_funds().add(BigDecimal.valueOf(orders.getPrice())));
                userService.updateById(user);

                // 记录收支明细
//                RecordsService.addRecord("取消订单" + orders.getName(),user.getId(), BigDecimal.valueOf(orders.getPrice()), RecordsTypeEnum.CANCEL.getValue());
            }
        }

        log.info("========================订单扫描任务结束========================");
    }

}
