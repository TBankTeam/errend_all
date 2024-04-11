package com.example;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.thread.ThreadUtil;
import com.example.common.Result;
import com.example.controller.FileController;
import com.example.entity.Orders;
import com.example.entity.User;
import com.example.service.OrdersService;
import com.example.service.UserService;
import com.example.utils.BlockChainUtils;
import com.example.utils.ImageFileUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.junit.jupiter.api.Test;

import org.mockito.internal.matchers.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import com.example.common.enums.AdminAddressEnum;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import static com.example.utils.ImageFileUtils.*;

@SpringBootTest
public class TestDemo {

    private static final String filePath = System.getProperty("user.dir") + "/files/";


    @Test
    public void getwallent(){
        BlockChainUtils blockChainUtils = new BlockChainUtils();
        String useradderss = blockChainUtils.getWallet("wanglaowu");
        System.out.println(useradderss);
    }

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



    @Test
    public void volunteerFinish() throws JsonProcessingException {
        BlockChainUtils blockChainUtils = new BlockChainUtils();
        String userAddress = "0xa8646d3959f66487e6dbe4a33ef3d25330241f6f";
        String orderAddress = "0x0ea49cf44c23c08e5d7687d64ff4a258927aa65a";
        boolean res = blockChainUtils.volunteerFinishOrder(userAddress,orderAddress);
        System.out.println(res);
    }


    @Test
    public void test() throws IOException {
        BlockChainUtils blockChainUtils = new BlockChainUtils();

        String name = "ls";
        String idcard = "123";
        String gender = "M";
        String useraddress = "0x50d266584d1d3625ce04c7e89726aeaf6b0ae15c";

        String weid = blockChainUtils.getWeid(name,idcard,gender,useraddress);
        System.out.println("weid:" + weid);
    }

    @Test
    public void getwallet() {
        BlockChainUtils blockChainUtils = new BlockChainUtils();
        String useradderss = blockChainUtils.getWallet("yq");
        System.out.println(useradderss);
    }

    @Resource
    OrdersService ordersService;

    @Test
    public void getimage() throws IOException {
//        MultipartFile  image = ImageFileUtils.getimage("10086");
//        FileController fileController = new FileController();
//        Result res = fileController.upload(image);
//        System.out.println(res.getData());

        Orders orders = new Orders();
        orders.setId(30);
        ImageFileUtils imageFileUtils = new ImageFileUtils();
        String certificate = imageFileUtils.getimage(orders.getOrderNo());
        orders.setCertificate(certificate);
        ordersService.updateById(orders);
    }



}
