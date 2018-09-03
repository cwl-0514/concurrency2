package com.mmall.concurrency.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by cwl on 2018/8/15.
 */
@Slf4j
public class SemaphoreExample1 {
    private final static int threadCount= 200;

    public static void main(String[] args) throws Exception{
        ExecutorService exec = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(20);
        for(int i=0; i<threadCount; i++){
            final int threadNum = i;
            exec.execute(() ->{
                try {
                    //最多允许20个线程同时访问
                    semaphore.acquire();
                    semaphore.tryAcquire();
                    test(threadNum);
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception 为 {}",e);
                }
            });
        }

        log.info("finish");
    }

    public static void test(int threadNum) throws Exception{
        Thread.sleep(100);
        log.info("threadNum === {}",threadNum);
        Thread.sleep(100);
    }
}
