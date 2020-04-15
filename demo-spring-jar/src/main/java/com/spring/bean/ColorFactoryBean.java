package com.spring.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author zhouj
 * @date 2020/3/19 21:47
 */
public class ColorFactoryBean implements FactoryBean<Color> {
    //返回一个color对象，对象会添加到容器中
    public Color getObject() throws Exception {
        System.out.println("ColorFactoryBean create color");
        return new Color();
    }

    //返回color类型信息
    public Class<?> getObjectType() {
        return Color.class;
    }

    //是否是单例 true，bean为单实例，在容器中保存一份
    //false，为多实例，每次获取会调用getObject方法返回新对象
    public boolean isSingleton() {
        return false;
    }
}
