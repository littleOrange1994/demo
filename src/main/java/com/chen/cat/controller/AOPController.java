package com.chen.cat.controller;

import com.chen.cat.aop.CatAnnotation;
import com.dianping.cat.Cat;
import com.dianping.cat.message.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;

/**
 * @author fancheng.zeng
 * @title
 * @email Fancheng.Zeng@geely.com
 * @create 2019/9/12
 * @desc AOP测试
 */
@Controller
public class AOPController {
    @Autowired
    private Service2 service2;

    @RequestMapping("/aop")
    @ResponseBody
    @CatAnnotation
    public String service1()throws Exception {
            TimeUnit.MILLISECONDS.sleep(700L);
        service2.service2();
        return "Hi";
    }

}
