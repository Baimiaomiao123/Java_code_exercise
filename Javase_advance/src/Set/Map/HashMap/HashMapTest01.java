package Set.Map.HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
    HashMap集合：
        1、HashMap集合底层是哈希表/散列表的数据结构
        2、哈希表是一个怎么样的数据结构
            哈希表是一个数组和单项链表的结合体
            数组：在查询方面效率很高，随机增删方面效率很低
            单向链表：在随机增删方面效率很高，在查询方面效率很低
            哈希表将以上的两种数据结构融合在一起，充分发挥它们各自的优点
        3、哈希表可以类比门帘，HashMap集合底层的源代码：
        public class HashMap{

            //HashMap底层实际是一个数组（一维数组）
            Node<K,V>[] table;

            //静态内部类HashMap.Node
            static class Node<K,V> implements Map.Entry<K,V>{
                final int hash; //  哈希值（哈希值是key的hashCode()方法的执行结果。hash值通过哈希函数/算法，可以转换存储成数组的下标）
                final K key;    //  存储到Map集合中的那个key
                V value;        //  存储到Map集合中的那个value
                Node<K,V> next; //  下一个节点的内存地址
            }
        }
        4、最主要掌握：map,put(k,v)和v=map.get(k)
        5、HashMap集合的key部分特点：
            无序，不可重复
            无序——添加元素和取出的元素顺序不一致（因为不一定挂到相同的单向链表上）
            不可重复——里面的元素不可重复（因为equals方法来保证HashMap集合的key不可重复，如果key重复，value会覆盖）

        放在HashMap集合key部分的元素其实就是放到HashSet集合中了
        所以HashSet集合中的元素也需要同时重写hashCode()+equals()方法
        6、哈希表HashMap使用不当时无法发挥性能

            假设所有的hashCode()方法返回的是一个固定值，那么会导致底层哈希表变成了
            纯单向链表。这个情况我们称为：散列分布不均匀

            假设所有的hashCode()方法返回的都是不一样的值，那么会导致底层哈希表变成了
            纯数组。这个情况我们也称为：散列分布不均匀

            散列分布均匀：假设100个元素，10个单向链表，那么每个单向链表上有10个节点，这是最佳状态（需要重写好hashCode()）
        7、重点：放在HashMap集合key部分的元素，以及放在HashSet集合中的元素，需要同时重写hashCode和equals方法
        8、HashMap集合的默认初始化容量是16，默认加载因子是0.75
            这个默认加载因子是当HashMap集合底层数组的容量达到75%的时候，数组开始扩容
            重点，记住——HashMap集合初始化容量必须是2的倍数，这也是官方推荐的
            这是因为达到散列分布均匀，为了提高HashMap集合的存取效率所必须的
        9、
 */
public class HashMapTest01 {
    public static void main(String[] args) {
        //测试HashMap集合中元素的特点
        //Integer是key，它的hashCode方法和equals方法都以及重写了
        Map<Integer,String> map = new HashMap<>();
        map.put(1111,"zhangshan");
        map.put(6666,"lisi");
        map.put(7777,"wangwu");
        map.put(2222,"zhaoliu");
        map.put(2222,"king");

        System.out.println(map.size());

        //遍历集合
        Set<Map.Entry<Integer,String>> set = map.entrySet();
        for (Map.Entry<Integer,String> entry:
             set) {
            //验证结果：无序不可重复
            System.out.println(entry.getKey()+"="+entry.getValue());
        }


    }
}

/*
    map.put(K,V)实现原理：
        第一步：先把k，v封装到Node对象当中
        第二步：底层会调用k的hashCode()方法得出hash值，然后通过哈希函数/哈希算法，
        将hash值转换成数组的下标，下标位置上如果没有任何元素，就把Node添加到这个位置上。
        如果下标对应的位置上有链表，此时会拿着k和链表上每一个节点的k进行equals，如果所有的equals
        方法返回都是false，那么这个新节点将会被添加到链表的末尾；如果其中有一个euals返回了true，
        那么这个节点的value将会被覆盖

    同理：
    map.get(key)实现原理：
        先调用k的hashCode()方法得出hash值，通过哈希算法转换成数组下标，通过数组下标快速定位到某个位置上，
        如果这个位置上什么也没有，返回null；如果这个位置上有单向链表，那么会拿着参数k和单向链表上的每个节点中的key
        进行equals，如果所有equals方法返回false，那么get方法返回null，只要其中有一个节点的k和参数k的equals的时候
        返回true，那么此时这个节点的value就是我们要找的value，get方法最终返回这个要找的value

    注意：同一个单向链表上所有节点的hash值相同，因为它们的数组下标是一样的，但同一个链表上的k和k的equals方法肯定返回的是false，都不想等
    重点：通过以上原理，得出HashMap的key,会先后调用两个方法，一个方法是hashCode()，一个方法是equals()，那么这两个方法都需要重写

 */

/*
    哈希函数的特点：
        1）确定性
        2）不可逆（单向）
        3）分散性（敏感性）
        4）压缩性
 */
