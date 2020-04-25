package com.curr.volat;

import java.lang.reflect.Proxy;

/**
 * @author zhouj
 * @date 2020/4/21 12:03
 */
public class InvokerTest {

    public static void main(String[] args) {
        MyImpl my = new MyImpl();
        Face1 face1 = (Face1) Proxy.newProxyInstance(my.getClass().getClassLoader(), new Class[]{Face1.class}, new MyHandler(my));
        face1.test1("aa");
    }
}
