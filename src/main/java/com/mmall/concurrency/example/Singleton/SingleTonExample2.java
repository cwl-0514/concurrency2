package com.mmall.concurrency.example.Singleton;

/**
 * Created by cwl on 2018/8/13.
 * 饿汉模式
 * 类装载使用的时候创建
 * 线程安全
 */
public class SingleTonExample2 {

    private static SingleTonExample2 instance = new SingleTonExample2();

    private SingleTonExample2(){}

    public static SingleTonExample2 getInstance(){
        return instance;
    }
}
