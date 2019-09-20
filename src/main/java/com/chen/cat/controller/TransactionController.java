package com.chen.cat.controller;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;

/**
 * @author fancheng.zeng
 * @title
 * @email Fancheng.Zeng@geely.com
 * @create 2019/9/11
 * @desc Transaction示例
 */
@Controller
public class TransactionController {

    @RequestMapping("/transaction")
    @ResponseBody
    public String service1()throws Exception {
        Transaction transaction = Cat.newTransaction("transaction", "service");
        try{
            TimeUnit.MILLISECONDS.sleep(700L);
            service2();
            transaction.setStatus(Transaction.SUCCESS);
        }finally {
            transaction.complete();
        }
        return "Hi";
    }

    public void service2()throws Exception {
        Transaction transaction = Cat.newTransaction("go", "service2");
        //业务逻辑
        TimeUnit.MILLISECONDS.sleep(System.currentTimeMillis()%100);
        try {
            if(1==1){
                throw  new RuntimeException("我错啦2222！");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        service3();
        transaction.setStatus(Transaction.SUCCESS);
        transaction.complete();
        System.out.println("service2");
    }

    public void service3() throws  Exception{
        Transaction transaction = Cat.newTransaction("go", "service3");
        TimeUnit.MILLISECONDS.sleep(System.currentTimeMillis()%100);
        //业务逻辑
        TimeUnit.MILLISECONDS.sleep(System.currentTimeMillis()%100);
        if(1==1){
            throw  new RuntimeException("我错啦3333！");
        }
        transaction.setStatus(Transaction.SUCCESS);
        transaction.complete();
        System.out.println("service3");
    }
}
