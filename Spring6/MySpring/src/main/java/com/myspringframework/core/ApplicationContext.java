package com.myspringframework.core;

/**
 * MySpring框架应用上下文接口
 * @author baimiaomiao
 * @version 1.0
 * @className ApplicationContext
 * @since 1.0
 */


public interface ApplicationContext {

    /**
     * 根据bean的名称返回对应的bean的对象
     * @param beanName bean的名称
     * @return 对应的单例bean对象
     */
    Object getBean(String beanName);
}
