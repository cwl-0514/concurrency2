package com.mmall.concurrency.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by cwl on 2018/8/18.
 */
@Slf4j
public class FutrureExample1 {

    static class MyCallable implements Callable<String>{

        @Override
        public String call() throws Exception {
            log.info("Callable do something");
            Thread.sleep(1000);
            return "done";
        }
    }

    public static void main(String[] args) throws Exception{
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<String> submit = executor.submit(new MyCallable());
        log.info("do somthing is main");
        Thread.sleep(1000);
        String result = submit.get();
        log.info("the result is {}",result);
    }
}
