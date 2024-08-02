package Set.Map;

import javax.management.ObjectName;
import java.util.HashSet;
import java.util.Set;

public class InnerClass {

    //声明一个静态内部类
    private static class innerclass{

        //静态内部类中的静态方法
        public static void m1(){
            System.out.println("静态内部类中的m1方法执行");
        }

        //静态内部类的实例方法
        public void m2(){
            System.out.println("静态内部类中的m2方法执行");
        }

    }

    public static void main(String[] args) {
        //静态内部类的静态直接可以调用，不用创建对象
        InnerClass.innerclass.m1();

        //静态内部类中的实例方法调用必须创建对象
        //创建静态内部类的对象
        InnerClass.innerclass ic = new InnerClass.innerclass();
        //调用静态内部类的方法
        ic.m2();

        //给一个Set集合
        //该Set集合中存储的对象是：InnerClass.innerclass类型
        Set<InnerClass.innerclass> set = new HashSet<>();
        //这个集合中存储的是字符串对象
        Set<String> set1 = new HashSet<>();

        Set<Mymap.MyEntry<Integer,String>> set2 = new HashSet<>();
    }
}


class Mymap{
    public static class MyEntry<K,V>{

    }
}