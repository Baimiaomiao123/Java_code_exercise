package AnonymousInnerClass;

/*
    匿名内部类：
        1.什么是内部类？
            内部类：在类的内部又定义了一个新的类，称为内部类

        2.内部类的分类
            静态内部类：类似于静态变量
            实例内部类：类似于实例变量
            局部内部类：类似于局部变量

        3.使用内部类编写的代码可读性很差，能不用尽量不用

        4.匿名内部类属于局部内部类的一种
            因为这个类没有名字而得名，所以称为匿名内部类

        5.学习匿名内部类主要是为以后阅读别人代码的时候，能够理解

 */
public class AnonymousInnerClassTest01 {

    //静态变量
    static String country;

    //该类在类的内部，所以称为内部类
    //由于有static，称为静态内部类
    static class Inner1{

    }

    //实例变量
    int age;

    //该类在类的内部，所以称为内部类
    //没有static，称为实例内部类
    class Inner2{

    }


    public void doSome(){

        //局部变量
        int i = 100;

        //该类在类的内部，所以称为内部类
        //出现在局部变量范围内的类，称为局部内部类
        class Inner3{

        }

    }

    public void doOther(){
        new AnonymousInnerClassTest01.Inner1();
        new AnonymousInnerClassTest01().new Inner2();
        //doSome中的Inner3类不能使用
    }

    public static void main(String[] args) {
        Mymath mm = new Mymath();
        mm.sum(new ComputeImp1(),100,200);

        //使用匿名内部类,({}表示对接口的实现)
        //不建议使用匿名内部类，因为一个类没有名字，没有办法重复使用，另外代码太乱，可读性差
        mm.sum(new Compute() {
            @Override
            public int sum(int a, int b) {
                return a+b;
            }
        },100,200);
    }


}

//负责计算的接口
interface Compute{

    //抽象方法
    int sum(int a,int b);
}

//编写一个Compute接口的实现类
class ComputeImp1 implements Compute{

    //对方法的实现
    @Override
    public int sum(int a, int b) {
        return a + b;
    }
}

class Mymath{
    //数学求和方法
    public void sum(Compute c,int x,int y){
        int retValue = c.sum(x,y);
        System.out.println(x + "+" + y +"="+retValue);
    }
}



