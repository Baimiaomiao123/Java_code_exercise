package Set.Collection.List.ArrayList;

import java.util.ArrayList;
import java.util.List;

/*
    ArrayList集合：
        1、默认初始化容量为10（底层先创建了一个长度为0的数组，当添加第一个元素的时候，初始化为10）
        2、集合底层是一个Object[]数据
        3、构造方法：
            new ArrayList();
            new ArrayList(20);
        4、ArrayList集合的扩容：
            增长到原容量的1.5倍
            ArrayList集合底层是数组，怎么优化？
                尽可能少的扩容，因为数组扩容效率比较低，尽量在使用ArrayList集合的时候预估计元素的个数，给定一个初始化容量
        5、数组优点：检索效率比较高。（每个元素占用空间大小相同，内存地址是连续的，知道首元素的内存地址，然后知道下标，就可以根据数学表达式酸楚元素的内存地址）
        6、数组缺点：随机增删元素效率比较低。
                   另外数组无法存储大数据量，很难找到一块非常巨大的连续的内存空间
        7、向数组末尾添加元素，效率很高，不受影响
        8、面试官经常问的一个问题：
            这么多集合，用哪个集合最多？
                答：ArrayList集合。因为往数组末尾添加元素效率不受影响，另外查找元素也更有效率
        9、ArrayList集合是非线程安全的（不是线程安全的集合）

 */
public class ArrayListTest01 {
    public static void main(String[] args) {
        //默认初始化容量是10
        //数据的长度是10
        List list1 = new ArrayList();
        //集合的size方法是获取当前集合元素的个数，不是获取集合的容量
        System.out.println(list1.size()); //0

        List list2 = new ArrayList();
        System.out.println(list2.size()); //0

        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);
        list1.add(7);
        list1.add(8);
        list1.add(9);
        list1.add(10);




    }
}
