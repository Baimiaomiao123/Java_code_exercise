package Set.Collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 *  关于集合遍历/迭代器专题
 *
 */
public class CollectionTest02 {
    public static void main(String[] args) {
        // 注意： 以下的遍历方式/迭代方式，是所有Collection通用的一种方式
        // 在Map集合中不能用。在所有的Collection及子类中使用

        //创建集合对象
        Collection c =new HashSet(); //后面的集合无所谓，主要看前面的Collection接口，怎么遍历/迭代

        //添加元素
        c.add("abc");
        c.add("def");
        c.add(100);
        c.add(new Object());

        //对集合Collection进行遍历/迭代

        //第一步：获取集合对象的迭代器对象Iterator
        Iterator it = c.iterator();

        //第二步：通过以上获取的迭代器对象开始遍历/迭代

        /*
        以下两个方法是迭代器对象Iterator中的方法：
            boolean hasNext(); 如果仍有元素可以迭代，则返回true （注意：迭代器it最初并没有指向第一个元素）
            Object next(); 返回迭代的下一个元素
         */

        //while循环开始遍历/迭代
        while (it.hasNext()){
            Object obj = it.next(); //返回迭代的下一个元素
            System.out.println(obj); //取出元素（println默认使用toString方法，并且已经重写）
        }

    }
}
