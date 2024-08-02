package Polymorphy;

//猫类
public class Cat extends Animal{

    //重写从父类中继承的方法
    public void move(){
        System.out.println("猫在走猫步");
    }

    //子类对象特有
    public void catMouse(){
        System.out.println("猫抓老鼠！");
    }
}
