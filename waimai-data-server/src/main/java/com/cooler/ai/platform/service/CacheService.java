package com.cooler.ai.platform.service;

import java.util.List;
import java.util.Set;

/**
 * Created by zhangsheng on 2018/6/13.
 */
public interface CacheService<T> {
    /**
     * 缓存基本的对象，Integer、String、实体类等
     * @param key   缓存的键值
     * @param value 缓存的值
     * @return 缓存的对象
     */
    void setContext(String key, T value);

    /**
     * 获得缓存的基本对象。
     * @param key       缓存键值
     * @return 缓存键值对应的数据
     */
    T getContext(String key);

    /**
     * 根据key集合，一次获取多个结果
     * @param keys  key集合
     * @return  多个结果
     */
    List<T> getContextList(Set<String> keys);

    /**
     * 删除一个缓存记录
     * @param key
     */
    void removeContext(String key);

    /**
     * 删除多个缓存记录
     * @param keys
     */
    void removeContextList(Set<String> keys);
}
