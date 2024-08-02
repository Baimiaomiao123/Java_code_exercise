package Set.Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
    关于集合元素的remove
        重点；当集合的结构发生改变时，迭代器必须重新获取，如果还是用以前老的迭代器，
        会出现异常：java.util.ConcurrentModificationException

        重点：在迭代集合元素的过程中，不能调用集合对象的remove方法，删除元素
            c.remove(o)，会出现异常：java.util.ConcurrentModificationException

        重点：在迭代元素的过程当中，一定要使用迭代器iterator的remove方法删除元素
        不能使用集合的remove方法删除元素
 */
public class CollectionTest06 {
    public static void main(String[] args) {

        //创建集合
        Collection  c = new ArrayList();

        //注意，如果在此生成迭代器，指向的是集合中没有元素状态下的迭代器
        //一定要注意：集合结构只要发生改变，迭代器必须重新获取
        //Iterator it = c.iterator();——空集合
        //当集合结构发生改变，迭代器没有重新获取时，此时调用next方法会出现java.util.ConcurrentModificationException


        //添加元素
        c.add(1);
        c.add(2);
        c.add(3);

        //获取迭代器并进行迭代
        Iterator it = c.iterator();
        while (it.hasNext()){
            //编写代码的next()方法返回值类型必须是Object（方法规定）
            Object obj = it.next();

            System.out.println(obj);
        }

        Collection c2 = new ArrayList();
        c2.add("abc");
        c2.add("def");
        c2.add("xyz");

        System.out.println(c2.size()); //3
        Iterator it2 = c2.iterator();
        while (it2.hasNext()){
            Object o = it2.next();
            //删除元素
            //删除元素之后，集合的结构发生了变化，如果想要程序正常执行，就需要重新去获取迭代器
            //但是，循环下一次的时候并没有重新获取迭代器，所以会出现异常：java.util.ConcurrentModificationException
            //c2.remove();——直接通过集合删除元素，并没有通知迭代器（导致迭代器的快照和原集合不一致，导致报错）
            //使用迭代器的remove()方法则可以删除——删除迭代器中的元素，同时也删除了原集合对应的元素
            it2.remove();
        }

        System.out.println(c2.size()); //0

    }
}
