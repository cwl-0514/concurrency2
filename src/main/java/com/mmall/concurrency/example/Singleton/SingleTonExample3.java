package com.mmall.concurrency.example.Singleton;

/**
 * Created by cwl on 2018/8/13.
 * 懒汉模式
 * 第一次使用实体类的时候创建
 * 线程安全
 */
public class SingleTonExample3 {

    private  volatile  static SingleTonExample3 instance = null;

    private SingleTonExample3(){}

    public static SingleTonExample3 getInstance(){
        if(instance == null){
            //双重检测机制
            synchronized (SingleTonExample3.class){//同步锁
                if(instance == null){
                    instance = new SingleTonExample3();
                }
            }
        }
        return instance;
    }
}
