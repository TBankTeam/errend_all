package com.example.controller;

import com.example.common.Result;
import com.example.common.enums.RecordsTypeEnum;
import com.example.entity.Certification;
import com.example.entity.User;
import com.example.service.CertificationService;
import com.example.service.RecordsService;
import com.example.service.UserService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 前端操作接口
 **/
@RestController
@Slf4j
@RequestMapping("/certification")
public class CertificationController {

    @Resource
    private CertificationService certificationService;

    @Resource
    private UserService userService;


    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody Certification certification) {
        certificationService.add(certification);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        certificationService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        certificationService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody Certification certification) {
        certificationService.updateById(certification);
        User dbuser = userService.selectById(certification.getUserId());
        User user = new User();
        user.setId(dbuser.getId());
        if(certification.getStatus().equals("通过")){
            Integer price = null;
            if(dbuser.getAge() < 60){
                price = 0;
            }else if(dbuser.getAge() >= 60 && dbuser.getAge() < 65){
                price = 30;
            }else if(dbuser.getAge() >= 65 && dbuser.getAge() < 70){
                price = 50;
            }else if(dbuser.getAge() >= 70 && dbuser.getAge() < 75){
                price = 70;
            }else if(dbuser.getAge() >= 75 && dbuser.getAge() < 80){
                price = 90;
            }else if(dbuser.getAge() >= 80){
                price = 120;
            }
            Date date = new Date();
            user.setAccount(BigDecimal.valueOf(price));
            user.setAvailableFunds(BigDecimal.valueOf(price));
            user.setUpdateTime(date);
            user.setStatus(1);
            user.setPassword(null);
            userService.updateById(user);
            RecordsService.addRecord( "审核发放",0, user.getId(), BigDecimal.valueOf(price), RecordsTypeEnum.ISSUE.getValue());
        }else if(certification.getStatus().equals("拒绝")){
            user.setStatus(5);
            user.setPassword(null);
            userService.updateById(user);
        }
        return Result.success();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        Certification certification = certificationService.selectById(id);
        return Result.success(certification);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll(Certification certification) {
        List<Certification> list = certificationService.selectAll(certification);
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    public Result selectPage(Certification certification,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Certification> page = certificationService.selectPage(certification, pageNum, pageSize);
        return Result.success(page);
    }

    @GetMapping("/selectPageInfo")
    public Result selectPageInfo(Certification certification,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Certification> page = certificationService.selectPageInfo(certification, pageNum, pageSize);
        return Result.success(page);
    }

    /**
     * 查询当前用户的认证信息
     */
    @GetMapping("/selectUserCertification")
    public Result selectUserCertification() {
        Certification certification = certificationService.selectUserCertification();
        return Result.success(certification);
    }

}
