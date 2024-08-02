package com.baimiaomiao.factory.method;

/**
 * 具体工厂角色
 * @author baimiaomiao
 * @version 1.0
 * @className GunFactory
 * @since 1.0
 */


public class GunFactory extends WeaponFactory{
    @Override
    public Weapon get() {
        return new Gun();
    }
}
