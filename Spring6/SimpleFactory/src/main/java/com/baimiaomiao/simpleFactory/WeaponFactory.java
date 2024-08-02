package com.baimiaomiao.simpleFactory;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className WeaponFactory
 * @since 1.0
 */


public class WeaponFactory {

    /**
     * 静态方法，要获取什么产品？就看你传什么参数，传Tank获取坦克，传Dagger获取匕首，传Fighter获取直升机
     * 简单工厂模式中有一个静态方法，所以被称为静态工厂方法模式
     * @param weaponType
     * @return
     */
    public static Weapon get(String weaponType){
        if ("TANK".equals(weaponType.toUpperCase())) {
            return new Tank();
        }else if ("FIGHTER".equals(weaponType.toUpperCase())){
            return new Fighter();
        }else if ("DAGGER".equals(weaponType.toUpperCase())){
            return new Dagger();
        }else {
            throw new RuntimeException("不支持该武器的生产");
        }
    }
}
