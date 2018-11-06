package com.y1ang.interceptor;

import com.ndktools.javamd5.Mademd5;
import com.y1ang.entity.User;
import com.y1ang.service.IUserService;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author y1ang
 * @Data 2018年09月28日-上午10:39:48
 * @Description 用户登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 注入用户登录方法接口类
     */
    @Resource
    private IUserService service;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {

        final String loginAction = "/sign";
        final String loginCheckAction = "/check";

        request.setCharacterEncoding("utf-8");
        String url = request.getRequestURL().toString();
        if (url.indexOf(loginAction) >= 0 || url.indexOf(loginCheckAction) >= 0) {
            return true;
        }

        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("UserSession");
        if (u != null) {
            return true;
        }

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("user".equals(c.getName())) {
                    User findUser = service.findUser(Integer.parseInt(c.getValue().split("-")[2]));
                    Mademd5 md5 = new Mademd5();
                    String cName = c.getValue().split("-")[0];
                    String cPassword = c.getValue().split("-")[1];
                    String md5Name = md5.toMd5("ACD244" + findUser.getUserName() + "14DS4DS");
                    String md5Password = md5.toMd5("ACD244" + findUser.getUserPwd() + "14DS4DS");
                    if (cName.equals(md5Name) && cPassword.equals(md5Password)) {
                        request.getSession().setAttribute("UserSession", findUser);
                        request.getRequestDispatcher("/index.html").forward(request, response);
                        return true;
                    }
                }
            }
        }
        request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
        return false;
    }
}
