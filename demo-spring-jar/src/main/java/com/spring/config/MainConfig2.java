package com.spring.config;

import com.spring.bean.Color;
import com.spring.bean.ColorFactoryBean;
import com.spring.bean.Person;
import com.spring.bean.Red;
import com.spring.condition.LinuxCondition;
import com.spring.condition.WindowsCondition;
import com.spring.importer.MyImportBeanDefinitionRegistrar;
import com.spring.importer.MyImportSelector;
import org.springframework.context.annotation.*;

/**
 * @author zhouj
 * @date 2020/3/17 20:12
 */
//满足当前条件，类中配置的所有bean信息才会生效
@Conditional({WindowsCondition.class})
@Configuration
@Import({Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class MainConfig2 {

    /**
     * 默认单例，容器创建加载
     * singleton 单例模式，IOC容器创建时就已经创建了该bean，以后每次容器获取对象都是该对象
     * prototype 多实例模式，每次从容器中获取对象时，才开始创建实例，每次都创建一个新对象
     * request springWeb，每次请求创建一个bean对象
     * session springWeb,每个session创建一个bean对象
     * <p>
     * 懒加载：容器创建时不加载，第一次通过容器获取bean时，创建bean
     */
    @Scope("singleton")
    @Lazy
    @Bean
    public Person person() {
        System.out.println("向容器中添加person bean");
        return new Person("张三", 25);
    }

    /**
     * @Conditional 按照指定条件判断，满足条件给容器中注册bean springboot底层大量使用
     * 可以标注在方法/类上
     * 需求：如果是windows，向容器中注入BillGates 如果是linux,向容器中注入linus
     */
    @Conditional({WindowsCondition.class})
    @Bean("bill")
    public Person person1() {
        return new Person("Bill Gates", 62);
    }

    @Conditional({LinuxCondition.class})
    @Bean("linus")
    public Person person2() {
        return new Person("linus", 50);
    }

    /**
     * 向容器中注入bean的方法
     * 1）包扫描方式+组件注解标注，通过@Controller @Service @Repository @Component [一般用于自己写的类]
     * 2) @Bean导入第三方包的组件
     * 3）@Import[快速向容器中导入一个组件] 作用域为类
     * a {@link Import}@Import({要导入的组件类class})将传入class对象，通过无参构造方法创建bean ，id默认为全路径名
     * b 传入{@link ImportSelector}类，返回需要导入的组件的全类名数组，通过无参构造方法创建bean，id为全路径名
     * c 传入{@link ImportBeanDefinitionRegistrar}类，返回需要导入的组件的全类名数组，通过无参构造方法创建bean，id为全路径名
     * 4）使用spring提供的beanFactory
     */

    @Bean
    public ColorFactoryBean colorFactoryBean() {
        return new ColorFactoryBean();
    }
}
