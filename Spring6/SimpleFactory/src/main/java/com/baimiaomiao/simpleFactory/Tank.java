package com.baimiaomiao.simpleFactory;

/**
 * 具体产品角色
 * @author baimiaomiao
 * @version 1.0
 * @className Tank
 * @since 1.0
 */


public class Tank extends Weapon{

    @Override
    public void attack() {
        System.out.println("坦克开炮");
    }
}
