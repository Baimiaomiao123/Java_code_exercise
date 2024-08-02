package com.baimiaomiao.factory.method;

/**
 * 抽象工厂角色
 * @author baimiaomiao
 * @version 1.0
 * @className WeaponFactory
 * @since 1.0
 */


abstract public class WeaponFactory {

    /**
     * 这个方法不是静态的，是实例方法
     * @return
     */
    public abstract Weapon get();
}
