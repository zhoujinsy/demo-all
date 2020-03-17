package com.spring.filter;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @author zhouj
 * @date 2020/3/17 19:53
 */
public class MyTypeFilter implements TypeFilter {
    /**
     * @param metadataReader        metadataReader the metadata reader for the target class(当前类)
     * @param metadataReaderFactory 可以获取到其他类型类信息metadataReaderFactory a factory for obtaining metadata readers  for other classes (such as superclasses and interfaces)
     * @return
     * @throws IOException
     */
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前类注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取当前正在扫描类的类型信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取当前类资源信息（如类路径）
        Resource resource = metadataReader.getResource();

        String className = classMetadata.getClassName();
        System.out.println("-->" + className);
        if (className.contains("er")) {
            return true;
        }
        return false;
    }
}
