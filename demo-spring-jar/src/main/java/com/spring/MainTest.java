package com.spring;

import com.spring.bean.Person;
import com.spring.config.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhouj
 * @date 2020/3/16 22:00
 */
public class MainTest {
    public static void main(String[] args) {
       /* ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-demo-spring-jar.xml");
        Person person = (Person) context.getBean("person");
        System.out.println(person);*/

        AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Object person = annotationContext.getBean(Person.class);
        System.out.println(person);

        String[] beanNamesForType = annotationContext.getBeanNamesForType(Person.class);
        for (String name:beanNamesForType){
            System.out.println(name);
        }

    }
}
