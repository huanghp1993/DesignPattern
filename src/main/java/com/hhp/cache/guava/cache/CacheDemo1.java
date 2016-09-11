package com.hhp.cache.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;

/**
 * guava cache Demo1
 * Created by huanghaopeng on 16/9/11.
 */
public class CacheDemo1 {
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
            String result = caches.get("xu");
            System.out.println(result);
            String result1 = caches.get("xu1");
            System.out.println(result1);
            String result2 = caches.get("xu1");
            System.out.println(result2);

            String huangresult
                    = caches.getUnchecked("huang");
            System.out.println(huangresult);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        // 没有捕获异常的话,可以使用getUnchecked方法
        String huangresult
             = caches.getUnchecked("huang");
        System.out.println(huangresult);

        String huangresult1
                = caches.getUnchecked("huang1");
        System.out.println(huangresult1);

        System.out.println(caches.stats().hitCount());
    }
}
