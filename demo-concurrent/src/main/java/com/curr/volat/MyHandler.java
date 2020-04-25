package com.curr.volat;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zhouj
 * @date 2020/4/21 12:05
 */
public class MyHandler implements InvocationHandler {
    private Object o;

    public MyHandler(Object o) {
        this.o = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("hander pre");
        Object invoke = method.invoke(o, args);
        System.out.println("hander post");
        return null;
    }
}
