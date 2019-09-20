package com.chen.cat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

/**
 * Created by chen on 2018/11/13 15:36.
 */
@RestController
public class HelloController {

    @RequestMapping("go2")
    @ResponseBody
    private String hello() {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        String info = jedis.get("school_info_ligong");
        RestTemplate restTemplate = new RestTemplate();
        return "Hello";
    }
}
