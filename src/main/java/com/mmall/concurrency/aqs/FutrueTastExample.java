package com.mmall.concurrency.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by cwl on 2018/8/18.
 */
@Slf4j
public class FutrueTastExample {
    public static void main(String[] args) throws Exception{
        FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("Callable do something");
                Thread.sleep(1000);
                return "done";
            }

        });
        new Thread(futureTask).start();
        log.info("do somthing is main");
        Thread.sleep(1000);
        String result = futureTask.get();
        log.info("the result is {}",result);
    }
}
