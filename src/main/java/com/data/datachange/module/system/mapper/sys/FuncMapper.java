package com.data.datachange.module.system.mapper.sys;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author lz
 * 2018/5/28 13:08
 */
@Mapper
@Component
public interface FuncMapper {
    void insertFunc();
}
