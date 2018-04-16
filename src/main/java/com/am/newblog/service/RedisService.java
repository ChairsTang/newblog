package com.am.newblog.service;

import java.util.concurrent.TimeUnit;

/**
 * @author AMan
 * @Date 2018/2/7 20:57
 * 缓存接口
 */
public interface RedisService {

    /**
     * 添加值
     * @param key 键
     * @param value 值
     */
    void add(String key,String value);

    /**
     * 获取值
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 设置过期时间
     * @param key 键
     * @param value 值
     * @param timeout 过期时间
     * @param unit 时间类别
     */
    void setExpire(String key, String value, Long timeout, TimeUnit unit);
}
