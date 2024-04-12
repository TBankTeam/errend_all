package org.example.TB.utils;

import cn.hutool.core.lang.Dict;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.fisco.bcos.sdk.crypto.CryptoSuite;
import org.fisco.bcos.sdk.crypto.keypair.CryptoKeyPair;
import org.fisco.bcos.sdk.model.CryptoType;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;


@Component
@Slf4j
public class TokenUtil {

    //生成钱包地址
    public static String getWallet(String username) throws JsonProcessingException {
        CryptoSuite cryptoSuite = new CryptoSuite(CryptoType.ECDSA_TYPE);
        CryptoKeyPair cryptoKeyPair = cryptoSuite.createKeyPair();

        //生成私钥
        String privateKey = cryptoKeyPair.getHexPrivateKey();
        //用户名
        //String userName = username;
        JSONObject data = JSONUtil.createObj();
        data.set("privateKey", privateKey);
        data.set("userName", username);

        String dataString = JSONUtil.toJsonStr(data);
        HttpResponse responseBody = HttpRequest
                .get("http://43.139.97.90:5002/WeBASE-Front/privateKey/import?privateKey="
                        + privateKey
                        + "&userName="
                        + username + "")
                .header(Header.CONTENT_TYPE, "application/json")
                .body(dataString)
                .execute();
        String response = responseBody.body();
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = objectMapper.readValue(response, Map.class);
        String address = (String) map.get("address");
        return address;
    }


    public static String getWeid() throws IOException {
        // 构造 functionArg 和 transactionArg JSON 对象
        JSONObject functionArg = new JSONObject();
        JSONObject transactionArg = new JSONObject();

        // 调用 createWeIdRequest 方法
        Dict result = WeidRequestUtil.createWeIdRequest(functionArg, transactionArg);

        // 输出结果
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = objectMapper.readValue(result.getStr("result"), Map.class);
        String weid = (String) map.get("respBody");
        System.out.println("weid:" + weid);
        return weid;
    }


    public static void CredentialCreation(String weid,String name,String idCard,String gender,String userAddress) {
//    public void CredentialCreationTest() throws JsonProcessingException {
        // 构造请求参数
        JSONObject functionArg = new JSONObject();
        functionArg.put("cptId", 2000001);

        //每个人一开始生成的weid createWeId

//        String issuer = "did:weid:1000:0xeac2fca8f94a008b3a7217611a58766f22968beb";

        String issuer = "did:weid:1000:0x3fb5fabac7e1da04365a58e2ae36793bbd2d5c43";
        functionArg.put("issuer", weid);

        functionArg.put("expirationDate", "2034-04-04T21:12:33Z");

        JSONObject claim = new JSONObject();

        //链上数据包含了姓名 (name)、身份证 (idCard)、性别 (gender) 和用户身份地址 (userAddress)
        claim.put("name", name);
        claim.put("idCard", idCard);
        if(gender.equals("男")){
            gender = "M";
        }else {
            gender = "f";
        }
        claim.put("gender", gender);
        claim.put("userAddress", userAddress);
        functionArg.put("claim", claim);

        JSONObject transactionArg = new JSONObject();
        transactionArg.put("invokerWeId", weid);

        // 调用创建凭证的请求方法
        Dict result = WeidRequestUtil.createCredentialRequest(functionArg, transactionArg);

        // 输出结果
        System.out.println("Credential creation result: " + result.get("result"));
    }



