package Set.Collection;

import java.util.ArrayList;
import java.util.Collection;

/*
    关于java.util.Collection接口中常用的方法
        1.Collection中用什么存放元素
            没有使用泛型之前，Collection中可以存储Object的所有子类
            使用了泛型之后，Collection中只能存储某个具体的类型
            集合后期会学习泛型，目前咱不用管。Collection中什么都能存，只要是Object的子类型就行
            （集合中不能直接存储基本数据类型，也不能存java对象，只是存储java对象的内存地址）
        2.Collection中的常用方法
            boolean add(Object o) 向集合中添加元素
            int size() 获取集合中元素的个数
            void clear()  清空集合
            boolean contains(Object o) 判断当前集合中是否包含该元素，包含则返回true，包含则返回false
            boolean remove(Object o) 删除集合中的某个元素
            boolean isEmpty() 判断该集合是否为空（元素个数为0），空返回true，非空返回false
            Object[] toArray() 调用这个方法可以把集合转换成数组（了解，使用不多）

 */
public class CollectionTest01 {
    public static void main(String[] args) {
        //创建一个集合对象
//        Collection c = new Collection(); 接口是抽象的，无法实例化
        Collection c = new ArrayList();
        //测试collection接口中常用的方法
        c.add(1200); //自动装箱，实际上是放进去了一个对象的内存地址。Integer x = new Integer(1200)
        c.add(3.14); //自动装箱
        c.add(new Object());
        c.add(true); //自动装箱

        //获取集合中元素的个数
        System.out.println("集合中元素个数是："+c.size()); //4
        //清空集合
        c.clear();
        System.out.println("集合中元素个数是："+c.size()); //0

        //再向集合中添加元素
        c.add("hello"); //"hello"对象的内存地址放到了集合中
        c.add("world");
        c.add("浩克");
        c.add("绿巨人");

        //集合c中是否包含绿巨人和钢铁侠
        System.out.println(c.contains("绿巨人")); //ture
        System.out.println(c.contains("钢铁侠")); //false

        System.out.println("集合中元素个数是："+c.size()); //4

        //删除集合中某个元素
        c.remove("hello");
        System.out.println("集合中元素个数是："+c.size()); //3

        //判断集合是否为空
        System.out.println(c.isEmpty()); //false
        c.clear();
        System.out.println(c.isEmpty()); //true

        c.add("abc");
        c.add("def");
        c.add(100);
        c.add("hello world!");
        c.add(new Student());

        //转换成数组(了解，使用不多)
        Object[] objs = c.toArray();
        //遍历数组
        for (int i = 0; i < objs.length; i++) {
            Object obj = objs[i];
            System.out.println(obj);
        }
        }
}

class Student{

}