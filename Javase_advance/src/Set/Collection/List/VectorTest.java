package Set.Collection.List;

import java.util.*;

/*
    Vector：
        1、底层也是一个数组
        2、初始化容量：10
        3、怎么扩容？
            扩容之后是原容量的2倍
            10 --> 20 --> 30
          ArrayList的扩容
            扩容之后是原容量的1.5倍
            10 --> 15
        4、Vector中所有的方法都是线程同步的，都带有synchronized关键字
            线程安全效率比较低，使用较少了
        5、怎么将一个线程不安全的ArrayList集合转换成线程安全的呢？
            使用集合工具类：
                java.util.Collection;

                java.util.


 */
public class VectorTest {
    public static void main(String[] args) {
        Vector vector = new Vector();

        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.add(5);
        vector.add(6);
        vector.add(7);
        vector.add(8);
        vector.add(9);
        vector.add(10);

        //满了之后扩容，扩容之后的容量为20
        vector.add(11);

        Iterator it = vector.iterator();
        while (it.hasNext()){
            Object obj = it.next();
            System.out.println(obj);
        }

        //这个可能以后要使用
        List mylist = new ArrayList(); //非线程安全

        //变成线程安全
        Collections.synchronizedList(mylist);

        //此时mylist集合是线程安全的了
        mylist.add("111");
        mylist.add("222");
        mylist.add("333");

    }
}
