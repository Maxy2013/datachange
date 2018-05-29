package com.data.datachange.module.system.service;

import com.data.datachange.module.system.mapper.sys.FuncMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lz
 * 2018/5/28 13:07
 */
@Service
public class FuncService {

    @Autowired
    private FuncMapper funcMapper;

    public void insertFunc(){
        funcMapper.insertFunc();
    }
}
