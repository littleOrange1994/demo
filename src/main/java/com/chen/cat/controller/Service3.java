package com.chen.cat.controller;

import com.chen.cat.aop.CatAnnotation;
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
public class Service3 {

    @CatAnnotation
    public void service3() throws  Exception{
        //业务逻辑
        TimeUnit.MILLISECONDS.sleep(System.currentTimeMillis()%100);
//        if(1==1){
//            throw  new RuntimeException("测试错误！！！！");
//        }
        System.out.println("service3");
    }
}
