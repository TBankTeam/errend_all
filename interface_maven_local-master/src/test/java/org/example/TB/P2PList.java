package org.example.TB;

import cn.hutool.core.lang.Dict;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.example.TB.utils.IOUtil;
import org.example.TB.utils.WEBASEUtil;
import org.example.TB.utils.WeidRequestUtil;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class P2PList {
    @Test

    /**
     * 订单生成时记录
     */
    public void listInsert() {

        String userAddress = "0x925dfccfb7d2e6c1cafb7aa30acfcc2620efbc49";
        String funcName = "insert";
        String ABI = IOUtil.readResourceAsString("abi/P2PTable.abi");
        ArrayList funcParam = new ArrayList();

        //订单记录
        String p2p_address ="111";
        String owner_address ="111";
        String title ="111";
        int price = 0;
        String description ="111";

        //状态一开始统一为0
        int state = 0;
        //funcParam.add("0x925dfccfb7d2e6c1cafb7aa30acfcc2620efbc49");
        funcParam.add(p2p_address);
        funcParam.add(owner_address);
        funcParam.add(title);
        funcParam.add(price);
        funcParam.add(description);
        funcParam.add(state);

        String contractName = "P2PTable";
        String contractAddress = "0x7d213ea90e777d5a013ac46a8ff888dd4dd7911f";
        Dict result = WEBASEUtil.funcRequest(userAddress,funcName,funcParam,contractName,contractAddress,ABI);
        System.out.println("Raw Result: " + result.toString());

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
    public void listUpdate() {

        String userAddress = "0x925dfccfb7d2e6c1cafb7aa30acfcc2620efbc49";
        String funcName = "update";
        String ABI = IOUtil.readResourceAsString("abi/P2PTable.abi");
        ArrayList funcParam = new ArrayList();

        //订单记录
        String p2p_address ="111";
        String volunteer_address ="222";

        int state = 2;
        //funcParam.add("0x925dfccfb7d2e6c1cafb7aa30acfcc2620efbc49");
        funcParam.add(p2p_address);
        funcParam.add(volunteer_address);
        funcParam.add(state);

        String contractName = "P2PTable";
        String contractAddress = "0x7d213ea90e777d5a013ac46a8ff888dd4dd7911f";
        Dict result = WEBASEUtil.funcRequest(userAddress,funcName,funcParam,contractName,contractAddress,ABI);
        System.out.println("Raw Result: " + result.toString());

// 尝试解析结果前先打印中间结果
        try {
            JSONObject resBody = JSONUtil.parseObj(result);
            System.out.println("Parsed Result: " + resBody.toString());
        } catch (Exception e) {
            System.out.println("Error parsing result: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
