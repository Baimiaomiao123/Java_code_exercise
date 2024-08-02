package Set;



import java.util.*;

/*
    java.util.Collection——集合接口
    java.util.Collections——集合工具类，方便集合的操作
 */
public class CollectionsTest {
    public static void main(String[] args) {
        //ArrayList集合是非线程安全的
        List<String> list = new ArrayList<>();

        //变成线程安全的
        Collections.synchronizedList(list);

        //排序
        list.add("abf");
        list.add("abx");
        list.add("abc");
        list.add("abe");
        
        //使用集合工具进行排序
        Collections.sort(list);
        for (String s:
             list) {
            System.out.println(s);
        }

        System.out.println("===============");

        List<Turtle> turtles = new ArrayList<>();
        turtles.add(new Turtle(100));
        turtles.add(new Turtle(200));
        turtles.add(new Turtle(500));
        //注意：对list集合中元素排序，需要保证集合中的元素实现了comparable接口
        Collections.sort(turtles);

        for (Turtle t:
             turtles) {
            System.out.println(t);
        }


        System.out.println("=================");

        //对Set集合怎么排序呢？
        Set<String> set = new HashSet<>();
        set.add("king");
        set.add("kingsoft");
        set.add("king2");
        set.add("king1");

        //由于Collections.sort()里面的参数只能是list集合，所以需要先将Set集合转换成List集合，然后在进行转换
        List<String> mylist = new ArrayList<>(set);
        Collections.sort(mylist);
        for (String s:
             mylist) {
            System.out.println(s);
        }

        //这种方式也可以排序
        //Collections.sort(list集合，比较器对象)
    }
}

class Turtle implements Comparable<Turtle>{
    int age;
    public Turtle(int age){
        this.age = age;
    }

    @Override
    public String toString(){
        return "小乌龟[" +
                "age=" + age +
                "]";
    }

    @Override
    public int compareTo(Turtle t) {
        return this.age - t.age;
    }
}




