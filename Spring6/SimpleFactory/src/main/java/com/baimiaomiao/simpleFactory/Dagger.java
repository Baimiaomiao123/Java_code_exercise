package com.baimiaomiao.simpleFactory;

/**
 * 具体产品角色
 * @author baimiaomiao
 * @version 1.0
 * @className Dagger
 * @since 1.0
 */


public class Dagger extends Weapon{
    @Override
    public void attack() {
        System.out.println("砍丫的");
    }
}
