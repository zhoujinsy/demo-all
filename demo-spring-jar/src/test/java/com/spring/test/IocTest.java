package com.spring.test;

import com.spring.bean.Person;
import com.spring.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

/**
 * @author zhouj
 * @date 2020/3/16 22:25
 */
public class IocTest {
    AnnotationConfigApplicationContext annoContext = new AnnotationConfigApplicationContext(MainConfig2.class);

    @SuppressWarnings("resource")
    @Test
    public void test01() {

        printContextBeanNames(annoContext);
    }

    @Test
    public void test02() {

        printContextBeanNames(annoContext);
        Object person = annoContext.getBean("person");
        Object person2 = annoContext.getBean("person");
        System.out.println(person.equals(person2));
    }

    @Test
    public void test03() {
        AnnotationConfigApplicationContext annoContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] beanNames = annoContext.getBeanNamesForType(Person.class);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }

        Map<String, Person> persons = annoContext.getBeansOfType(Person.class);
        System.out.println(persons);

        //获取环境变量
        ConfigurableEnvironment environment = annoContext.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);
    }

    //测试@Import
    @Test
    public void test04() {
        printContextBeanNames(this.annoContext);
    }

    private void printContextBeanNames(AnnotationConfigApplicationContext annoContext) {
        String[] beanNames = annoContext.getBeanDefinitionNames();
        for (String name : beanNames) {
            System.out.println(name);
        }
    }
}
