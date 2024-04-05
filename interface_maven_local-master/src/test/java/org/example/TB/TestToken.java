package org.example.TB;

import cn.hutool.core.lang.Dict;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.example.TB.service.TimeCoinService;
import org.example.TB.utils.IOUtil;
import org.example.TB.utils.WEBASEUtil;
import org.fisco.bcos.sdk.crypto.CryptoSuite;
import org.fisco.bcos.sdk.crypto.keypair.CryptoKeyPair;
import org.fisco.bcos.sdk.model.CryptoType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.util.ArrayList;
import java.util.Map;

@SpringBootTest
@Slf4j
public class TestToken {

    @Autowired
    TimeCoinService service;


    //P2P:0x85ac286d96fda34fc336a87a7be8fe8af7c1e9ab
    //admin:0x925dfccfb7d2e6c1cafb7aa30acfcc2620efbc49
    //TimeCoin:0x429fec5345d9e247af1cc9bc76145b8f0a2ea142
    //p2PTableAddress=0x5a112f5d63bea688157f571ab6e7286835684ffe

    @Test
    /**
     * 部署合约(生成订单)
     */

    public void deploy_P2PTimeTest(){
        String userAddress = "0x925dfccfb7d2e6c1cafb7aa30acfcc2620efbc49";
        String ABI = IOUtil.readResourceAsString("abi/P2PTime.abi");
        String BIN = IOUtil.readResourceAsString("bin/ecc/P2PTime.bin");

        ArrayList funcParam = new ArrayList();
        String tokenTimeAddress = "0x429fec5345d9e247af1cc9bc76145b8f0a2ea142";
        String title = "救救我";
        int price = 1;
        String description = "你试试";
        funcParam.add(tokenTimeAddress); // Example address for _tokenTime
        funcParam.add(title); // Example string for _title
        funcParam.add(price); // Example uint256 for _price
        funcParam.add(description); // Example string for _description

        String contractName = "P2PTime";

        Dict result = WEBASEUtil.deployRequest(userAddress,funcParam,contractName,BIN,ABI);
        System.out.println("orderAddress: " + result.getStr("result"));

// 尝试解析结果前先打印中间结果
        try {
            JSONObject resBody = JSONUtil.parseObj(result);
            System.out.println("Parsed Result: " + resBody.toString());
        } catch (Exception e) {
            System.out.println("Error parsing result: " + e.getMessage());
            e.printStackTrace();
        }
    }


    @Test
    /**
     * 发布任务
     */
    public void publishTest() throws JsonProcessingException {
        String userAddress = "0x925dfccfb7d2e6c1cafb7aa30acfcc2620efbc49";
        String funcName = "publish";
        String ABI = IOUtil.readResourceAsString("abi/P2PTime.abi");
//        ArrayList funcParam = new ArrayList();
//        funcParam.add("");
        ArrayList funcParam = null;
        String contractName = "P2PTime";
        //订单号
        String orderAddress = "0xc5c50b9884f4cd8fdffe6cd47c0ae60fcf10e53c";
        Dict result = WEBASEUtil.funcRequest(userAddress,funcName,funcParam,contractName,orderAddress,ABI);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = objectMapper.readValue(result.getStr("result"), Map.class);
        boolean res = (boolean) map.get("statusOK");
        System.out.println(res);
// 尝试解析结果前先打印中间结果
        try {
            JSONObject resBody = JSONUtil.parseObj(result);
            System.out.println("Parsed Result: " + resBody.toString());
        } catch (Exception e) {
            System.out.println("Error parsing result: " + e.getMessage());
            e.printStackTrace();
        }
    }


