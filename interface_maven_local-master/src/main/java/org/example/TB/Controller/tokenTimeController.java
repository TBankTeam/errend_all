//package org.example.TB.Controller;
//
//
//import lombok.extern.slf4j.Slf4j;
//import org.example.TB.service.P2PTimeService;
//import org.example.TB.service.TokenTimeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Slf4j
//@Controller
//public class tokenTimeController {
//
//    @Autowired
//    private TokenTimeService service;
//
//    @GetMapping("balanceOf")
//    public String set(@RequestParam("address") String address) throws Exception {
//        System.out.println("address = " + address);
//        return service.balanceOf(address);
//    }
//
//    @GetMapping("get")
//    public String get() throws Exception {
//        return service.get();
//    }
//
//
//}
