package com.hhp.cache.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.Weigher;

/**
 * guava cache Demo3(权重回收)
 * Created by huanghaopeng on 16/9/11.
 */
public class CacheDemo3 {
    public static void main(String[] args) {
        LoadingCache<String, String> caches = CacheBuilder.newBuilder()
                .maximumWeight(10)
                .weigher(new Weigher<String, String>() {
                    @Override
                    public int weigh(String s, String s2) {
                        return s2.length();
                    }
                })
                .build(
                        new CacheLoader<String, String>() {
                            public String load(String key) { // no checked exception
                                return new String(key + "补充");
                            }
                        });

        caches.put("huang","huang");
        caches.put("huang1", "peng");

        String result = caches.getUnchecked("huang1");
        String result1 = caches.getUnchecked("huang");

        System.out.println(result);
        System.out.println(result1);



    }
}
