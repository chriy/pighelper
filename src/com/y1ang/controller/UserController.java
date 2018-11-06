package com.y1ang.controller;

import com.ndktools.javamd5.Mademd5;
import com.y1ang.entity.User;
import com.y1ang.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author y1ang
 * @Data 2018年8月25日-下午11:55:30
 * @Description 用户登录控制类
 */
@Controller
public class UserController {

    @Autowired
    private IUserService service;

    @RequestMapping("/sign")
    public String toSignPage() {
        return "login.jsp";
    }

    /**
     * 登陆验证
     *
     * @param username
     * @param pwd
     * @return
     */
    @RequestMapping("/check")
    @ResponseBody
    public String check(String username, String pwd) {
        User user = new User(username, pwd);
        User u = service.login(user);
        if (u != null) {
            return "OK";
        }
        return "FAIL";
    }

    /**
     * 登录
     *
     * @param username
     * @param pwd
     * @param request
     * @return
     */
    @RequestMapping("/signin")
    public String login(String username, String pwd, String auto_login, HttpServletRequest request,
                        HttpServletResponse response) {
        User user = new User(username, pwd);
        User u = service.login(user);
        if (u != null) {
            request.getSession().setAttribute("UserSession", u);
            Cookie cookie = null;
            if (auto_login != null) {
                // 7天内自动登录
                int seconds = 7 * 24 * 60 * 60;
                // 保存在Cookie中
                Mademd5 md = new Mademd5();
                // MD5加密加盐
                cookie = new Cookie("user",
                    md.toMd5("ACD244" + username + "14DS4DS") + "-" + md.toMd5("ACD244" + pwd + "14DS4DS")+"-"+u.getUserId());
                cookie.setMaxAge(seconds);
                cookie.setPath("/");
                response.addCookie(cookie);
            } else {
                cookie = new Cookie("user", "");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
            return "redirect:index.html";
        }
        return "login.jsp";
    }
}
