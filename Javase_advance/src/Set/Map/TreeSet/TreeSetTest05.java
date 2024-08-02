package Set.Map.TreeSet;

import java.util.Comparator;
import java.util.TreeSet;

/*
    TreeSet集合中元素可排序的第二种方式：使用比较器的方式
    最终的结论：
         放到TreeSet或者TreeMap集合key部分的元素要想做到排序，包括两种方式：
            第一种：放在集合中的元素实现java.lang.Comparable接口
            第二种：在构造TreeSet或者TreeMap集合的时候给它传一个比较器对象

         comparable和comparator怎么选择？
            当比较规则不会发生改变的时候，或者说比较规则只有1个的时候，建议实现comparable接口
            如果比较规则有多个，并且需要多个比较规则之间频繁切换，建议使用comparator接口

            comparator接口的设计符合OCP原则


 */
public class TreeSetTest05 {
    public static void main(String[] args) {
        //创建TreeSet集合的时候，需要使用这个比较器
//        TreeSet<Turtle> turtles = new TreeSet<>(); 这样不行，因为没有通过一个构造器传递一个比较器进去
        TreeSet<Turtle> turtles = new TreeSet<>(new TurtleComparator());


        //如果不想重新写一个比较器进行比较，也可以使用匿名内部类（这个类没有名字，直接new接口）
        TreeSet<Turtle> turtles1 = new TreeSet<>(new Comparator<Turtle>() {
            @Override
            public int compare(Turtle o1, Turtle o2) {
                return o1.age - o2.age;
            }
        });


        turtles.add(new Turtle(1000));
        turtles.add(new Turtle(999));
        turtles.add(new Turtle(111));

        for (Turtle t:
             turtles) {
            System.out.println(t);
        }
    }
}

class Turtle{
    int age;
    public Turtle(int age){
        this.age = age;
    }

    @Override
    public String toString(){
        return "小乌龟[" +
                "age=" + age +
                "]";
    }

}

//单独在这里编写一个比较器
//比较器实现java.util.Comparator接口
class TurtleComparator implements Comparator<Turtle> {

    public int compare(Turtle o1,Turtle o2){
        //指定比较规则
        //按照年龄排序
        return o1.age - o2.age;
    }
}
