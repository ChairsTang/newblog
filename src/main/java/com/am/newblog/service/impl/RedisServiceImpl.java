package com.am.newblog.service.impl;

import com.am.newblog.service.RedisService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author AMan
 * @Date 2018/2/7 21:07
 */
@Service
public class RedisServiceImpl implements RedisService {


    @Resource(name = "redisTemplate")
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public void add(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public void setExpire(String key, String value, Long timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(key,value,timeout,unit);
    }
}
