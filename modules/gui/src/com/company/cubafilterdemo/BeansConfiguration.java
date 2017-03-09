package com.company.cubafilterdemo;

import com.haulmont.cuba.gui.components.filter.ConditionParamBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {
    public BeansConfiguration(ApplicationContext applicationContext) {
        BeanDefinitionRegistry factory = (BeanDefinitionRegistry) applicationContext.getAutowireCapableBeanFactory();
        factory.removeBeanDefinition(ConditionParamBuilder.NAME);
        factory.registerBeanDefinition(ConditionParamBuilder.NAME, factory.getBeanDefinition(ExtConditionParamBuilderImpl.NAME));
    }
}
