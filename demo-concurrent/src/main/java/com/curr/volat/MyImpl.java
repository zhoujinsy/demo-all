package com.curr.volat;

/**
 * @author zhouj
 * @date 2020/4/21 12:07
 */
public class MyImpl implements Face1, Face2 {
    @Override
    public String test1(String aa) {
        System.out.println("test1");
        return null;
    }

    @Override
    public String test2(String aa) {
        System.out.println("test2");
        return null;
    }
}
