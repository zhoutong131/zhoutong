package com.mypro.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypro.model.VO.Login;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.mypro.util.JWT;

public class TokenInterceptor implements HandlerInterceptor{

    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception arg3)
            throws Exception {
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView model) throws Exception {
    }

    //拦截每个请求
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        response.setCharacterEncoding("utf-8");
        String token = request.getHeader("token");
        //token不存在
        if(null != token) {
            Login login = JWT.unsign(token, Login.class);
            String loginId = request.getHeader("account");
            //解密token后的loginId与用户传来的loginId不一致，一般都是token过期
            if(null != loginId && null != login) {
                if(loginId.equals(login.getAccount())) {
                    return true;
                }
                else{
                    responseMessage(response, response.getWriter(), ResultJson.toJson(Code.OVERDUE,Code.AUth_EXP_MSG,Code.NULL_STR));
                    return false;
                }
            }
            else
            {
                responseMessage(response, response.getWriter(), ResultJson.toJson(Code.OVERDUE,Code.AUth_EXP_MSG,Code.NULL_STR));
                return false;
            }
        }
        else
        {
            responseMessage(response, response.getWriter(), ResultJson.toJson(Code.OVERDUE,Code.AUth_EXP_MSG,Code.NULL_STR));
            return false;
        }
    }

    //请求不通过，返回错误信息给客户端
    private void responseMessage(HttpServletResponse response, PrintWriter out, String json) {
        response.setContentType("application/json; charset=utf-8");
        out.print(json);
        out.flush();
        out.close();
    }

}