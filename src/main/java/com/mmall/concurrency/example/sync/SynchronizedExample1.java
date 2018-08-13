package com.mmall.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by cwl on 2018/8/12.
 */
@Slf4j
public class SynchronizedExample1 {

    public void test(){
        log.info("this 是什么 {}", this);
        //修饰静态代码块
        synchronized (this){
            for (int i=0;i<10;i++){
                log.info("test1 - {}", i);
            }
        }
    }
    //修饰方法
    public synchronized void test2(){
        for (int i=0;i<10;i++){
            log.info("test2 - {}", i);
        }

    }

    public static void main(String[] args){
        SynchronizedExample1 synchronizedExample1 = new SynchronizedExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(() -> {
            synchronizedExample1.test();
        });
        executorService.execute(() -> {
            synchronizedExample1.test();
        });
    }
}
