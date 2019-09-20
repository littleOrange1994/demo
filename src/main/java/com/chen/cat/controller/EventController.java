package com.chen.cat.controller;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Event;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author fancheng.zeng
 * @title
 * @email Fancheng.Zeng@geely.com
 * @create 2019/9/11
 * @desc Event示例
 */
@Controller
public class EventController {
    @RequestMapping("/event")
    @ResponseBody
    public String service1()throws Exception {
        Event event= Cat.newEvent("event","service");
        if (System.currentTimeMillis() % 10 < 3) {
            Cat.logEvent("event","function1");
            function1();
            event.setStatus(Event.SUCCESS);
        }else{
            Cat.logEvent("event","function2");
            function2();
            event.setStatus("fasle");
        }
        event.complete();
        return "hi";
    }


    public void function1(){
        System.out.println("function1()。。。。");
    }

    public void function2(){
        System.out.println("function2()。。。。");
    }
}
