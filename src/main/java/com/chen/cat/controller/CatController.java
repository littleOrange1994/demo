package com.chen.cat.controller;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Event;
import com.dianping.cat.message.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author fancheng.zeng
 * @title
 * @email Fancheng.Zeng@geely.com
 * @create 2019/9/4
 * @desc
 */
@Controller
public class CatController {

    @ResponseBody
    public String hello() {

        String pageName = "pageName";
        String serverIp = "serverIp";
        Transaction t = Cat.newTransaction("zfc11111", pageName);
        Transaction t3 = Cat.newTransaction("zfc22222", "name");
       if(1==1){
           throw  new RuntimeException("自己的错误1");
       }

        for (int i = 0; i < 2080; i++) {
            if(i==100){
                int s=2/0;
            }
            Transaction t4 = Cat.newTransaction("zfc33333", "name");

            t4.complete();
        }
        t3.complete();
        t.complete();


        try {
            Cat.logEvent("URL.Server", serverIp, Event.SUCCESS, "ip=" + serverIp + "&...");
            Cat.logMetricForCount("PayCount");

            t.setStatus(Transaction.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            t.setStatus(e);
        } finally {
            System.out.println("-----调用发送消息");
            t.complete();
        }
        return "hello";
    }

}
