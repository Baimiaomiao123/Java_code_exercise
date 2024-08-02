package Set.Map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*
    jav.util.Map接口常用的方法
        1、Map和Collection没有继承关系
        2、Map集合以key和value的方式存储数据：键值对
            key和value都是引用数据类型
            key和value都是存储对象的内存地址
            key起到主导的地位，value是key的一个附属品

       3、Map接口常用的方法：
            V put(K key, V value); 向Map集合中添加键值对
            V get(Object key);  通过key获取value
            void clear();   清空集合
            V remove(Object key);   通过key删除键值对

            boolean containsKey(Object key);    判断Map中是否包含某个key
            boolean containsValue(Object value);    判断Map中是否包含某个value

            int size();     获取Map集合中键值对个数
            boolean isEmpty();  判断Map集合中的元素个数都是为0

            Set<K> keySet();    获取Map集合所有的key（所有的键是一个Set集合）
            Collection<V> values();     获取Map集合中所有的value，返回一个Collection

            Set<Map.Entry<K,V>> entrySet();     将Map集合转换成Set集合
                假设现在有一个Map集合，若下所示
                    map1集合
                    key                 value
                    --------------------------
                    1                   zhangsan
                    2                   lisi
                    3                   wangwu
                    4                   zhaoliu

                    Set set = map1.entrySet();

                    set集合对象 【注意：Map集合通过entrySet()方法转换成的这个Set集合，Set集合中元素类型是Map.Entry<K,V>（静态内部类）】
                    包含两个属性：key,value
                    key  value
                    1 zhangsan  【Map.Entry和String一样，都是一种类型的名字，只不过：Map.Entry是静态内部类，是Map中的静态内部类】
                    2 lisi
                    3 wnagwu
                    4 zhaoliu

                    如果要获取key和value需要调用getKey和getValue方法得到属性值
 */
public class MapTest01 {
    public static void main(String[] args) {
        //创建Map集合对象
        Map<Integer,String> map = new HashMap<>();

        //向Map集合添加键值对
        map.put(1,"zhangsan");
        map.put(2,"lisi");
        map.put(3,"wangwu");
        map.put(4,"zhaoliu");

        //通过key获取value
        System.out.println(map.get(1)); //zhangsan
        System.out.println(map.get(2)); //lisi

        //获取键值对的数量
        System.out.println(map.size()); //4

        //通过key删除key-value
        map.remove(2);
        System.out.println(map.size()); //3


        //判断是否包含某个key
        //contains方法底层调用的都是equals方法进行比对的，所以自定义的类型都是需要重写equals方法
        System.out.println(map.containsKey(4)); //true
        System.out.println(map.containsKey(2)); //false

        //判断是否包含某个value
        //contains方法底层调用的都是equals方法进行比对的，所以自定义的类型都是需要重写equals方法
        System.out.println(map.containsValue("zhangsan")); //true
        System.out.println(map.containsValue("lisi")); //false

        //获取所有的value
        Collection<String> values = map.values();
        for (String s:
             values) {
            System.out.println(s);
        }  //zhangsan wangwu zhaoliu

        //判断是否为空
        System.out.println(map.isEmpty()); //false

        //清空集合
        map.clear();
        System.out.println(map.isEmpty()); //true



    }
}
