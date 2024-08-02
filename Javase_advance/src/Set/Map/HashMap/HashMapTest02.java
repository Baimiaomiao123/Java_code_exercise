package Set.Map.HashMap;

import java.util.HashSet;
import java.util.Set;

/*
    1、向Map集合中存或向Map集合中取，都是先调用key的hashCode方法，然后再调用equals方法
    equals方法可能调用，也可能不调用
        拿put(k,v)举例，什么时候equals不会调用？
            哈希值经过哈希算法转换成数组下标
            数组下标位置上如果是null，equals不需要执行
        拿get(k)，什么时候equals不会调用
            哈希值经过哈希算法转换成数组下标
            数组下标位置上如果是null，equals不需要执行

    2、如果一个类的equals方法重写了，那么hashCode()方法必须重写，并且equals方法返回如果是true，hashCode()方法返回的值必须一样
    equals方法返回true表示两个对象相同，在同一个单向链表上进行比较
    那么对于同一个单向链表上的节点来说，他们的哈希值都是相同的
    所以hashCode()方法的返回值也应该相同

    3、hashCode()方法和equals方法直接用IDEA工具生成即可，但是必须需要同时生成
        解释：
        hashCode和对象的关系必须要满足以下四条关系：
        1）两个对象相等，hashCode一定相等；
        2）两个对象不等，hashCOde不一定不等；
        3）hashCode相等，两个对象不一定相等；
        4）hashCode不等，两个对象一定不等；
        重写equals方法必须跟着重写hashCode方法，因为重写equals后比较的是两个对象的属性是否相等，而不是两个对象的地址是否相等。
        这是没有重写hashCode的方法，这时仍比较的是两个对象的地址，这就造成了如果两个对象的地址不相等，但是两个对象的属性相等，
        那么equals判断两个对象相等，hashCode就会不相等，违反第一条关系，所以必须同时重写两个方法

        此外两个对象比较，由于 Java 默认比较的是类的地址值，每个对象一定是不同的，所以需要重写 hashCode() 和 equals()。
        重写 hashCode() 是为了提高效率，因为先根据类里的属性生成 hashCode，如果生成的 hashCode 值不同，
        则没必要再使用 equals() 比较属性的值，这样就大大减少了 equals 的次数，这对大数据量比较的效率提高是很明显的。

    4、终极结论：
        放在HashMap集合key部分的妈，以及放在HashSet集合中的元素，需要同时重写hashCode和equals方法

    5、对于哈希表数据结构来说：
        如果o1和o2的hash值相同，一定是放到同一个单向链表上
        当然如果o1和o2的hash值不同，但由于hash算法执行结束之后转换的数组下标可能相同，此时会发生"哈希碰撞"

 */
public class HashMapTest02 {

    public static void main(String[] args) {
        Student s1= new Student("zhangsan");
        Student s2= new Student("zhangsan");
//        System.out.println(s1.equals(s2)); //false 【重写equals方法以前】
        System.out.println(s1.equals(s2)); //true 【重写equal方法以后】

        System.out.println("s1的hashCode："+s1.hashCode());
        System.out.println("s2的hashCode："+s2.hashCode());

        //s1.equals(s2)结果已经是true了，表示s1和s2是一样的
        //按说只能放进去1个
        Set<Student> students = new HashSet<>();
        students.add(s1);
        students.add(s2);

        System.out.println(students.size()); //这个结果应该是1 在重写hashCode前是2，所以必须要重写hashCode方法。重写后是1
    }
}