    //生成order
    public static String createOrder(String userAddress, String title, int price, String description) throws JsonProcessingException {
        //String userAddress = "0x925dfccfb7d2e6c1cafb7aa30acfcc2620efbc49";
        String ABI = IOUtil.readResourceAsString("abi/P2PTime.abi");
        String BIN = IOUtil.readResourceAsString("bin/ecc/P2PTime.bin");
        ArrayList funcParam = new ArrayList();
        String tokenTimeAddress = "0x429fec5345d9e247af1cc9bc76145b8f0a2ea142";
        //String title = "救救我";
        //int price = 1;
        //String description = "你试试";
        funcParam.add(tokenTimeAddress); // Example address for _tokenTime
        funcParam.add(title); // Example string for _title
        funcParam.add(price); // Example uint256 for _price
        funcParam.add(description); // Example string for _description
        String contractName = "P2PTime";
        Dict result = WEBASEUtil.deployRequest(userAddress, funcParam, contractName, BIN, ABI);
        String orderAddress = result.getStr("result");
        System.out.println("orderAddress: " + orderAddress);
        // 尝试解析结果前先打印中间结果
        try {
            JSONObject resBody = JSONUtil.parseObj(result);
            System.out.println("Parsed Result createOrder: " + resBody.toString());
        } catch (Exception e) {
            System.out.println("Error parsing result: " + e.getMessage());
            e.printStackTrace();
        }
        return orderAddress;
    }

    //发布订单
    public static boolean publishOrder(String userAddress,String orderAddress) throws JsonProcessingException {
        //String userAddress = "0x925dfccfb7d2e6c1cafb7aa30acfcc2620efbc49";
        String funcName = "publish";
        String ABI = IOUtil.readResourceAsString("abi/P2PTime.abi");
//        ArrayList funcParam = new ArrayList();
//        funcParam.add("");
        ArrayList funcParam = null;
        String contractName = "P2PTime";
        //订单号
        //String orderAddress = "0x837620a1930ddf2e5d75eb42811dd5a80343de83";
        System.out.println("userAddress:"+userAddress);
        log.error("orderAddress:" + orderAddress);

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
        return res;
    }

    //赋予初始时间币
    public static boolean initBalance(String adminAddress,String initial_userAddress,int initial_coin) throws JsonProcessingException {
        //管理员地址
        //String adminAddress = "0x925dfccfb7d2e6c1cafb7aa30acfcc2620efbc49";
        String funcName = "initial_balance";
        String ABI = IOUtil.readResourceAsString("abi/TimeCoin.abi");

        ArrayList funcParam = new ArrayList();
        //String initial_userAddress ="0x92bb0d550c3d209114a98b9fd8c67a3b129c62de";//初始化人的地址
        //int initial_coin = 10;//初始化数量
        funcParam.add(initial_userAddress);
        funcParam.add(initial_coin);
        String contractName = "TimeCoin";
        //时间币合约地址
        String contractAddress = "0x429fec5345d9e247af1cc9bc76145b8f0a2ea142";

        System.out.println("adminAddress:"+adminAddress);
        System.out.println("initial_userAddress:"+initial_userAddress);
        System.out.println("initial_coin:"+initial_coin);

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
        return res;
    }


    public static boolean reviewOrder(String adminAddress,String orderAddress) throws JsonProcessingException {
        //String adminAddress = "0x925dfccfb7d2e6c1cafb7aa30acfcc2620efbc49";
        String funcName = "reviewTask";
        String ABI = IOUtil.readResourceAsString("abi/P2PTime.abi");
        ArrayList funcParam = new ArrayList();
        int score = 10;
        boolean finished = true;
        funcParam.add(finished);
        funcParam.add(score);
        //ArrayList funcParam = null;
        String contractName = "P2PTime";
        //String orderAddress = "0xc5c50b9884f4cd8fdffe6cd47c0ae60fcf10e53c";
        Dict result = WEBASEUtil.funcRequest(adminAddress,funcName,funcParam,contractName,orderAddress,ABI);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = objectMapper.readValue(result.getStr("result"), Map.class);
        boolean res = (boolean) map.get("statusOK");
// 尝试解析结果前先打印中间结果
        try {
            JSONObject resBody = JSONUtil.parseObj(result);
            System.out.println("Parsed Result: " + resBody.toString());
        } catch (Exception e) {
            System.out.println("Error parsing result: " + e.getMessage());
            e.printStackTrace();
        }
        return res;
    }


