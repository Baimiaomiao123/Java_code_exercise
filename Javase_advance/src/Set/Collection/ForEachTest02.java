package Set.Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
    集合使用foreach循环
 */
public class ForEachTest02 {
    public static void main(String[] args) {
        List<String> strlist = new ArrayList<>();

        strlist.add("hello");
        strlist.add("world");
        strlist.add("kitty");

        //while遍历
        Iterator it = strlist.iterator();
        while (it.hasNext()){
            Object obj = it.next();
            System.out.println(obj);
        }

        System.out.println("===============");

        //使用下标的方法
        for (int i = 0; i < strlist.size(); i++) {
            System.out.println(strlist.get(i));
        }

        System.out.println("================");

        //foreach循环遍历
        for (String s:
            strlist ) {
            System.out.println(s);
        }

    }
}
