package Set.Map.TreeSet;

import java.util.TreeSet;

/*
    先按照年龄升序，如果年龄一样，再按照姓名升序
 */
public class TreeSetTest04 {
    public static void main(String[] args) {
        TreeSet<Vip> vips = new TreeSet<>();

        vips.add(new Vip("zhangsan",20));
        vips.add(new Vip("lisi",17));
        vips.add(new Vip("wangwu",20));

        for (Vip vip:
             vips) {
            System.out.println(vip);
        }

    }
}

class Vip implements Comparable<Vip>{
    String name;
    int age;

    public Vip(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Vip{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    /*
        特别注意：
            compareTo放的返回值很重要
                返回0表示相同，value会覆盖
                返回<0表示左边小，往左子树上找【9 - 10 = -1 < 0】
                返回>0表示右边小，往右子树上找【10 - 9 = 1 > 0】
     */
    @Override
    public int compareTo(Vip o) {

        /*
        if (this.age == o.age){
            this.name.compareTo(o.name);
        } else {
            return this.age - o.age;
        }
         */

        //写排序规则，按照什么比较
        return this.age == o.age ?
                this.name.compareTo(o.name) : this.age - o.age;
    }
}