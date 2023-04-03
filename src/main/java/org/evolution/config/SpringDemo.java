package org.evolution.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class SpringDemo implements InstantiationAwareBeanPostProcessor {


    @Override
    /*实例化前*/
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            System.out.println("userServer 实例化前");
        }
        return null;
    }
}
