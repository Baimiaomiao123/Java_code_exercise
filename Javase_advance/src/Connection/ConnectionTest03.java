package Connection;

/*
    1.接口和接口之间支持多继承，那么一个类可以同时实现多个接口吗？
        ——  可以

    2.一个类同时可以有多个接口
    弥补了java中类和类只支持单继承，java中的类和接口补足了多继承

    3.之前的结论：
    无论向上转型还是向下转型，两种类型之间必须要有继承关系，没有继承关系编译器会报错
    但是这句话对于接口方面不适用，最终实际上还是一样，需要加instanceof运算符进行判断
 */

public class ConnectionTest03 {
    public static void main(String[] args) {

        //多态的使用
        //都是父类型引用指向子类型对象
        A1 a = new D();
        B1 b = new D();
        C1 c = new D();

        //接口和接口之间强制转化时，没有继承关系也可以进行强制类型转化（编译阶段正常）
        //但是注意，运行的时候可能会出现ClassCastException异常（允许阶段异常）
        /*编译阶段：接口和接口之间虽然没有继承关系，能进行强制类型转换，编译阶段通过
                  类和类之间没有继承关系，不能进行强制类型转换，编译阶段报错
          运行阶段：都会有ClassCastException异常，运行阶段都会报错

        */
        //接口转换
        B1 b2 = (B1)a;
        b2.m2();

        //强制类型转换
        D d1 = (D)a;
        d1.m2();

    }
}

interface A1{
    void m1();
}

interface B1{
    void m2();
}

interface C1{
    void m3();
}

class D implements A1,B1,C1{

    //实现接口A1中的m1方法
    @Override
    public void m1() {

    }

    //实现接口B1中的m2方法
    @Override
    public void m2() {
        System.out.println("m2.....");
    }

    //实现接口C1中的m3方法
    @Override
    public void m3() {
        System.out.println("m3....");
    }
}