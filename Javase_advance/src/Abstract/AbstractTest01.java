package Abstract;

/*
    抽象类：
    1.抽象类的定义？
        "类"的类，类和类之间具有共同特征，将这些共同特征提取出来，形成的就是抽象类
        类本身是不存在的，所以抽象类无法创建对象（无法实例化）
    2.抽象类属于什么类型？
        也属于引用数据类型
    3.抽象类如何定义
        语法：
            [修饰符列表] abstract class 类名{
                类体;
            }
    4.final和abstract不能同时出现（因为abstract存在的意义就是为了继承，加上final则无法被继承）

    5.抽象类虽然无法创建实例对象，但是有构造方法，该构造方法供子类使用

    6.抽象类关联到一个概念：抽象方法。
      抽象方法表示没有实现的方法，没有方法体的方法。例如
      public abstract void doSome();
        抽象方法特点是：
            特点1：没有方法体，以分号结尾
            特点2：前面修饰符列表中有abstract关键字

    7.抽象类中不一定有抽象方法，但是抽象类必须出现在抽象类中
      重要结论：一个非抽象的类继承抽象类，必须将抽象类中的抽象方法实现【覆盖/重写/实现】（java语法机制规定）

 */
public class AbstractTest01 {

    public static void main(String[] args) {
        //抽象类无法创建对象
        //Account a = new Account();
    }
}

//银行账户类
abstract class Account {

    /*无法创建构造方法
    public Account(String s){

    }
     */
}

//子类继承抽象类，子类可以实例化对象
class CreditAccount extends Account{

}

//抽象类的子类可以是抽象类
abstract class SavingAccount extends Account{

}
