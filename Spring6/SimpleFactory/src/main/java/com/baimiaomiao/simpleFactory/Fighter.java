package com.baimiaomiao.simpleFactory;

/**
 * 具体产品角色
 * @author baimiaomiao
 * @version 1.0
 * @className Fighter
 * @since 1.0
 */


public class Fighter extends Weapon{
    @Override
    public void attack() {
        System.out.println("战斗机抛下小男孩");
    }
}
