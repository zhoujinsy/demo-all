package com.spring.config;

import com.spring.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhouj
 * @date 2020/3/16 22:05
 */
//配置类=配置文件
@Configuration //告知spring为配置类
@ComponentScan(value="com.spring",excludeFilters = {@ComponentScan.Filter})
//@ComponentScan value指定要扫描的包
public class MainConfig {
    @Bean("person")  //给容器中注册一个bean ，类型为返回值类型，id默认为方法名
    public Person person01() {
        return new Person("lisi", 20);
    }
}
