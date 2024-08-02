package Set.Map.TreeSet;

import java.util.TreeSet;

/*
    对自定义的类型来说，TreeSet可以排序吗？
        以下程序中，对于Person类型来说，无法排序。因为咩有指定Person对象之间的比较规则

        以下程序运行的时候出现了这个异常
            java.lang.ClassCastException:
            class Set.Map.TreeSet.Person cannot be cast to class java.lang.Comparable
            (Set.Map.TreeSet.Person is in unnamed module of loader 'app';
            java.lang.Comparable is in module java.base of loader 'bootstrap')

        出现以下这个原因是：
            Person类没有实现java.lang.Comparable接口
 */
public class TreeSetTest02 {
    public static void main(String[] args) {
        Person p1 = new Person(11);
        Person p2 = new Person(22);
        Person p3 = new Person(33);
        Person p4 = new Person(44);
        Person p5 = new Person(55);

        TreeSet<Person> persons = new TreeSet<>();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);
        persons.add(p5);

        //遍历
        for (Person p :
             persons) {
            System.out.println(p.toString());
        }

    }
}

class Person{
    int age;

    public Person(int age){
        this.age = age;
    }

    //重写toString()方法
    public String toString(){

        return "Person[age=" + age + "]";
    }
}
