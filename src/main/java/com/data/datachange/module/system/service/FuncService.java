package com.data.datachange.module.system.service;

import com.data.datachange.module.system.mapper.sys.FuncMapper;
import com.data.datachange.module.system.model.Func;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author lz
 * 2018/5/28 13:07
 */
@Slf4j
@Service
public class FuncService {

    @Autowired
    private FuncMapper funcMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    public void insertFunc(){
        funcMapper.insertFunc();
    }

    public Func queryFuncById(Integer id){
        //缓存 ID
        String funcId = "func" + id;

        ValueOperations<String, Func> operations = redisTemplate.opsForValue();

        //判断缓存中是否存在相应的信息
        boolean hasKey = redisTemplate.hasKey(funcId);
        if (hasKey){
            log.info("hasKey -->{}", hasKey);
            Func func = operations.get(funcId);
            log.info("func info -->{}", func);
            return func;
        }

        //查询数据库
        Func func = funcMapper.queryFuncById(id);

        //插入缓存
        operations.set(funcId, func, 36000, TimeUnit.SECONDS);

        return func;
    }

    public void deleteFuncById(Integer id){

        funcMapper.deleteFuncById(id);
        //缓存 ID
        String funcId = "func" + id;

        //判断缓存中是否存在相应的信息
        boolean hasKey = redisTemplate.hasKey(funcId);
        if (hasKey){
            log.info("hasKey -->{}", hasKey);
            boolean delete = redisTemplate.delete(funcId);
            log.info("delete func info -->{}", delete);
        }
    }
}
