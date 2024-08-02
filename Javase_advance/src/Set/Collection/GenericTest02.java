package Set.Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
    JDK之后引入了：自动类型推断机制（又称为钻石表达式）
 */
public class GenericTest02 {
    public static void main(String[] args) {
        //ArrayList<这里的类型会自动推断>
        //自动类型推断，称为钻石表达式（如果版本较低，里面还是需要写在<>里指明类型）
        List<Animal> mylist = new ArrayList<>();

        mylist.add(new Animal());
        mylist.add(new Bird());
        mylist.add(new Cat());

        //遍历
        Iterator<Animal> it = mylist.iterator();
        while (it.hasNext()){
            Animal a = it.next();
            a.move();
            //如果调用子类的特有的方法仍需要向下转型
        }
    }
}
