package org.example.TB;

import cn.hutool.core.lang.Dict;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.example.TB.utils.IOUtil;
import org.example.TB.utils.WEBASEUtil;
import org.example.TB.utils.WeidRequestUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

@SpringBootTest
@Slf4j
public class WeidTest {


    /**
     * 生成weid，每个用户都生成，同钱包地址，是一个身份认证的凭证
     */
    @Test
    public void createWeIdTest() throws IOException {
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
    }
    @Test

    public void CredentialCreationTest(String weid,String name,String idCard,String gender,String userAddress) {
//    public void CredentialCreationTest() throws JsonProcessingException {
        // 构造请求参数
        JSONObject functionArg = new JSONObject();
        functionArg.put("cptId", 2000001);

        //每个人一开始生成的weid createWeId
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

}


