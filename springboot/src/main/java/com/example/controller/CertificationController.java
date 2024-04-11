package com.example.controller;

import com.example.common.Result;
import com.example.common.enums.AdminAddressEnum;
import com.example.common.enums.RecordsTypeEnum;
import com.example.entity.Certification;
import com.example.entity.User;
import com.example.service.CertificationService;
import com.example.service.RecordsService;
import com.example.service.UserService;
import com.example.utils.BlockChainUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.Year;
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
    public Result updateById(@RequestBody Certification certification) throws IOException {
        User dbuser = userService.selectById(certification.getUserId());
        User user = new User();
        user.setId(dbuser.getId());
        log.error(certification.getCardNo());
        String ageStr = certification.getCardNo().substring(6,10);
        int age = Integer.parseInt(ageStr);
        int yaer = Year.now().getValue();
        age = yaer - age;
        log.error("age:" + age);
        user.setAge(age);
        if(certification.getStatus().equals("通过")){
            Integer price = null;
            if(age < 60){
                price = 0;
            }else if(age >= 60 && age < 65){
                price = 30;
            }else if(age >= 65 && age < 70){
                price = 50;
            }else if(age >= 70 && age < 75){
                price = 70;
            }else if(age >= 75 && age < 80){
                price = 90;
            }else if(age >= 80){
                price = 120;
            }
            Date date = new Date();
            user.setAccount(price);
            user.setAvailableFunds(price);
            user.setUpdateTime(date);
            user.setStatus(1);
            user.setPassword(null);
            BlockChainUtils blockChainUtils = new BlockChainUtils();
            String accountAddress = blockChainUtils.getWallet(dbuser.getUsername());
            blockChainUtils.initBalance(AdminAddressEnum.ADMIN_ADDRESS_ENUM.getValue(), accountAddress,price);
            user.setAccountAddress(accountAddress);
            char sex = certification.getCardNo().charAt(16);
            String gender;
            if((sex - '0')%2 == 1){
                gender = "M";
                user.setSex("男");
            }else {
                gender = "F";
                user.setSex("女");
            }
            String weid = blockChainUtils.getWeid(certification.getName(),certification.getCardNo(),gender,accountAddress);
            user.setWeid(weid);
            userService.updateById(user);
            RecordsService.addRecord( "审核发放",0, user.getId(), price, RecordsTypeEnum.ISSUE.getValue());
        }else if(certification.getStatus().equals("拒绝")){
            user.setStatus(5);
            user.setPassword(null);
            userService.updateById(user);
        }
        certificationService.updateById(certification);
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
