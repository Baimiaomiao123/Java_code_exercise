package Constructor.example03;
/**
 *      关于java语言当中的要求：
 *          1.继承是面向对象三大特征之一，三大特征分别是封装，继承，多态
 *
 *          2.继承"基本作用"是：代码复用。但是继承最重要的作用是，有了继承才有了以后"方法覆盖"和"多态机制"
 *
 *          3.继承语法格式（继承的关键字:extends）：
 *              [修饰符列表] class 类名 extends 父类名{
 *                  类体 = 属性 + 方法;s
 *              }
 *
 *          4.Java语言中的继承只支持单继承，一个类不能同时继承很多类，只能继承一个类[C++允许继承多个类]
 *
 *          5.关于继承中的一些术语：
 *              B类继承A类，其中：
 *                  A类称为：父类、基类、超类、superclass
 *                  B类称为：子类、派生类、subclass
 *
 *          6.在java语言中子类继承父类能继承那些数据？
 *              除私有的、构造方法，其他术语都可以继承
 *
 *          7.虽然java语言当中只支持单继承，但是一个类也可以继承其他类，例如
 *              C extends B{
 *
 *              }
 *              B extends A{
 *  *
 *  *           }
 *              C直接继承B类，间接继承A类
 *
 *          8.java语言中假设一个类没有继承任何类，该类默认继承javaSE库当中提供的java.lang.object类
 *
 */
public class ExtendsTest {
    public static void main(String[] args) {
        ExtendsTest et = new ExtendsTest();
        String s = et.toString();
        System.out.println(s);

        CreditAccount act = new CreditAccount();
        act.setActno("1");
        act.setBalance(100.0);
        act.setCredit(100.0);

        System.out.println(act.getActno() + "," + act.getBalance() + "," + act.getCredit());
    }
}
