package Set.Collection;

import java.util.Set;
import java.util.TreeSet;

/*
    TreeSet存储元素的特点：
        无序不可重复，但是存储的元素可以自动按照大小顺序排序
        称为可排序集合

        无序——存进去的元素和取出来的顺序不同，并且没有下标
 */
public class TreeSetTest {
    public static void main(String[] args) {
        Set<String> strs = new TreeSet<>();

        strs.add("A");
        strs.add("V");
        strs.add("X");
        strs.add("A");
        strs.add("C");
        strs.add("F");
        strs.add("G");

        for (String s:
             strs) {
            System.out.println(s);  //会从小到大自动排序
        }

    }
}
