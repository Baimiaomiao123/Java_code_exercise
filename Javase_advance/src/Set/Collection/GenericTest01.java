package Set.Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
    JDK5.0之后推出的新特性：泛型
    1、泛型这种语法机制，只在程序编译阶段起作用，只是给编译器参考的（运行阶段泛型没用）
    2、使用了泛型机制的好处是什么？
        第一：集合存储的元素类型统一了
        第二：从集合中取出的元素类型是泛型指定的类型，不需要进行大量的"向下转型"
    3、泛型的缺点是什么？
        导致集合中存储的元素缺乏多样性
    大多数时候，一般需要取出的都是指定类型的元素，所以泛型被广泛认可
    java 中泛型标记符：
    E - Element (在集合中使用，因为集合中存放的是元素)
    T - Type（Java 类）
    K - Key（键）
    V - Value（值）
    N - Number（数值类型）
    ？ - 表示不确定的 java 类型
 */
public class GenericTest01 {
    public static void main(String[] args) {
        /*
        //不是用泛型机制，分析程序存在的缺点
        List mylist = new ArrayList();

        //准备对象
        Cat c = new Cat();
        Bird b = new Bird();

        //将对象加入到集合中
        mylist.add(c);
        mylist.add(b);

        //遍历集合，取出cat让它抓老鼠，取出bird让它飞
        Iterator it = mylist.iterator();
        while(it.hasNext()){
            Object obj = it.next(); //注意，通过迭代器得到的只能是Object类
            if(obj instanceof Cat){
                Cat c1 = (Cat) obj;
                c1.catchMouse();
            } else if (obj instanceof Bird) {
                Bird b1 = (Bird) obj;
                b1.fly();
            }
        }
         */

        //使用JDK5.0之后的泛型机制
        //使用泛型List<Animal>之后，表示List集合只允许存储Animal类型的数据
        //用泛型指定集合中存储的数据类型
        List<Animal> mylist = new ArrayList<Animal>();
//        mylist.add("abc"); 就不能存其他数据类型了

        Cat c = new Cat();
        Bird b = new Bird();

        mylist.add(c);
        mylist.add(b);

        //获取迭代器
        //这个表示迭代器迭代的是Animal类型
        Iterator<Animal> it = mylist.iterator();
        while (it.hasNext()){

            Animal a = it.next();
            a.move();

            //但是在调用子类特有的方法时候，还是避开不了需要转型
            if (a instanceof Cat){
                ((Cat) a).catchMouse();
            }else if(a instanceof Bird){
                ((Bird) a).fly();
            }
        }


    }
}

class Animal{
    public void move(){
        System.out.println("动物在移动");
    }
}

class Cat extends Animal{
    public void catchMouse(){
        System.out.println("猫抓老鼠");
    }
}

class Bird extends Animal{
    public void fly(){
        System.out.println("鸟儿在飞翔");
    }

}