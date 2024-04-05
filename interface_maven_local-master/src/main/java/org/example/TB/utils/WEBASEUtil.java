package org.example.TB.utils;

import cn.hutool.core.lang.Dict;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.example.TB.request.OkHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class WEBASEUtil {

    public static Dict funcRequest(
            String userAddress,
            String funcName,
            List funcParam,
            String contractName,
            String contractAddress,
            String ABI){
        JSONArray abiJSON = JSONUtil.parseArray(ABI);
        JSONObject data = JSONUtil.createObj();
        data.set("groupId","1");
        data.set("user",userAddress);
        data.set("contractName",contractName);
        data.set("version","");
        data.set("funcName",funcName);
        data.set("funcParam",funcParam);
        data.set("contractAddress",contractAddress);
        data.set("contractAbi",abiJSON);
        data.set("useAes",false);
        data.set("useCns",false);
        data.set("cnsName","");
        String dataString = JSONUtil.toJsonStr(data);
        String responseBody = HttpRequest.post("http://43.139.97.90:5002/WeBASE-Front/trans/handle")
                .header(Header.CONTENT_TYPE,"application/json")
                .body(dataString)
                .execute()
                .body();
        Dict retDict = new Dict();
        retDict.set("result",responseBody);
        return retDict;

    }

    public static Dict deployRequest(
            String userAddress,
            List funcParam,
            String contractName,
            String bin,
            String ABI){
        JSONArray abiJSON = JSONUtil.parseArray(ABI);
        JSONObject data = JSONUtil.createObj();
        data.set("groupId","1");
        data.set("user",userAddress);
        data.set("contractName",contractName);
        data.set("funcParam",funcParam);
        data.set("abiInfo",abiJSON);
        data.set("bytecodeBin",bin);

        String dataString = JSONUtil.toJsonStr(data);
        String responseBody = HttpRequest.post("http://43.139.97.90:5002/WeBASE-Front/contract/deploy")
                .header(Header.CONTENT_TYPE,"application/json")
                .body(dataString)
                .execute()
                .body();
        Dict retDict = new Dict();
        retDict.set("result",responseBody);
        return retDict;

    }



}
