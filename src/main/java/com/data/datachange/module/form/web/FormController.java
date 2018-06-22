package com.data.datachange.module.form.web;

import com.data.datachange.module.form.model.User;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lz
 * 2018/6/22 17:36
 */
@RestController
@RequestMapping("/form")
public class FormController {

    @RequestMapping("/submitUserInfo")
    public User submitUserInfo(HttpServletRequest request){

        User user = new User();
        user.setName(request.getParameter("name"));
        user.setAddr(request.getParameter("addr"));
        user.setPass(request.getParameter("pass"));

        return user;
    }
}
