package org.example.TB.utils;

import cn.hutool.core.lang.Dict;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

public class WeidRequestUtil {


    //生成weid
    public static Dict createWeIdRequest(

            JSONObject functionArg,
            JSONObject transactionArg) {
        JSONObject data = new JSONObject();
        data.put("functionArg", functionArg);
        data.put("transactionArg", transactionArg);
        data.put("functionName", "createWeId");
        data.put("v", "1.0.0");

        String dataString = JSONUtil.toJsonStr(data);
        String responseBody = HttpRequest.post("http://43.139.97.90:6001/weid/api/invoke")
                .header(Header.CONTENT_TYPE, "application/json")
                .body(dataString)
                .execute()
                .body();
        Dict retDict = new Dict();
        retDict.put("result", responseBody);
        return retDict;
    }

    public static Dict createCredentialRequest(JSONObject functionArg, JSONObject transactionArg) {
        JSONObject data = new JSONObject();
        data.put("functionArg", functionArg);
        data.put("transactionArg", transactionArg);
        data.put("functionName", "createCredential");
        data.put("v", "1.0.0");

        String dataString = JSONUtil.toJsonStr(data);
        String responseBody = HttpRequest.post("http://43.139.97.90:6001/weid/api/invoke")
                .header(Header.CONTENT_TYPE, "application/json")
                .body(dataString)
                .execute()
                .body();
        Dict retDict = new Dict();
        retDict.put("result", responseBody);
        return retDict;
    }

    public static Dict weidRequest(
            String userAddress,
            JSONObject functionArg,
            JSONObject transactionArg) {
        JSONObject data = new JSONObject();
        data.put("functionArg", functionArg);
        data.put("transactionArg", transactionArg);
        data.put("functionName", "registerAuthorityIssuer");
        data.put("v", "1.0.0");

        String dataString = JSONUtil.toJsonStr(data);
        String responseBody = HttpRequest.post("http://43.139.97.90:5002/WeBASE-Front/contract/deploy")
                .header(Header.CONTENT_TYPE, "application/json")
                .body(dataString)
                .execute()
                .body();
        Dict retDict = new Dict();
        retDict.put("result", responseBody);
        return retDict;
    }
}
