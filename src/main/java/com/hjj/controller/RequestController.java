package com.hjj.controller;

import com.hjj.pojo.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class RequestController {
    //老方式
   /* @RequestMapping("/simpleParam")
    public String simpleParam(HttpServletRequest request){
        String name = request.getParameter("name");
        String ageStr = request.getParameter("age");
        int age = Integer.parseInt(ageStr);
        System.out.println(name+":"+age);
        return "OK!";
    }*/

    // springboot方式
    //1.简单参数
    @RequestMapping("/simpleParam")
    public String simpleParam(@RequestParam(name="name",required = false) String username, Integer age){
        System.out.println(username+":"+age);
        return "OK!";
    }
    //2.实体参数
    @RequestMapping("/simplePojo")
    public String simplePojo(User user){
        System.out.println(user);
        System.out.println(user.getName()+":"+user.getAge());
        return "OK!";
    }
    //3.数组参数
    @RequestMapping("/arrayParam")
    public String arrayParam(String[] hobby){
        for (int i = 0; i < hobby.length; i++) {
            System.out.print(hobby[i]+" ");
        }
        System.out.println(Arrays.toString(hobby));
        return "OK!";
    }
    //3.集合参数
    @RequestMapping("/listParam")
    public String listParam(@RequestParam ArrayList<String> hobby){
        System.out.println(hobby);
        return "OK!";
    }
    //4.日期参数
    @RequestMapping("/dateParam")
    public String dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime){
        System.out.println(updateTime);
        return "OK!";
    }
    //5.JSON参数
    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User user){
        System.out.println(user);
        return "OK!";
    }
    //6.路径参数
    @RequestMapping("/path/{id}/{name}")
    public String pathParam(@PathVariable Integer id, @PathVariable String name){
        System.out.println(id);
        System.out.println(name);
        return "OK!";
    }

}