    public static boolean acceptOrder(String userAddress, String orderAddress) throws JsonProcessingException {
        //String userAddress = "0xb3504aa728402067032cef0e75794e891327f0c5";
        String funcName = "applyAsVolunteer";
        String ABI = IOUtil.readResourceAsString("abi/P2PTime.abi");
//        ArrayList funcParam = new ArrayList();
//        funcParam.add("");
        ArrayList funcParam = null;
        String contractName = "P2PTime";
        //String orderAddress = "0xc5c50b9884f4cd8fdffe6cd47c0ae60fcf10e53c";
        Dict result = WEBASEUtil.funcRequest(userAddress,funcName,funcParam,contractName,orderAddress,ABI);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = objectMapper.readValue(result.getStr("result"), Map.class);
        log.error(map.toString());
        boolean res = (boolean) map.get("statusOK");
        log.error(String.valueOf(res));
// 尝试解析结果前先打印中间结果
        try {
            JSONObject resBody = JSONUtil.parseObj(result);
            System.out.println("Parsed Result: " + resBody.toString());
        } catch (Exception e) {
            System.out.println("Error parsing result: " + e.getMessage());
            e.printStackTrace();
        }
        return res;
    }


    public static boolean volunteerFinishOrder(String userAddress, String orderAddress) throws JsonProcessingException {
        //String userAddress = "0xb3504aa728402067032cef0e75794e891327f0c5";
        String funcName = "volunteer_finishOrder";
        String ABI = IOUtil.readResourceAsString("abi/P2PTime.abi");
        ArrayList funcParam = new ArrayList();
        boolean finished = true;  // 使用 true 表示布尔值
        // 添加参数到 funcParam 列表
        funcParam.add(finished);
//        ArrayList funcParam = null;
        String contractName = "P2PTime";
        //String orderAddress = "0xc5c50b9884f4cd8fdffe6cd47c0ae60fcf10e53c";
        Dict result = WEBASEUtil.funcRequest(userAddress,funcName,funcParam,contractName,orderAddress,ABI);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = objectMapper.readValue(result.getStr("result"), Map.class);
        boolean res = (boolean) map.get("statusOK");
// 尝试解析结果前先打印中间结果
        try {
            JSONObject resBody = JSONUtil.parseObj(result);
            System.out.println("Parsed Result: " + resBody.toString());
        } catch (Exception e) {
            System.out.println("Error parsing result: " + e.getMessage());
            e.printStackTrace();
        }
        return res;
    }


    public static String assessVolunteer(String userAddress, String orderAddress) throws JsonProcessingException {
        //String userAddress = "0x925dfccfb7d2e6c1cafb7aa30acfcc2620efbc49";
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
        //String orderAddress = "0xc5c50b9884f4cd8fdffe6cd47c0ae60fcf10e53c";
        Dict result = WEBASEUtil.funcRequest(userAddress,funcName,funcParam,contractName,orderAddress,ABI);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = objectMapper.readValue(result.getStr("result"), Map.class);
        String res = (String) map.get("transactionHash");
// 尝试解析结果前先打印中间结果
        try {
            JSONObject resBody = JSONUtil.parseObj(result);
            System.out.println("Parsed Result: " + resBody.toString());
        } catch (Exception e) {
            System.out.println("Error parsing result: " + e.getMessage());
            e.printStackTrace();
        }
        return res;
    }



    public static int checkBalance(String userAddress) throws JsonProcessingException {
        //String userAddress = "0xb3504aa728402067032cef0e75794e891327f0c5";
        String funcName = "balanceOf";
        String ABI = IOUtil.readResourceAsString("abi/TimeCoin.abi");
        ArrayList funcParam = new ArrayList();
        funcParam.add(userAddress);
        String contractName = "TimeCoin";
        String contractAddress = "0x429fec5345d9e247af1cc9bc76145b8f0a2ea142";
        Dict result = WEBASEUtil.funcRequest(userAddress,funcName,funcParam,contractName,contractAddress,ABI);
        String result1 = result.getStr("result").replace("[\"", "").replace("\"]", "");
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

        return res;
    }



}
