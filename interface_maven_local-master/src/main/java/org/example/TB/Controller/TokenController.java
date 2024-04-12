package org.example.TB.Controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.example.TB.utils.TokenUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/master")
@Slf4j
public class TokenController {

    @PostMapping("/getWallet")
    public String getWallet(String username) throws JsonProcessingException {
        log.error(username);
        String address = TokenUtil.getWallet(username);
        log.error(address);
        return address;
    }


    @PostMapping("/getWeid")
    public String getWeid(String name,String idCard,String gender,String userAddress) throws IOException {
        String weid = TokenUtil.getWeid();
        TokenUtil.CredentialCreation(weid,name,idCard,gender,userAddress);
        log.error("weid" + weid);
        return weid;
    }

    @PostMapping("/checkBalance")
    public int getBalance(String userAddress) throws JsonProcessingException {
        int res = TokenUtil.checkBalance(userAddress);
        log.error("res:" + res);
        return res;
    }

    @PostMapping("/publishOrder")
    public String publishOrder(String userAddress, String title, int price, String description) throws JsonProcessingException {
        String orderAddress = TokenUtil.createOrder(userAddress,title,price,description);
        boolean res = TokenUtil.publishOrder(userAddress,orderAddress);
        log.error("orderAddress:" + orderAddress);
        log.error("res:" + res);
        if(res == true){
            return orderAddress;
        }else {
            return null;
        }
    }


    @PostMapping("/initBalance")
    public boolean initBalance(String adminAddress,String initial_userAddress,int initial_coin) throws JsonProcessingException {
        boolean res = TokenUtil.initBalance(adminAddress,initial_userAddress,initial_coin);
        log.error("res:" + res);
        if(res == true){
            return true;
        }else {
            return false;
        }
    }


    @PostMapping("/reviewOrder")
    public boolean reviewOrder(String adminAddress,String orderAddress) throws JsonProcessingException {
        boolean res = TokenUtil.reviewOrder(adminAddress,orderAddress);
        log.error("reviewOrder res:" + res);
        if(res == true){
            return true;
        }else {
            return false;
        }
    }


    @PostMapping("/acceptOrder")
    public boolean acceptOrder(String userAddress,String orderAddress) throws JsonProcessingException {
        boolean res = TokenUtil.acceptOrder(userAddress,orderAddress);
        log.error("acceptOrder res:" + res);
        if(res == true){
            return true;
        }else {
            return false;
        }
    }

    @PostMapping("/volunteerFinishOrder")
    public boolean volunteerFinishOrder(String userAddress, String orderAddress) throws JsonProcessingException {
        boolean res = TokenUtil.volunteerFinishOrder(userAddress,orderAddress);
        log.error("volunteerFinishOrder res:" + res);
        if(res == true){
            return true;
        }else {
            return false;
        }
    }

    @PostMapping("/assessVolunteer")
    public String assessVolunteer(String userAddress, String orderAddress) throws JsonProcessingException {
        String res = TokenUtil.assessVolunteer(userAddress,orderAddress);
        log.error("assessVolunteer res:" + res);
        return res;
    }




}
