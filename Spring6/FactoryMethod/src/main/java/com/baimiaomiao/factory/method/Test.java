package com.baimiaomiao.factory.method;

/**
 * 客服端程序
 * @author baimiaomiao
 * @version 1.0
 * @className Test
 * @since 1.0
 */


public class Test {

    public static void main(String[] args) {
        WeaponFactory weaponFactory = new DaggerFactory();
        Weapon dagger = weaponFactory.get();
        dagger.attack();

        WeaponFactory weaponFactory1 = new GunFactory();
        Weapon gun = weaponFactory1.get();
        gun.attack();

    }
}
