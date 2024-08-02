package Set.Map;

import java.util.*;

/*
    Map集合的遍历
    第一种方式效率比较低，第二种方式效率比较高。因为获取key和获取value都是直接从对象中获取的属性值，适用于大数据量的数据
 */
public class MapTest02 {
    public static void main(String[] args) {
        //第一种方式：获取所有的key，通过遍历key，来遍历value
        Map<Integer,String> map = new HashMap<>();

        map.put(1,"zhangsan");
        map.put(2,"lisi");
        map.put(3,"wangwu");
        map.put(4,"zhaoliu");

        //遍历map集合
        //获取所有的key
        Set<Integer> keys = map.keySet();
        //遍历key，通过key获取value
        //迭代器
        Iterator<Integer> it = keys.iterator();
        while (it.hasNext()){
            //取出其中一个key
            Integer key = it.next();
            //通过key获取value
            String value = map.get(key);
            //输出
            System.out.println(key + "=" + value);
        }
        System.out.println("===============");
        //foreach
        for (Integer key:
             keys) {
            String value = map.get(key);
            System.out.println(key + "=" + value);
        }


        System.out.println();

        
        //第二种方式：Set<Map.Entry<K,V>> entrySet()
        //以上这个方法是把Map集合全部转换成set集合，Set集合中的元素类型是Map.Entry<K,V>
        Set<Map.Entry<Integer,String>> set = map.entrySet();

        //遍历Set集合，每一次取出一个Node
        //迭代器
        Iterator<Map.Entry<Integer,String>> it2 = set.iterator();
        while(it2.hasNext()){
            Map.Entry<Integer,String> node = it2.next();
            Integer key = node.getKey();
            String value = node.getValue();
            System.out.println(key + "=" + value);
        }

        System.out.println("===============");

        //foreach方法
        for (Map.Entry<Integer,String> node:
             set) {
            System.out.println(node.getKey() + "=" + node.getValue());
        }

    }
}
