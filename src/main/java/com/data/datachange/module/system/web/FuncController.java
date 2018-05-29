package com.data.datachange.module.system.web;

import com.data.datachange.module.system.service.EmpService;
import com.data.datachange.module.system.service.FuncService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private EmpService empService;

    /**
     * 操作数据源为sys
     */
    @RequestMapping("/insertFunc")
    public void insertFunc(){
        funcService.insertFunc();
    }

    /**
     * 操作数据源为custom
     */
    @RequestMapping("/insertEmp")
    public void insertEmp(){
        empService.insertEmp();
    }
}
