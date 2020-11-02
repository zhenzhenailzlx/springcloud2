package com.zhenzhen.demo.spring.bean;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author zhen.yin
 * @title:
 * @description:
 * @date 2020/11/2 10:50
 */
public class TestImportSelect implements DeferredImportSelector {
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        //注意不能返回null，可以返回一个空数组
        return new String[]{"com.zhenzhen.demo.spring.bean.TestImportSelectBean1",
                "com.zhenzhen.demo.spring.bean.TestImportSelectBean2"};
        //return new String[0];
    }
}
