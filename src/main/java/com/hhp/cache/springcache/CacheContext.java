package com.hhp.cache.springcache;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 缓存管理器
 * Created by huanghaopeng on 16/8/27.
 */
public class CacheContext<T> {

    private Map<String, T> cache = Maps.newConcurrentMap();

    public T get(String key){
        return  cache.get(key);
    }

    public void addOrUpdateCache(String key,T value) {
        cache.put(key, value);
    }

    // 根据 key 来删除缓存中的一条记录
    public void evictCache(String key) {
        if(cache.containsKey(key)) {
            cache.remove(key);
        }
    }

    // 清空缓存中的所有记录
    public void evictCache() {
        cache.clear();
    }

}
