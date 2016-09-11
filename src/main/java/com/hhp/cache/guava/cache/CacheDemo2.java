package com.hhp.cache.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.security.Key;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * guava cache Demo2(get + callable)
 * Created by huanghaopeng on 16/9/11.
 */
public class CacheDemo2 {
    public static void main(String[] args) {
        LoadingCache<String, String> caches = CacheBuilder.newBuilder()
                .maximumSize(1000)
                .recordStats()
                .build(
                        new CacheLoader<String, String>() {
                            public String load(String key) {
                                return new String(key + "补");
                            }
                        });

        caches.put("huang","test");
        caches.put("xu", "test1");

        try {
            String str = caches.get("xu1", new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "xu1" + "没有";
                }
            });
            System.out.print(str);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
