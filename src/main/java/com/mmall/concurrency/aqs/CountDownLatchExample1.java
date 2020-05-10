package com.mmall.concurrency.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by cwl on 2018/8/15.
 * CountDownLatch 等待所有线程(200)完成在执行
 */
@Slf4j
public class CountDownLatchExample1 {
    private final static int threadCount= 200;

    public static void main(String[] args) throws Exception{
        ExecutorService exec = Executors.newCachedThreadPool();

       final CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for(int i=0; i<threadCount; i++){
            final int threadNum = i;
            exec.execute(() ->{
                try {
                    test(threadNum);
                } catch (Exception e) {
                    log.error("exception 为 {}",e);
                }finally {
                    countDownLatch.countDown();//每次都是减1
                }
            });
        }
        countDownLatch.await();//保证上面的200线程都是执行完的
        log.info("finish");
    }

    public static void test(int threadNum) throws Exception{
        Thread.sleep(100);
        log.info("threadNum === {}",threadNum);
        Thread.sleep(100);
    }
}
