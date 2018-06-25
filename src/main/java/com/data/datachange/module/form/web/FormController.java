package com.data.datachange.module.form.web;

import com.data.datachange.module.form.model.User;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author lz
 * 2018/6/22 17:36
 */
@RestController
@RequestMapping("/form")
public class FormController {

    @RequestMapping("/submitAjaxUserInfo")
    public User submitAjaxUserInfo(HttpServletRequest request){

        return this.getUser(request);
    }

    @RequestMapping("/submitFormUserInfo")
    public User submitFormUserInfo(HttpServletRequest request){

        return this.getUser(request);
    }

    private User getUser(HttpServletRequest request){
        User user = new User();
        user.setName(request.getParameter("name"));
        user.setAddr(request.getParameter("addr"));
        user.setPass(request.getParameter("pass"));
        return user;
    }
}
