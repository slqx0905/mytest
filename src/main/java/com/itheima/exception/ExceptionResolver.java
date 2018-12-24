package com.itheima.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ExceptionResolver implements HandlerExceptionResolver{
    @Override
    public ModelAndView resolveException(
            HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
            Object o, Exception e) {
        //当控制器方法出现异常时,会自动来到这里
        System.out.println(o);  //public java.lang.String com.itheima.controller.ExceController.exc()
        //创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        //跳转页面
        mv.setViewName("success");
        //存储错误信息
        mv.addObject("error","心态很重要");
        return mv;
    }
}
