package com.example;

import com.example.entity.User;
import com.example.service.UserService;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class TestDemo {

    @Resource
    private UserService userService;

    @Test
    public void test(){
        User user = userService.selectById(31);
        System.out.println(user.toString());
        User user2 = userService.selectByUsername("wanglaowu");
        System.out.println(user2.toString());
        List<User> list = userService.selectAll(new User());
        User wlw = list.get(17);
        System.out.println(wlw.toString());

    }

}
