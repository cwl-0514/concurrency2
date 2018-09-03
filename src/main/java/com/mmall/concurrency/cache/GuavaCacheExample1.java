package com.mmall.concurrency.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;


import java.util.concurrent.TimeUnit;

/**
 * Created by cwl on 2018/8/19.
 */
@Slf4j
public class GuavaCacheExample1 {

    public static void main(String[] args){

        LoadingCache<String, Integer> cache = CacheBuilder.newBuilder()
                .maximumSize(10)//最多存放10个数据
                .expireAfterWrite(10, TimeUnit.SECONDS)//缓存10秒
                .recordStats()//开启记录状态数据功能
                .build(new CacheLoader<String, Integer>() {
                    @Override
                    public Integer load(String key) throws Exception {
                        return -1;
                    }
                });


    }
}
