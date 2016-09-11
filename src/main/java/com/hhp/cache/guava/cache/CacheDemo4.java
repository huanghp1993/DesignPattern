package com.hhp.cache.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * guava cache Demo4(定时回收)
 * Created by huanghaopeng on 16/9/11.
 */
public class CacheDemo4 {
    public static void main(String[] args) {
        LoadingCache<String,String> caches = CacheBuilder.newBuilder()
                //.expireAfterAccess(2000,TimeUnit.MILLISECONDS)
                .expireAfterWrite(2000,TimeUnit.MILLISECONDS)
                .recordStats()
                .build(
                        new CacheLoader<String, String>() {
                            public String load(String key) { // no checked exception
                                return new String(key + "补充");
                            }
                        }
                );


        caches.put("huang","huang");
        caches.put("huang1", "peng");

        for (int i = 0 ; i < 10 ;i++){
            try {
                System.out.println(i + " " + caches.get("huang"));
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println("命中次数:" + caches.stats().hitCount());

    }
}
