package com.data.datachange.module.system.service;

import com.data.datachange.module.system.mapper.custom.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lz
 * 2018/5/29 14:40
 */
@Service
public class EmpService {

    @Autowired
    private EmpMapper empMapper;

    public void insertEmp(){
        empMapper.insertEmp();
    }
}
