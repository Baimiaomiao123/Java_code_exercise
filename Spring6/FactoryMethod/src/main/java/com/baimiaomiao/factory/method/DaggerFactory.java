package com.baimiaomiao.factory.method;

/**
 * 具体工厂角色
 * @author baimiaomiao
 * @version 1.0
 * @className DaggerFactory
 * @since 1.0
 */


public class DaggerFactory extends WeaponFactory{
    @Override
    public Weapon get() {
        return new Dagger();
    }
}
