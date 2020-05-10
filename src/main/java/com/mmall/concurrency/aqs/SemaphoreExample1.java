package com.mmall.concurrency.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by cwl on 2018/8/15.
 * 某个资源同时被访问的个数,使用场景:提供有限的资源,例如:数据库的连接个数
 */
@Slf4j
public class SemaphoreExample1 {
    private final static int threadCount= 20;

    public static void main(String[] args) throws Exception{
        ExecutorService exec = Executors.newCachedThreadPool();
        //同时最多允许3个线程访问
        final Semaphore semaphore = new Semaphore(3);
        for(int i=0; i<threadCount; i++){
            final int threadNum = i;
            exec.execute(() ->{
                try {
                    //获取 一个 许可
                    semaphore.acquire();
                    //获取多个许可
                    //semaphore.acquire(3);
                    semaphore.tryAcquire();//尝试获取许可
                    test(threadNum);//最多有三个线程同时执行test()方法
                    //释放许可
                    semaphore.release();
                    //释放多个许可
                    //semaphore.release(3);
                } catch (Exception e) {
                    log.error("exception 为 {}",e);
                }
            });
        }

        log.info("finish");
    }

    public static void test(int threadNum) throws Exception{

        log.info("threadNum === {}",threadNum);
        Thread.sleep(100);
    }
}
