package com.hjj.controller;

import com.hjj.pojo.Emp;
import com.hjj.pojo.Result;
import com.hjj.utils.XmlParserUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class empController {
    @RequestMapping("/listEmp")
    public Result listEmp() {
        //加载解析emp.xml文件
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        List<Emp> Emplist = XmlParserUtils.parse(file, Emp.class);
        //处理相关数据
        Emplist.stream().forEach(Emp -> {
            String gender = Emp.getGender();
            if (gender.equals("1")) {
                Emp.setGender("男");
            } else if (gender.equals("2")) {
                Emp.setGender("女");
            }

            String job = Emp.getJob();
            if (job.equals("1")) {
                Emp.setGender("讲师");
            } else if (job.equals("2")) {
                Emp.setGender("班主任");
            } else if (job.equals("3")) {
                Emp.setGender("就业指导");
            }
        });

        //返回结果
        return Result.success(Emplist);
    }
}
