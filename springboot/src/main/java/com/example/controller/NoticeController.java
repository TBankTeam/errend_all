package com.example.controller;

import com.example.common.Result;
import com.example.entity.*;
import com.example.mapper.OrdersMapper;
import com.example.service.*;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.transaction.Transaction;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 公告信息表前端操作接口
 **/
@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Resource
    private NoticeService noticeService;

    @Resource
    private OrdersMapper ordersMapper;

    @Resource
    private UserService userService;

    @Resource
    private CertificationService certificationService;

    @Resource
    private RecordsService recordsService;

    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody Notice notice) {
        noticeService.add(notice);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        noticeService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        noticeService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody Notice notice) {
        noticeService.updateById(notice);
        return Result.success();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        Notice notice = noticeService.selectById(id);
        return Result.success(notice);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll(Notice notice ) {
        List<Notice> list = noticeService.selectAll(notice);
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    public Result selectPage(Notice notice,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Notice> page = noticeService.selectPage(notice, pageNum, pageSize);
        return Result.success(page);
    }


    @GetMapping("/getInfo")
    public Result getInfo() {
        List<User> userList = userService.selectAll(new User());
        List<Orders> ordersList = ordersMapper.selectAll(new Orders());
        List<Certification> certificationList = certificationService.selectAll(new Certification());
        List<Records> recordsList = recordsService.selectAll(new Records());
        Map<String,Integer> res = new HashMap<>();
        Integer userNum = userList.size();
        Integer orderNum = ordersList.size();
        Integer certificationNum = certificationList.size();
        Integer money = 0;
        for (Records records : recordsList) {
            money += records.getMoney();
        }
        res.put("userNum",userNum);
        res.put("orderNum",orderNum);
        res.put("certificationNum",certificationNum);
        res.put("money",money);
        return Result.success(res);
    }

}
