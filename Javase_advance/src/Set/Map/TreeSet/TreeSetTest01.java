package Set.Map.TreeSet;

import java.util.TreeSet;

/*
    1、TreeSet集合底层实际上是一个TreeMap
    2、TreeMap集合是一个二叉树
    3、放到TreeSet集合中的元素，等同于放到TreeMap集合的key部分了
    4、TreeSet集合中的元素：无序不可重复，但是可以按照元素的大小顺序自动排序——称为可排序集合

 */
public class TreeSetTest01 {
    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<>();

        //添加
        ts.add("zhangsan");
        ts.add("lisi");
        ts.add("wangwu");
        ts.add("zhangsi");
        ts.add("wangliu");

        //遍历
        for (String s:
             ts) {
            System.out.println(s); //会按照字段顺序排序——升序
        }

        TreeSet<Integer> ts2 = new TreeSet<>();

        //添加
        ts2.add(100);
        ts2.add(999);
        ts2.add(1);
        ts2.add(545);
        ts2.add(444);

        //遍历
        for (Integer it:
             ts2) {
            System.out.println(it); //同样会按照数字的大小进行排序——升序
        }
    }
}

/*
    数据库中有很多数据：
        userid  name        birth
        ------------------------------
        1       zs          1980-11-11
        2       ls          1999-05-19
        3       ww          1987-04-07
        4       zl          1990-01-01

        编写这个程序从数据库当中取出数据，在页面展示用户信息的时候按照生日升序或降序
        这个时候就可以使用TreeSet集合，因为TreeSet集合放进去，拿出来就是有顺序的
 */