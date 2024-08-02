package Connection;
/*
    继承和实现都存在的话，代码应该怎么写？
        extends 关键字在前
        implements 关键字在后
 */
public class ConnectionTest04 {
    public static void main(String[] args) {

        //创建对象
        Flyable f1 = new Cat(); //多态，父类型引用变量指向子类型的实例对象（子类型的对象赋予给父类型的引用变量，即向上转型）
        f1.fly();

        Flyable f2 = new Pig();
        f2.fly();

        Flyable f3 = new Fish();
        f3.fly();
    }
}

//动物类：父类
class Animal{
}

//可飞翔的接口(一对翅膀)
//能插拔的就是接口(内存条插到主板上，内存条可以更换)
//接口通常提取的是行为动作
interface Flyable{
    void fly();
}



//动物类子类：猫类
//flyable是一个接口，是一对翅膀的接口，通过接口插到猫身上
class Cat extends Animal implements Flyable{
    @Override
    public void fly() {
        System.out.println("飞猫起飞，翱翔太空的一只猫，很神奇");
    }
}

//动物类子类：蛇类
//不像让他飞，可以不实现flyable接口
class Snake extends Animal{
}

//动物类子类：猪类
//猪想要飞，直接插上飞翔的几口即可
class Pig extends Animal implements Flyable{

    @Override
    public void fly() {
        System.out.println("我是一只会飞翔的猪");
    }
}

//默认继承Object
class Fish implements Flyable{
    @Override
    public void fly() {
        System.out.println("会飞的鱼");
    }
}