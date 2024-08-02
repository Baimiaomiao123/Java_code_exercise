package com.baimiaomiao.spring6.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className PersonFactoryBean
 * @since 1.0
 */


public class PersonFactoryBean implements FactoryBean { //也是一个Bean，只不过比较特殊，叫做工厂bean
    @Override
    public Person getObject() throws Exception {
        //最终这个Bean的创建还是由程序员自己new的
        return new Person();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    //这个方法在接口中有默认实现
    //默认返回true，表示单例的
    //如果想多例，直接将这个方法修改为return false即可
    @Override
    public boolean isSingleton() {
        return true;
    }
}
