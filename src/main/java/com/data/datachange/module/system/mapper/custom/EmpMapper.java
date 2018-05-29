package com.data.datachange.module.system.mapper.custom;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author lz
 * 2018/5/29 14:42
 */
@Mapper
@Component
public interface EmpMapper {
    void insertEmp();
}
