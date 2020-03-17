package com.spring.test;

import com.spring.config.MainConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhouj
 * @date 2020/3/16 22:25
 */
public class IocTest {
    @SuppressWarnings("resource")
    @Test
    public void test01() {
        AnnotationConfigApplicationContext annoContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanNames = annoContext.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }
}
