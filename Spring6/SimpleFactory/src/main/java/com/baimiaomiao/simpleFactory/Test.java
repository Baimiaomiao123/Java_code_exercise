package com.baimiaomiao.simpleFactory;

/**
 * 这是客户端程序
 * @author baimiaomiao
 * @version 1.0
 * @className Test
 * @since 1.0
 */


public class Test {
    public static void main(String[] args) {
        //需要坦克
        //对于客户端来说，生产细节不需要关系，只需要向工厂所需要即可
        //客户端不需要关心产品的生产细节，客户端只负责消费，生产类负责生产，这就是简单工厂模式的作用
        Weapon tank = WeaponFactory.get("tank");
        tank.attack();

        //需要战斗机
        Weapon fighter = WeaponFactory.get("fighter");
        fighter.attack();

        //需要匕首
        Weapon dagger = WeaponFactory.get("dagger");
        dagger.attack();
    }
}
