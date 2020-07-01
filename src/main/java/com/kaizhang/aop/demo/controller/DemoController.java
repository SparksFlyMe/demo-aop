package com.kaizhang.aop.demo.controller;

import com.kaizhang.aop.demo.annotation.DoneTimeAnnotation;
import com.kaizhang.aop.demo.model.Product;
import com.kaizhang.aop.demo.model.User;
import oracle.jrockit.jfr.openmbean.ProducerDescriptorType;
import org.springframework.http.HttpRequest;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author kaizhang
 * @date 2020年7月1日22:05:08
 */

@RestController
@RequestMapping("/demo")
public class DemoController {
    @PostMapping("/get")
    @DoneTimeAnnotation
    public String get() {
        System.out.println("123");
        return "13";
    }

    @PostMapping("/post")
    public @ResponseBody
    User
    post(@RequestBody User user) {
        System.out.println(user);
        return user;
    }

    @PostMapping("/post1")
    @DoneTimeAnnotation
    public @ResponseBody
    Product
    post1(@RequestBody Product product, HttpServletRequest request) {
        System.out.println(product);
        request.getSession().setAttribute("session", "2333");
        return product;
    }
}
