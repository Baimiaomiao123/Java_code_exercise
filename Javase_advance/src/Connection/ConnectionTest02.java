package Connection;
/*
    接口的基础语法：
        1.类和类之间叫做继承，类和接口之间叫做实现（可以"继承"）
        继承使用extends关键字完成
        实现使用implements关键字完成

        2.当一个非抽象类实现接口的话，必须实现（覆盖/重写）抽象类中的所有抽象方法
          但是一个抽象类实现接口，非必须实现所有抽象方法

        为什么抽象类不需要实现所有方法？
        因为抽象类本身是具有抽象性的，它的方法也大多不需要进行实现，只需要声明，其他实现的过程多交给继承它的子类。
        而接口本身就更为抽象的一种形式，所以如果让一个本来抽象的类去实现一个更为抽象的接口的所有方法是没有必要的，
        除非对于抽象类本身而言需要接口的一些方法来完善自身。
        而没有实现的其他方法完全可以交给它的派生类去实现。

        为什么普通类需要实现所有方法？
        普通类中的所有方法都需要有方法体，即使是空方法。
        当一个普通类实现了一个接口后就必须要实现其所有的方法，
        如果有任何一个方法没有实现，在类向接口向上转型的时候就会因为丢失数据（因为此时普通类中没有接口的完整数据）导致转型失败，程序报错。


 */

public class ConnectionTest02 {
    public static void main(String[] args) {

        //能使用多态吗？能

        //父类型的引用指向子类型的对象
        Math M = new MathImp1();

        //调用接口里面的方法（面向接口编程）
        int result = M.sub(1,2);
        int result2 = M.sum(1,2);

        //输出结果
        System.out.println(result);
        System.out.println(result2);
    }
}

//特殊的抽象类，完全抽象的，叫做接口
interface Math{

    //常量(public static final可以省略)
    double pi = 3.1415926;

    //抽象方法（public abstract可以省略）
    int sum(int a,int b);

    //相减的抽象方法
    int sub(int a,int b);
}

//编写一个类（这个类是一个"非抽象"的类）
//这个类的名字是随意的
/*
class MyMathImp1 implements Math{

}
这是错误的，因为MyMathImp1不是抽象的，并且未覆盖Math中的抽象方法
 */
//修正
class MathImp1 implements  Math{

    //错误:正在尝试喷肥更低的访问权限，以前为public
    /*
        int sum(int a,int b){
            return a + b;
        }
     */

    //实现/重写/覆盖接口中的方法(这样才能完成"实现")
    @Override
    public int sub(int a, int b) {
        return a - b;
    }

    @Override
    public int sum(int a, int b) {
        return a + b;
    }
}
