package Connection;


/*
    接口总结：
        1.接口也是一种引用数据类型，编译之后也是一个class

        2.接口是完全抽象的。（抽象类是半抽象的）

        3.接口怎么定义，语法是什么？
            [修饰符列表] interface 接口名{
            }
            [修饰符列表] class 类名{
            }
            [修饰符列表] abstract class 抽象类名{
            }

        4.接口支持多继承，一个接口可以继承多个接口

        5.接口只包含两部分内容：一部分是常量。一部分是抽象方法。（没有其他内容，只有以上两个部分）

        6.接口中所有元素都是Public修饰的

        7.接口中抽象方法定义时,public abstract修饰符可以省略

        8.接口中的方法都是抽象方法，所以接口中的方法不能有方法体

        9.接口中的常量public static final可以省略

        10.一个非抽象的类，实现接口的时候，必须将接口中所有方法实现（覆盖/重写）

        11.一个类可以实现多个接口

        12.继承和实现同时实现时，extends在前，implements在后

        13.使用接口，写代码的时候，可以使用多态（父类型引用指向子类型对象）
 */


public class ConnectionTest01 {
    public static void main(String[] args) {
        System.out.println(MyMath.pi);
    }
}

//定义接口
interface A{

}

//接口支持继承
interface B extends A{

}

//接口支持多继承
interface C extends A,B{

}

//我的数学接口
interface MyMath{

    //常量(public static final可以省略)
    double pi = 3.1415926;

    //抽象方法（public abstract可以省略）
    int sum(int a,int b);

    //相减的抽象方法
    int sub(int a,int b);
}