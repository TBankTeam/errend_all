package com.example.service;

import cn.hutool.core.util.ObjectUtil;
import com.example.common.enums.ResultCodeEnum;
import com.example.common.enums.RoleEnum;
import com.example.entity.Account;
import com.example.entity.Certification;
import com.example.entity.User;
import com.example.exception.CustomException;
import com.example.mapper.UserMapper;
import com.example.utils.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 用户业务处理
 **/
@Service
@Slf4j
public class UserService {

    @Resource
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Resource
    private CertificationService certificationService;

    public void add(User user) {
        User dbUser = this.selectByUsername(user.getUsername());
        if (ObjectUtil.isNotNull(dbUser)) {   // 用户名重复
            throw new CustomException(ResultCodeEnum.USER_EXIST_ERROR);
        }
        if (ObjectUtil.isEmpty(user.getName())) {
            user.setName(user.getUsername());
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Date date = new Date();
        user.setRegisterTime(date);
        user.setUpdateTime(date);
        user.setAccount(BigDecimal.valueOf(0));
        user.setAvailableFunds(BigDecimal.valueOf(0));
        user.setRole(RoleEnum.USER.name());
        user.setStatus(2);
        userMapper.insert(user);
    }

    public User selectByUsername(String username) {
        User params = new User();
        params.setUsername(username);
        List<User> userList = this.selectAll(params);
        return userList.size() == 0 ? null : userList.get(0);
    }

    public void deleteById(Integer id) {
        User user = new User();
        user.setId(id);
        Date date = new Date();
        user.setUpdateTime(date);
        user.setStatus(4);
        userMapper.deleteById(user);
    }

    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            User user = new User();
            user.setId(id);
            Date date = new Date();
            user.setUpdateTime(date);
            user.setStatus(4);
            userMapper.deleteById(user);
        }
    }

    public void updateById(User user) {
        if ( user.getPassword() == null || user.getPassword().isEmpty() ||user.getPassword().equals("******")){
            user.setPassword(null);
        }else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        Date date = new Date();
        user.setUpdateTime(date);
        user.setPassword(null);
        userMapper.updateById(user);
    }

    public User selectById(Integer id) {
        return userMapper.selectById(id);
    }

    public List<User> selectAll(User user) {
        return userMapper.selectAll(user);
    }

    public PageInfo<User> selectPage(User user, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList = userMapper.selectAll(user);
        return PageInfo.of(userList);
    }

    public Account login(Account account) {
        Account dbUser = userMapper.selectByUsername(account.getUsername());
        if (ObjectUtil.isNull(dbUser)) {
            throw new CustomException(ResultCodeEnum.USER_NOT_EXIST_ERROR);
        }
        if (!passwordEncoder.matches(account.getPassword(), dbUser.getPassword())) {
            throw new CustomException(ResultCodeEnum.USER_ACCOUNT_ERROR);
        }
        // 生成token
        String tokenData = dbUser.getId() + "-" + RoleEnum.USER.name();
        String token = TokenUtils.createToken(tokenData, dbUser.getPassword());
        dbUser.setToken(token);

        User user = new User();
        Date date = new Date();
        user.setId(dbUser.getId());
        user.setLoginTime(date);
        userMapper.updateById(user);

        Certification certification = certificationService.selectByUserId(dbUser.getId());  // 查询当前登录用户的骑手认证信息
        dbUser.setIsRider(ObjectUtil.isNotNull(certification) && "通过".equals(certification.getStatus()));
        return dbUser;
    }

    /**
     * 注册
     */
    public void register(Account account) {
        User user = new User();
        BeanUtils.copyProperties(account, user);
        this.add(user);
    }

//    public void charge(Double money) {
//        Account currentUser = TokenUtils.getCurrentUser();
//        currentUser.setAccount(currentUser.getAccount().add(BigDecimal.valueOf(money)));
//        this.updateById((User) currentUser);
//
//        // 记录收支明细
//        RecordsService.addRecord("充值", BigDecimal.valueOf(money), RecordsTypeEnum.CHARGE.getValue());
//    }

}
