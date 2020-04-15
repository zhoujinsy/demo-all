package com.spring.importer;

import com.spring.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author zhouj
 * @date 2020/3/19 21:05
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     * @param importingClassMetadata annotation metadata of the importing class 当前类注解信息
     * @param registry               current bean definition registry 当前bean注册定义信息，可用于手动注册bean
     */
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean red = registry.containsBeanDefinition("com.spring.bean.Red");
        boolean blue = registry.containsBeanDefinition("com.spring.bean.Blue");
        if (red && blue) {
            //指定bean定义信息
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBow.class);
            //注册bean，指定对应bean名称
            registry.registerBeanDefinition("rainBow", rootBeanDefinition);
        }
    }
}
