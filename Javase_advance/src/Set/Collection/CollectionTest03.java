package Set.Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/*
    关于集合的遍历/迭代
 */
public class CollectionTest03 {
    public static void main(String[] args) {
        //创建集合对象
        Collection c1 = new ArrayList();  //ArrayList集合：有序可重复

        //添加元素
        c1.add(1);
        c1.add(2);
        c1.add(3);
        c1.add(4);
        c1.add(1);

        //迭代集合
        Iterator it = c1.iterator();
        while (it.hasNext()){
//            System.out.println(it.next());

            // 存进去是什么类型，取出来还是什么类型，只不过在用println输出时是字符串类型（因为默认调用了toString方法）
            Object obj = it.next();
            /*if (obj instanceof Integer){
                System.out.println("Integer类型");
            }
             */
            System.out.println(obj);
        }

        //HashSet集合：无序不可重复 无序——存进去和取出去的顺序不一定相同，不可重复——不可以存进去相同的元素，不会报错
        Collection c2 = new HashSet();

        c2.add(100);
        c2.add(200);
        c2.add(300);
        c2.add(400);
        c2.add(500);
        c2.add(600);
        c2.add(100);

        Iterator it2 = c2.iterator();
        while (it2.hasNext()){
            System.out.println(it2.next()); //这里就只输出了
        }
    }
}
