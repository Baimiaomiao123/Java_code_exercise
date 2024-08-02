package Set.Map.HashTable;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/*
    Hashtable的key可以为null吗
        Hashtable的key和value都是不能为null的
        HashMap集合的key和value都是可以为null的

    Hashtable方法都带有synchronized关键字——线程安全的，线程安全有其他的方案代替（因为Hashtable对线程的处理效率比较低，使用较少了）
    Hashtable和HashMap一样，底层都是哈希表数据结构
    Hashtable的初始化容量为11，默认加载因子是0.75
    Hashtable的扩容量：原容量*2+1
 */
public class HashTableTest01 {
    public static void main(String[] args) {
        Map map = new Hashtable();

//        map.put(null,123); //出现java.lang.NullPointerException类型
//        map.put(100,null); //出现java.lang.NullPointerException类型

    }
}
