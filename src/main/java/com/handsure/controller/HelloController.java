package com.handsure.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.handsure.handler.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Arvin.Cao
 * @version 1.0
 * @time 17/1/3 下午4:26
 * @Description TODO
 */
@RestController
public class HelloController {
    @RequestMapping("/test1")
    public Object test1() {
        return com.handsure.handler.Response.success();
    }

    @RequestMapping("/test2")
    public Object test2() {
        Map<String, Object> data = new HashMap<>();
        data.put("username", "caojiawei");
        return Response.success(data, "请求成功");
    }

    @RequestMapping("/test3")
    public Object test3() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("handsure" + i);
        }
        Map<String, Object> data = new HashMap<>();
        data.put("username", "caojiawei");
        data.put("list", list);
        return Response.success(data, "请求成功");
    }



}
