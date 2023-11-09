package com.hjj.controller;

import com.hjj.pojo.Address;
import com.hjj.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseController {
    @RequestMapping("/responseParam")
    public Result responseParam(){
        Address addr=new Address();
        addr.setCity("北京");
        addr.setProvince("北京");
        return Result.success(addr);
    }
}
