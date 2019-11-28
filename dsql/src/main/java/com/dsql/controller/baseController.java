package com.dsql.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.dsql.entity.Code;
import com.dsql.entity.Message;
import com.dsql.entity.ReportEntity;
import com.dsql.service.commService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class baseController {
    @Autowired
    commService commService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private ValueOperations valueOperations;


    @RequestMapping("/test")
    Object test(String param) throws Exception {
        System.out.println("<开始查询+++++++++++++++++++++");
        return commService.select(param);
    }

    @RequestMapping("/save")
    Object save(String param) throws Exception {
        System.out.println(param);
        ReportEntity reportEntity = JSON.parseObject(param, new TypeReference<ReportEntity>() {
        });
        System.out.println(reportEntity);

//        valueOperations.set("nihao", "wwwww");
//        System.out.println(valueOperations.get("nihao"));

        System.out.println("<开始查询+++++++++++++++++++++");
        return  new Message(Code.SUCCESS);
    }
}
