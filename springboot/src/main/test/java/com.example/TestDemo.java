package com.example;

import com.example.entity.User;
import com.example.service.UserService;
import com.example.utils.BlockChainUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import com.example.common.enums.AdminAddressEnum;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class TestDemo {

    @Test
    public void publishOrder(){
        BlockChainUtils blockChainUtils = new BlockChainUtils();
        String userAddress = "0x5084a427ef51a92f11320db187c73c50691271be";
        String title = "orderTile";
        int price = 1;
        String description = "description";
        String orderAddress = blockChainUtils.publishOrder(userAddress,title,price,description);
        System.out.println(orderAddress);
    }

    @Test
    public void CheckBalance(){
        BlockChainUtils blockChainUtils = new BlockChainUtils();
        String userAddress = "0x5084a427ef51a92f11320db187c73c50691271be";
        int balance = blockChainUtils.CheckBalance(userAddress);
        System.out.println(balance);
    }

    @Test
    public void initBalance() throws JsonProcessingException {
        BlockChainUtils blockChainUtils = new BlockChainUtils();
        String userAddress = "0x5084a427ef51a92f11320db187c73c50691271be";
        boolean balance = blockChainUtils.initBalance(AdminAddressEnum.ADMIN_ADDRESS_ENUM.getValue(),userAddress,20);
        System.out.println(balance);
        int balance1 = blockChainUtils.CheckBalance(userAddress);
        System.out.println(balance1);
    }

    @Test
    public void reviewOrder() throws JsonProcessingException {
        BlockChainUtils blockChainUtils = new BlockChainUtils();
        String userAddress = "0x5084a427ef51a92f11320db187c73c50691271be";
        String title = "orderTile";
        int price = 1;
        String description = "description";
        String orderAddress = blockChainUtils.publishOrder(userAddress,title,price,description);
        System.out.println(orderAddress);
        boolean res = blockChainUtils.reviewOrder(AdminAddressEnum.ADMIN_ADDRESS_ENUM.getValue(),orderAddress);
        System.out.println(res);
    }


    @Test
    public void acceptOrder() throws JsonProcessingException {
        BlockChainUtils blockChainUtils = new BlockChainUtils();
        String userAddress = "0x5084a427ef51a92f11320db187c73c50691271be";
        String title = "orderTile";
        int price = 1;
        String description = "description";
        String orderAddress = blockChainUtils.publishOrder(userAddress,title,price,description);
        System.out.println(orderAddress);
        boolean res = blockChainUtils.reviewOrder(AdminAddressEnum.ADMIN_ADDRESS_ENUM.getValue(),orderAddress);
        System.out.println(res);
        String acceptUser = "0xb3504aa728402067032cef0e75794e891327f0c5";
        boolean res2 = blockChainUtils.acceptOrder(acceptUser,orderAddress);
        System.out.println(res2);
    }


    @Test
    public void volunteerFinishOrder() throws JsonProcessingException {
        BlockChainUtils blockChainUtils = new BlockChainUtils();
        String userAddress = "0x5084a427ef51a92f11320db187c73c50691271be";
        String acceptUser = "0xb3504aa728402067032cef0e75794e891327f0c5";

        blockChainUtils.initBalance(AdminAddressEnum.ADMIN_ADDRESS_ENUM.getValue(),userAddress,10);
        blockChainUtils.initBalance(AdminAddressEnum.ADMIN_ADDRESS_ENUM.getValue(),acceptUser,10);

        int balance1 = blockChainUtils.CheckBalance(userAddress);
        int balance2 = blockChainUtils.CheckBalance(acceptUser);
        System.out.println(balance1 + "   " + balance2);

        String title = "orderTile";
        int price = 1;
        String description = "description";
        String orderAddress = blockChainUtils.publishOrder(userAddress,title,price,description);
        System.out.println(orderAddress);
        boolean res = blockChainUtils.reviewOrder(AdminAddressEnum.ADMIN_ADDRESS_ENUM.getValue(),orderAddress);
        System.out.println(res);
        boolean res2 = blockChainUtils.acceptOrder(acceptUser,orderAddress);
        System.out.println(res2);
        boolean res3 = blockChainUtils.volunteerFinishOrder(acceptUser,orderAddress);
        System.out.println(res3);
        boolean res4 = blockChainUtils.assessVolunteer(userAddress,orderAddress);
        System.out.println(res4);

        balance1 = blockChainUtils.CheckBalance(userAddress);
        balance2 = blockChainUtils.CheckBalance(acceptUser);
        System.out.println(balance1 + "   " + balance2);
    }


}
