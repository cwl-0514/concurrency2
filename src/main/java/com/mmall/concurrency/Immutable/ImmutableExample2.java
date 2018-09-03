package com.mmall.concurrency.Immutable;

import com.google.common.collect.Maps;

import java.util.Collections;
import java.util.Map;

/**
 * Created by cwl on 2018/8/13.
 */
public class ImmutableExample2 {
    private static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1,3);
        map.put(2,3);
        map.put(3,4);
        map = Collections.unmodifiableMap(map);//这个类修饰map以后,map值就不可以在改变了
    }

    public static void main(String[] args){

    }
}
