package com.baimiaomiao.factory.method;

/**
 * 具体产品角色
 * @author baimiaomiao
 * @version 1.0
 * @className Gun
 * @since 1.0
 */


public class Gun extends Weapon{
    @Override
    public void attack() {
        System.out.println("开枪射击！！");
    }
}
