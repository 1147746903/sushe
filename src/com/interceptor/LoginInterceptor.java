package com.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登陆拦截器
 */

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //获取请求的URL
        String url = request.getRequestURI();
        //URL:除了登陆请求外，其他的URL都进行拦截控制
        if (url.indexOf("/login.action")>=0){
            return true;
        }
        //获取Session
        HttpSession session = request.getSession();
        Object session1 = session.getAttribute("SESSION");
        //判断Session中是否有用户数据，如果有返回true,绩效向下执行
        if(session1 !=null){
            return true;
        }
        //不符合条件的给出提示信息，并转发到登陆页面
        request.setAttribute("msg","您还没有登陆，请先登陆！");
        request.getRequestDispatcher("/login.jsp").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
