package com.spring.importer;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author zhouj
 * @date 2020/3/17 22:04
 */
public class MyImportSelector implements ImportSelector {

    /**
     * 自定义逻辑，返回需要的组件类名数组
     * @param importingClassMetadata 当前标注@Import注解的类的所有注解信息
     * @return
     */
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        return new String[]{"com.spring.bean.Blue","com.spring.bean.Yellow"};
    }
}
