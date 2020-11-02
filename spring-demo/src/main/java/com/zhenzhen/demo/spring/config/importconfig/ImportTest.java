package com.zhenzhen.demo.spring.config.importconfig;

import com.zhenzhen.demo.spring.bean.TestImportBean1;
import com.zhenzhen.demo.spring.bean.TestImportBeanDefinitionRegistrar;
import com.zhenzhen.demo.spring.bean.TestImportSelect;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * @author zhen.yin
 * @title:
 * @description:
 * @date 2020/11/2 10:47
 */
@Component
@Import(value = {TestImportBean1.class,TestImportBeanDefinitionRegistrar.class, TestImportSelect.class })
public class ImportTest {
}
