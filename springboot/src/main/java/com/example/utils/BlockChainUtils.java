package com.example.utils;

import cn.hutool.http.HttpUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.IOException;

public class BlockChainUtils {

    public String getWallet(String username){
        String url = "http://localhost:8083/master/getWallet";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        MultiValueMap map = new LinkedMultiValueMap();
        map.add("username",username);
        HttpEntity requestBody = new HttpEntity(map, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity responseEntity = restTemplate.postForEntity(url, requestBody, String.class);
        String address = (String)responseEntity.getBody();
        return address;
    }

    public String getWeid(String name,String idCard,String gender,String userAddress) throws IOException {
        String url = "http://localhost:8083/master/getWeid";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        MultiValueMap map = new LinkedMultiValueMap();
        map.add("name",name);
        map.add("idCard",idCard);
        map.add("gender",gender);
        map.add("userAddress",userAddress);
        HttpEntity requestBody = new HttpEntity(map, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity responseEntity = restTemplate.postForEntity(url, requestBody, String.class);
        String weid = (String)responseEntity.getBody();
        return weid;
    }

    public int CheckBalance(String userAddress){
        String url = "http://localhost:8083/master/checkBalance";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        MultiValueMap map = new LinkedMultiValueMap();
        map.add("userAddress",userAddress);
        HttpEntity requestBody = new HttpEntity(map, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity responseEntity = restTemplate.postForEntity(url, requestBody, int.class);
        int res = (int)responseEntity.getBody();
        return res;
    }

    public String publishOrder(String userAddress, String title, int price, String description){
        String url = "http://localhost:8083/master/publishOrder";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        MultiValueMap map = new LinkedMultiValueMap();
        map.add("userAddress",userAddress);
        map.add("title",title);
        map.add("price",price);
        map.add("description",description);
        HttpEntity requestBody = new HttpEntity(map, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity responseEntity = restTemplate.postForEntity(url, requestBody, String.class);
        String res = (String)responseEntity.getBody();
        return res;
    }

    public boolean initBalance(String adminAddress,String initial_userAddress,int initial_coin) throws JsonProcessingException {
        String url = "http://localhost:8083/master/initBalance";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        MultiValueMap map = new LinkedMultiValueMap();
        map.add("adminAddress",adminAddress);
        map.add("initial_userAddress",initial_userAddress);
        map.add("initial_coin",initial_coin);
        HttpEntity requestBody = new HttpEntity(map, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity responseEntity = restTemplate.postForEntity(url, requestBody, boolean.class);
        boolean res = (boolean)responseEntity.getBody();
        return res;
    }


    public boolean reviewOrder(String adminAddress,String orderAddress) throws JsonProcessingException {
        String url = "http://localhost:8083/master/reviewOrder";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        MultiValueMap map = new LinkedMultiValueMap();
        map.add("adminAddress",adminAddress);
        map.add("orderAddress",orderAddress);
        HttpEntity requestBody = new HttpEntity(map, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity responseEntity = restTemplate.postForEntity(url, requestBody, boolean.class);
        boolean res = (boolean)responseEntity.getBody();
        return res;
    }


    public boolean acceptOrder(String userAddress,String orderAddress) throws JsonProcessingException {
        String url = "http://localhost:8083/master/acceptOrder";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        MultiValueMap map = new LinkedMultiValueMap();
        map.add("userAddress",userAddress);
        map.add("orderAddress",orderAddress);
        HttpEntity requestBody = new HttpEntity(map, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity responseEntity = restTemplate.postForEntity(url, requestBody, boolean.class);
        boolean res = (boolean)responseEntity.getBody();
        return res;
    }


    public boolean volunteerFinishOrder(String userAddress, String orderAddress) throws JsonProcessingException {
        String url = "http://localhost:8083/master/volunteerFinishOrder";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        MultiValueMap map = new LinkedMultiValueMap();
        map.add("userAddress",userAddress);
        map.add("orderAddress",orderAddress);
        HttpEntity requestBody = new HttpEntity(map, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity responseEntity = restTemplate.postForEntity(url, requestBody, boolean.class);
        boolean res = (boolean)responseEntity.getBody();
        return res;
    }


    public boolean assessVolunteer(String userAddress, String orderAddress) throws JsonProcessingException {
        String url = "http://localhost:8083/master/assessVolunteer";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        MultiValueMap map = new LinkedMultiValueMap();
        map.add("userAddress",userAddress);
        map.add("orderAddress",orderAddress);
        HttpEntity requestBody = new HttpEntity(map, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity responseEntity = restTemplate.postForEntity(url, requestBody, boolean.class);
        boolean res = (boolean)responseEntity.getBody();
        return res;
    }





}
