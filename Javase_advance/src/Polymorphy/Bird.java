package Polymorphy;

//鸟类
public class Bird extends Animal{

    //重写从父类中继承的方法
    public void move(){
        System.out.println("鸟儿在飞翔");
    }

    //子类对象特有的方法
    public void fly(){
        System.out.println("bird fly!");
    }
}
