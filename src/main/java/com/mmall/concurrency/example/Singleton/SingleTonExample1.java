package com.mmall.concurrency.example.Singleton;

/**
 * Created by cwl on 2018/8/13.
 * 懒汉模式
 * 第一次使用实体类的时候创建
 * 线程不安全
 */
public class SingleTonExample1 {

    private static SingleTonExample1 instance = null;

    private SingleTonExample1(){}

    public static SingleTonExample1 getInstance(){
        if(instance == null){
            instance = new SingleTonExample1();
        }
        return instance;
    }
}
