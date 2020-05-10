package com.mmall.concurrency.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by cwl on 2018/8/15.
 */
@Slf4j
public class CyclicBarrierExample1 {
    //5个线程相互等待,到五个时候在执行
    private static CyclicBarrier barrier = new CyclicBarrier(5);

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
        barrier.await();//等待达到五个线程,在执行
        log.info("{} continue",num);


    }
}


