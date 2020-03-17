package com.spring.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 匹配windows系统的condition
 *
 * @author zhouj
 * @date 2020/3/17 21:26
 */
public class WindowsCondition implements Condition {
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //todo 判断是否是linxu系统
        //1、获取ioc的beanfactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //2、获取类加载器
        ClassLoader classLoader = context.getClassLoader();
        //3、获取环境信息
        Environment environment = context.getEnvironment();
        //4、获取bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();
        //判断容器bean定义信息中是否有id person
        boolean person = registry.containsBeanDefinition("person");
        if (person) {
            return true;
        }
        //判断操作系统名称（可以在VM参数中设置）
        String property = environment.getProperty("os.name");
        if (property.contains("Windows")) {
            return true;
        }
        return false;
    }
}
