package Set.Collection;

import java.util.HashSet;
import java.util.Set;

/*
    HashSet：无序不可重复
 */
public class HashSetTest {
    public static void main(String[] args) {
        //演示特点
        Set<String> strs = new HashSet<>();

        strs.add("hello1");
        strs.add("hello3");
        strs.add("hello4");
        strs.add("hello2");
        strs.add("hello5");
        strs.add("hello1");
        strs.add("hello1");
        strs.add("hello1");
        strs.add("hello1");

        for (String s:
             strs) {
            System.out.println(s);
        }

    }
}
