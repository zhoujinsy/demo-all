package com.spring.config;

import com.spring.bean.Person;
import com.spring.filter.MyTypeFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @author zhouj
 * @date 2020/3/16 22:05
 */
//配置类=配置文件
@Configuration //告知spring为配置类
@ComponentScan(value = "com.spring",
        includeFilters = {
                @Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
                //@Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),
                //@Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BookService.class})
        },
        useDefaultFilters = false)
//@ComponentScan value指定要扫描的包
//includeFilters生效需要指定useDefaultFilters = false，useDefaultFilters = false直接可以生效
//java8 @ComponentScan 有@Repeatable元注解，可以重复注释
// 也可以使用@ComponentScans
// FilterType.ANNOTATION指对注解上有classes指定类型的bean进行过滤
// ASSIGNABLE_TYPE指对指定的类型的bean进行过滤
// ASPECTJ 表达式
//REGEX 正则表达式
//CUSTOM 自定义过滤类型，通过编码进行过滤
//filter有顺序，前面fiter包含的类，后面filter
public class MainConfig {
    @Bean("person")  //给容器中注册一个bean ，类型为返回值类型，id默认为方法名
    public Person person01() {
        return new Person("lisi", 20);
    }
}
