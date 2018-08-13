package com.mmall.concurrency.example.atomic;

import com.mmall.concurrency.annoations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by cwl on 2018/8/12.
 */
@Slf4j
@ThreadSafe
public class CountExample5 {

  private static AtomicIntegerFieldUpdater<CountExample5> updater =
          AtomicIntegerFieldUpdater.newUpdater(CountExample5.class, "count");

  @Getter
  private  volatile int count = 100;//必须有volatile修饰
  private static CountExample5 countExample5 = new CountExample5();

  public static  void main(String[] args){
    if(updater.compareAndSet(countExample5, 100, 120)){
      log.info("update success 1 {}", countExample5.getCount());
    }
    if(updater.compareAndSet(countExample5, 100, 120)){
      log.info("update success 2 {}", countExample5.getCount());
    }else {
      log.error("update fail {}", countExample5.getCount());
    }
  }
}
