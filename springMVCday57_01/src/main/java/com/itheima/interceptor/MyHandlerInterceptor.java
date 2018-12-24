package com.itheima.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class MyHandlerInterceptor  implements HandlerInterceptor{

    /*
    * 正常执行流程是:preHandle controller方法 postHandle  afterCompletion
    *
    * 如果preHandle返回false,则后面的方法都不会执行
    *
    * 如果preHandle返回true,控制器方法出现了异常,则执行流程是:preHandle controller方法 afterCompletion
    *
    * preHandle只有在该方法返回true时,afterCompletion方法才会执行
    * */

    /*
            当有个多个拦截器时,控制器方法出现异常时,执行流程如下
    *       1--interceptor1
            1--interceptor2
            2--interceptor(控制器方法)
            4--interceptor2
            4--interceptor1
    *
    *       当有多个拦截器,控制器方法正常,执行流程如下
    *       1--interceptor1
            1--interceptor2
            2--interceptor(控制器方法)
            3--interceptor2
            3--interceptor1
            4--interceptor2
            4--interceptor1
    *
    *       当有多个拦截器,控制器方法正常,第二个拦截器的preHandle方法返回false时,执行流程如下
    *       1--interceptor1
            1--interceptor2
            4--interceptor1
    * */

    //该方法会在执行控制器方法之前执行,如果该方法返回true,就会执行控制器方法,返回false后面的方法都不会执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("1--interceptor1");
        return true;
    }

    //该方法会在执行完控制器方法后执行,如果控制器方法出现异常则不会执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        System.out.println("3--interceptor1");
    }

    //该方法会在preHandle方法返回true的前提下才会执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println("4--interceptor1");
    }
}
