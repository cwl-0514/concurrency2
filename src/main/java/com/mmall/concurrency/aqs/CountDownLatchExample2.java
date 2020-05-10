package com.mmall.concurrency.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by cwl on 2018/8/15.
 *
 * CountDownLatch 在规定制定的时间执行,时间到
 * 不论线程是否执行完,都结束执行(不管剩余的线程是否执行完)
 */
@Slf4j
public class CountDownLatchExample2 {

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
        //第一个参数代表等待的时间,第二个参数:时间的单位,超过10毫秒就执行
        countDownLatch.await(10, TimeUnit.MICROSECONDS);
        log.info("finish");
    }

    public static void test(int threadNum) throws Exception{
        Thread.sleep(100);
        log.info("threadNum === {}",threadNum);

    }
}