    @Test
    /**
     * 查看余额
     */
    public void balanceOfTest() throws JsonProcessingException {
        String userAddress = "0xb3504aa728402067032cef0e75794e891327f0c5";
        String funcName = "balanceOf";
        String ABI = IOUtil.readResourceAsString("abi/TimeCoin.abi");
        ArrayList funcParam = new ArrayList();
        funcParam.add(userAddress);
        String contractName = "TimeCoin";
        String contractAddress = "0x429fec5345d9e247af1cc9bc76145b8f0a2ea142";
        Dict result = WEBASEUtil.funcRequest(userAddress,funcName,funcParam,contractName,contractAddress,ABI);
        System.out.println("Raw Result: " + result.toString());
        System.out.println("Raw Result: " + result.getStr("result"));
        String result1 = result.getStr("result").replace("[\"", "").replace("\"]", "");
        System.out.println("result1:" + result1);
        int res = Integer.parseInt(result1);
        System.out.println("res:" + res);

        // 尝试解析结果前先打印中间结果
        try {
            JSONObject resBody = JSONUtil.parseObj(result);
            System.out.println("Parsed Result: " + resBody.toString());
        } catch (Exception e) {
            System.out.println("Error parsing result: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //初始化时间时间币数量
    @Test
    public void initial_balanceTest() throws JsonProcessingException {
        String adminAddress = "0x925dfccfb7d2e6c1cafb7aa30acfcc2620efbc49";
        String funcName = "initial_balance";
        String ABI = IOUtil.readResourceAsString("abi/TimeCoin.abi");

        ArrayList funcParam = new ArrayList();
        String initial_userAddress ="0xb3504aa728402067032cef0e75794e891327f0c5";//初始化人的地址
        int initial_coin = 10;//初始化数量
        funcParam.add(initial_userAddress);
        funcParam.add(initial_coin);
        String contractName = "TimeCoin";
        //时间币合约地址
        String contractAddress = "0x429fec5345d9e247af1cc9bc76145b8f0a2ea142";
        Dict result = WEBASEUtil.funcRequest(adminAddress,funcName,funcParam,contractName,contractAddress,ABI);
        System.out.println("Raw Result: " + result.toString());
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = objectMapper.readValue(result.getStr("result"), Map.class);
        boolean res = (boolean) map.get("statusOK");
        System.out.println(res);
// 尝试解析结果前先打印中间结果
        try {
            JSONObject resBody = JSONUtil.parseObj(result);
            System.out.println("Parsed Result: " + resBody.toString());
        } catch (Exception e) {
            System.out.println("Error parsing result: " + e.getMessage());
            e.printStackTrace();
        }
    }




    @Test
    /**
     * 审核任务
     */
    public void reviewTest() throws JsonProcessingException {
        String adminAddress = "0x925dfccfb7d2e6c1cafb7aa30acfcc2620efbc49";
        String funcName = "reviewTask";
        String ABI = IOUtil.readResourceAsString("abi/P2PTime.abi");
        ArrayList funcParam = new ArrayList();
        int score = 10;
        boolean finished = true;
        funcParam.add(finished);
        funcParam.add(score);
        //ArrayList funcParam = null;
        String contractName = "P2PTime";
        String orderAddress = "0xc5c50b9884f4cd8fdffe6cd47c0ae60fcf10e53c";
        Dict result = WEBASEUtil.funcRequest(adminAddress,funcName,funcParam,contractName,orderAddress,ABI);
        System.out.println("Raw Result: " + result.toString());
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = objectMapper.readValue(result.getStr("result"), Map.class);
        boolean res = (boolean) map.get("statusOK");
        System.out.println(res);
// 尝试解析结果前先打印中间结果
        try {
            JSONObject resBody = JSONUtil.parseObj(result);
            System.out.println("Parsed Result: " + resBody.toString());
        } catch (Exception e) {
            System.out.println("Error parsing result: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    /**
     * 接受任务
     */
    public void applyVolunteerTest() throws JsonProcessingException {
        String userAddress = "0xb3504aa728402067032cef0e75794e891327f0c5";
        String funcName = "applyAsVolunteer";
        String ABI = IOUtil.readResourceAsString("abi/P2PTime.abi");
//        ArrayList funcParam = new ArrayList();
//        funcParam.add("");
        ArrayList funcParam = null;
        String contractName = "P2PTime";
        String orderAddress = "0xc5c50b9884f4cd8fdffe6cd47c0ae60fcf10e53c";
        Dict result = WEBASEUtil.funcRequest(userAddress,funcName,funcParam,contractName,orderAddress,ABI);
        System.out.println("Raw Result: " + result.toString());
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = objectMapper.readValue(result.getStr("result"), Map.class);
        boolean res = (boolean) map.get("statusOK");
        System.out.println(res);
// 尝试解析结果前先打印中间结果
        try {
            JSONObject resBody = JSONUtil.parseObj(result);
            System.out.println("Parsed Result: " + resBody.toString());
        } catch (Exception e) {
            System.out.println("Error parsing result: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //志愿者点击完成任务
    @Test
    public void volunteer_finishOrder() throws JsonProcessingException {
        String userAddress = "0xb3504aa728402067032cef0e75794e891327f0c5";
        String funcName = "volunteer_finishOrder";
        String ABI = IOUtil.readResourceAsString("abi/P2PTime.abi");
        ArrayList funcParam = new ArrayList();
        boolean finished = true;  // 使用 true 表示布尔值
        // 添加参数到 funcParam 列表
        funcParam.add(finished);
//        ArrayList funcParam = null;
        String contractName = "P2PTime";
        String orderAddress = "0xc5c50b9884f4cd8fdffe6cd47c0ae60fcf10e53c";
        Dict result = WEBASEUtil.funcRequest(userAddress,funcName,funcParam,contractName,orderAddress,ABI);
        System.out.println("Raw Result: " + result.toString());
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = objectMapper.readValue(result.getStr("result"), Map.class);
        boolean res = (boolean) map.get("statusOK");
        System.out.println(res);
// 尝试解析结果前先打印中间结果
        try {
            JSONObject resBody = JSONUtil.parseObj(result);
            System.out.println("Parsed Result: " + resBody.toString());
        } catch (Exception e) {
            System.out.println("Error parsing result: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //需求者点击完成
    @Test
    public void assess_volunteerTest() throws JsonProcessingException {
        String userAddress = "0x925dfccfb7d2e6c1cafb7aa30acfcc2620efbc49";
        String funcName = "assess_volunteer";
        String ABI = IOUtil.readResourceAsString("abi/P2PTime.abi");
        ArrayList funcParam = new ArrayList();
        int score = 10;
        boolean finished = true;  // 使用 true 表示布尔值
        // 添加参数到 funcParam 列表
        funcParam.add(score);
        funcParam.add(finished);
//        ArrayList funcParam = null;
        String contractName = "P2PTime";
        String orderAddress = "0xc5c50b9884f4cd8fdffe6cd47c0ae60fcf10e53c";
        Dict result = WEBASEUtil.funcRequest(userAddress,funcName,funcParam,contractName,orderAddress,ABI);
        System.out.println("Raw Result: " + result.toString());
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = objectMapper.readValue(result.getStr("result"), Map.class);
        boolean res = (boolean) map.get("statusOK");
        System.out.println(res);
// 尝试解析结果前先打印中间结果
        try {
            JSONObject resBody = JSONUtil.parseObj(result);
            System.out.println("Parsed Result: " + resBody.toString());
        } catch (Exception e) {
            System.out.println("Error parsing result: " + e.getMessage());
            e.printStackTrace();
        }
    }


    @Test
    public void getAccountUtils(){
        String responseBody = HttpRequest
                .get("http://192.168.86.3:5002/WeBASE-Front/privateKey/localKeyStores")
                .header(Header.CONTENT_TYPE,"application/json")
                .execute()
                .body();
        JSONArray jsonArray = JSONUtil.parseArray(responseBody);
        Object json =jsonArray.get(1);
        JSONObject jsonObject = JSONUtil.parseObj(json);
        Object userName = jsonObject.get("userName");
        System.out.println(userName);
    }

    @Test
    public void getTransNum(){
        String responseBody = HttpRequest
                .get("http://192.168.86.3:5002/WeBASE-Front/"+1+"/web3/transaction-total")
                .header(Header.CONTENT_TYPE,"application/json")
                .execute()
                .body();
        System.out.println(responseBody);

    }

    //生成外部账户
    @Test
    public void publicAndPrivateKey_generationUtils(){
        CryptoSuite cryptoSuite = new CryptoSuite(CryptoType.ECDSA_TYPE);
        CryptoKeyPair cryptoKeyPair = cryptoSuite.createKeyPair();

        //生成私钥
        String privateKey = cryptoKeyPair.getHexPrivateKey();
        //用户名
        String userName = "test100";
        JSONObject data = JSONUtil.createObj();
        data.set("privateKey",privateKey);
        data.set("userName",userName);

        String dataString = JSONUtil.toJsonStr(data);
        String responseBody = HttpRequest
                .get("http://43.139.97.90:5002/WeBASE-Front/privateKey/import?privateKey="
                        + privateKey
                        +"&userName="
                        +userName + "")
                .header(Header.CONTENT_TYPE,"application/json")
                .body(dataString)
                .execute()
                .body();
        Dict retDict = new Dict();
        retDict.set("result", responseBody);
        System.out.println(responseBody);

    }


//    @Test
//    public void P2PTable_insertTest(){
//        String userAddress = "0x925dfccfb7d2e6c1cafb7aa30acfcc2620efbc49";
//        String funcName = "insert";
//        String ABI = IOUtil.readResourceAsString("abi/P2PTable.abi");
//        ArrayList funcParam = new ArrayList();
//
//
//        String p2p_address ="0x85ac286d96fda34fc336a87a7be8fe8af7c1e9ab";
//        String owner_address = "0x925dfccfb7d2e6c1cafb7aa30acfcc2620efbc49" ;
//        String title = "救救我";
//        int price = 1;
//        String description = "你试试";
//        int state = 0 ;
//
//        // 添加参数到 funcParam 列表
//        funcParam.add(p2p_address);
//        funcParam.add(owner_address);
//        funcParam.add(title);
//        funcParam.add(price);
//        funcParam.add(description);
//        funcParam.add(state);
//
////        ArrayList funcParam = null;
//        String contractName = "P2PTable";
//        String contractAddress = "0x5a112f5d63bea688157f571ab6e7286835684ffe";
//        Dict result = WEBASEUtil.funcRequest(userAddress,funcName,funcParam,contractName,contractAddress,ABI);
//        System.out.println("Raw Result: " + result.toString());
//
//// 尝试解析结果前先打印中间结果
//        try {
//            JSONObject resBody = JSONUtil.parseObj(result);
//            System.out.println("Parsed Result: " + resBody.toString());
//        } catch (Exception e) {
//            System.out.println("Error parsing result: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }


}
