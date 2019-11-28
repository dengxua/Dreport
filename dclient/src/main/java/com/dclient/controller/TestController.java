package com.dclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin
@RestController
public class TestController {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/test")
    private String test(String param) {

        System.out.println(param);
        return "测试成功";
    }

    @RequestMapping("/sqlSelect")
    private String sqlSelect(String param) {
        System.out.println("<开始处理+++++++++++++++++++++");
        return restTemplate.getForEntity("http://CONSUME-SQL/test?param="+param, String.class).getBody();

    }

    @RequestMapping("/save")
    private String save(String param) {
        System.out.println("<开始处理+++++++++++++++++++++");
        return restTemplate.getForObject("http://CONSUME-SQL/save?param={param}", String.class,param);
     }
}
