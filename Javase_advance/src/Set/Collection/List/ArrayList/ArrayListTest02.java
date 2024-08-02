package Set.Collection.List.ArrayList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/*
    集合ArrayList的构造方法
 */
public class ArrayListTest02 {
    public static void main(String[] args) {
        // 无参构造
        List mylist1 = new ArrayList();
        // 有参构造，出指定初始化容量为100
        List mylist2 = new ArrayList(100);

        //创建一个HashSet集合
        Collection c = new HashSet();
        c.add(100);
        c.add(200);
        c.add(900);
        c.add(50);

        //通过这个构造方法就可以将HashSet集合转换成List集合
        List mylist3 = new ArrayList(c);
        for (int i = 0; i < mylist3.size(); i++) {
            System.out.println(mylist3.get(i));
        }
    }
}
