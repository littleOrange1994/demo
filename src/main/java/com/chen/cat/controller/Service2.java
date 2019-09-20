package com.chen.cat.controller;

import com.chen.cat.aop.CatAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author fancheng.zeng
 * @title
 * @email Fancheng.Zeng@geely.com
 * @create 2019/9/12
 * @desc
 */
@Service
public class Service2 {
    @Autowired
    private  Service3 service3;

    @CatAnnotation
    public void service2()throws Exception {
        //业务逻辑
        TimeUnit.MILLISECONDS.sleep(System.currentTimeMillis()%100);
        service3.service3();
        System.out.println("service2");
    }
}
