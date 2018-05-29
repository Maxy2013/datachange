package com.data.datachange.module.system.web;

import com.data.datachange.module.system.model.Func;
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

    /**
     * 操作数据源为sys
     */
    @RequestMapping("/insertFunc")
    public void insertFunc(){
        funcService.insertFunc();
    }

    /**
     * 查询 Func
     * @param id 参数
     * @return Func
     */
    @RequestMapping("/queryFuncById")
    public Func queryFuncById(Integer id){
        return funcService.queryFuncById(id);
    }

    /**
     * 删除 Func
     * @param id 参数
     * @return Func
     */
    @RequestMapping("/deleteFuncById")
    public void deleteFuncById(Integer id){
        funcService.deleteFuncById(id);
    }
}
