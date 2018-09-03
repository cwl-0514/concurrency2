package com.mmall.concurrency.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by cwl on 2018/8/15.
 */
@Slf4j
public class CyclicBarrierExample2 {
    private static CyclicBarrier barrier = new CyclicBarrier(5, ()-> {
        log.info("达到屏障先执行这里");
    });

    public static void main(String[] args) throws Exception{
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i=0;i<10;i++){
            int threadNum = i;
            Thread.sleep(1000);
            exec.execute(() ->{
                try {
                    race(threadNum);
                } catch (Exception e) {
                    e.printStackTrace();
                    log.info("exception {}",e);
                }
            });
        }

    }

    public static void race(int num) throws Exception{
        Thread.sleep(1000);
        log.info(" {}is ready",num);
        barrier.await();
        log.info("{} continue",num);


    }
}


