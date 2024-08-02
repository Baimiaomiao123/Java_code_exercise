package Set.Collection;

import java.util.ArrayList;
import java.util.Collection;

/*
    深入Collection集合的contains方法：
        boolean contains(Object o)
            判断集合中是否包含某个对象
            如果包含返回true，不包含返回false

        contains方法是用来判断集合中是否包含某个元素的方法
        那么它在底层是怎么判断集合中是否包含某个元素的呢？
            调用了equals方法进行对比
            equals方法返回true，就表示包含这个元素
 */
public class CollectionTest04 {
    public static void main(String[] args) {
        //创建集合对象
        Collection c = new ArrayList();

        //向集合中存储元素
        String s1 = new String("abc");
        c.add(s1);

        String s2 = new String("def");
        c.add(s2);

        //集合中元素的个数
        System.out.println("元素的个数是："+c.size());

        String x = new String("abc");
        System.out.println(c.contains(x)); // 判断集合中是不是含有"abc"，而不是判断地址，底层的代码判断用的是equals方法，所以为true

    }
}
