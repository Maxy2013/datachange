package com.data.datachange.module.web;

import com.data.datachange.module.service.FuncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lz
 * 2018/5/28 13:05
 */
@RestController
@RequestMapping("/func")
public class FuncController {

    @Autowired
    private FuncService funcService;

    @RequestMapping("/insertFunc")
    public void insertFunc(){
        funcService.insertFunc();
    }
}
