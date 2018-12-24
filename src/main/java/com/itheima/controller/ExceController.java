package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceController {

    /*
     * springMVC处理异常信息:
     *   自定义一个类实现HandlerExceptionResolver接口,当控制器出现异常的时候
     *   会自动跳转到异常信息的类,就是我们定义的类,可以在该类就绪统一的处理异常信息
     * */

    @RequestMapping("/exc")
    public String exc(){
        System.out.println("2--interceptor");
        //int a = 1 / 0;  //模拟异常信息
        return "success";
    }
}