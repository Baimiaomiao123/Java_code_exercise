package Set;
/*
    集合概述：
        1.什么是集合？有什么用？
            数组其实就是一个集合。集合实际上就是一个容器，可以容器其他类型的数据
            集合为什么在开发中使用较多？
                集合是一个容器，是一个载体，可以一次容纳多个对象
                实际开发中，假设连接数据库，数据库当中有10条记录
                那么假设把这10条记录查询出来，java程序中会将10条
                数据封装成10个java对象，然后将10个java对象放到某一个集合当中，将集合传到前端，然后遍历集合
                将数据一个一个展现出来

        2.集合不能直接存储基本数据类型，另外集合也不能直接存储java对象
        集合当中存储的都是java对象的内存地址（或者说集合中存储的是引用）
            list.add(100); //自动装箱，将100变成Integer(100)
            集合在java中本身是一个容器，也是一个对象
            集合中任何时候存储的都是"引用"
            集合中可以放集合（集合也是一个引用）

        3.在java中每一个不同的集合，底层会对应不同的数据结构
        往不同的集合中存储元素，等于将数据放到了不同的数据结构当中
            什么是数据结构？
            数据存储的结构就是数据结构。不同的数据结构，数据存储方式不同，例如：数组、二叉树、链表、哈希表...
            使用不同的集合等同于使用不同的数据结构
            new ArrayList();    创建一个集合，底层是数组
            new LinkedList();   创建一个集合，底层是链表
            new TreeSet();      创建一个集合，底层是二叉树
            java中已经将数据结构实现了，已经写好了这些常用的集合类，只需要掌握什么时候用？什么情况选择哪一种合适的集合去使用

        4.集合在java JDK中哪个包下？
            java.util.*
            所有的集合类和集合接口都在java.util包下

        5.集合的继承图，见UML图
            总结（所有的实现类）：
                ArrayList:底层是数组
                LinkedList:底层是双向链表
                Vector:底层是数组，线程安全，效率较低，使用较少
                HashSet:底层是HashMap，放到HashSet集合中的元素等同于放到HashMap集合key部分
                TreeSet:底层是TreeMap，放到TreeSet集合中的元素等同于放到TreeMap集合key部分
                HashMap:底层是哈希表
                Hashtable:底层是哈希表，线程安全，效率较低，使用较少
                Properties:是属性类，线程安全，并且key和value只能存储字符串String
                TreeMap:底层是二叉树，TreeMap的key可以自动按照大小顺序排序

                List集合存储元素的特点：
                    有序可重复
                        有序——存进去的顺序和取出的顺序相同，每一个元素都有下标
                        可重复——存进去一个1，可以再存一个1

                Set集合存储元素的特点：
                    无序不可重复
                        无序——存进去的顺序和取出的顺序不一定相同。另外Set集合中元素没有下标
                        不可重复——存进去一个1，不可以再存一个1

                SortedSet（SortedMap）集合存储元素的特点：
                    首先是无序不可重复的，但是集合中的元素是可排序的
                        无序——存进去的顺序和取出的顺序不一定相同。另外Set集合中元素没有下标
                        不可重复——存进去一个1，不可以再存一个1
                        可排序的——可以按照大小顺序排列

                Map集合的key，就是一个Set集合
                往Set集合中放数据，实际上放到了Map集合的key

        6.在java中集合分为两大类：
            一类是单个方式储存元素：
                这一类集合中超级父接口：java.util.Collection;
            一类是以键值对的方式存储元素：
                这一类集合中超级父接口：java.util.Map;
            Iterator it = "collection 对象".iterator(); //collection继承了iterable，可以调用iterable中的iterator方法
            it就是迭代器对象

       重点总结：
        1、集合继承结构图背会
        2、把Collection接口中常用方法测试几遍
        3、把迭代器弄明白
        4、Collection接口中的remove方法和contains方法底层都会调用equals方法
 */
public class Summary {
    public static void main(String[] args) {

    }
}
