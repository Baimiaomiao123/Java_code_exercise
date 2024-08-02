package Test.com;

public class Test01 {
    public static void main(String[] args) {

        //接口x和接口y之间没有继承关系
        Y y = new Z();
        X x = (X)y;
        x.x();

        //类A与类B之间没有继承关系
        B b = new C();
        b.StringB();
        //A a = (A)b;
        //a.StringA();
    }
}

//定义接口、接口与类之间的实现关系
interface X{
    void x();
}
interface Y{
    void y();
}
class Z implements X,Y{
    @Override
    public void x(){
        System.out.println("x...");
    }
    public void y() {
        System.out.println("y...");
    }
}

//定义类、类与类之间的继承关系
class A{
    public void StringA(){
        System.out.println("A....");
    }
}
class B{
    public void StringB(){
        System.out.println("B....");
    }
}
class C extends B{
    @Override
    public void StringB() {
        System.out.println("B1.....");
    }
}