package Set.Collection.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
    测试List接口中的常用方法
        1、List集合存储元素特点：有序可重复
            有序：List集合中的元素有下标，从0开始，以1递增
            可重复：存储一个1，还可以再存储一个1

        2、List是Collection的子接口，Collection中的方法List也会有。List接口特有的方法：
            void add(int index, E element);
            E get(int index);
            int indexOf(Object o);
            int lastIndexOf(Object);
            E remove(int index);
            E set(int index, E element);


        3、

 */
public class ListTest01 {
    public static void main(String[] args) {
        //创建List类型的集合
        //List myList = new LinkedList();
        //List myList = new Vector();
        List myList =  new ArrayList();

        //添加元素
        myList.add("a"); //默认都是向集合末位添加元素
        myList.add("b");
        myList.add("c");
        myList.add("d");
        myList.add("a");

        //在列表的指定位置插入指定元素（第一个参数是下标）
        //这个方法使用不多，效率较低
        myList.add(1,"King");

        //迭代
        Iterator it = myList.iterator();
        while (it.hasNext()){
            Object elt = it.next();
            System.out.println(elt);
        }

        //根据下标获取元素
        System.out.println("获取myList的第一个元素为"+myList.get(0)); //a

        //因为有下标，所以List集合有自己比较特殊的遍历方式
        //通过下标遍历。【List集合特有的方法，Set没有】
        for (int i = 0; i < myList.size(); i++) {
            Object obj = myList.get(i);
            System.out.println(obj);
        }

        //获取指定对象第一次出现的索引
        System.out.println(myList.indexOf("a")); //0

        //获取指定对象最后一次出现的索引
        System.out.println(myList.lastIndexOf("a")); //5

        //修改指定元素
        myList.set(1,"queen");



    }

}

/*
    附注：计算机常用关系术语
        增：add save new
        删：delete drop remove
        改：update set modify
        查：find get query select
 */
