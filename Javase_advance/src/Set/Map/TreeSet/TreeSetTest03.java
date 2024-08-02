package Set.Map.TreeSet;

import java.util.TreeSet;

public class TreeSetTest03 {
    public static void main(String[] args) {
        Customer c1 = new Customer(11);
        Customer c2 = new Customer(22);
        Customer c3 = new Customer(33);
        Customer c4 = new Customer(44);
        Customer c5 = new Customer(55);

        TreeSet<Customer> Customers = new TreeSet<>();
        Customers.add(c1);
        Customers.add(c2);
        Customers.add(c3);
        Customers.add(c4);
        Customers.add(c5);

        //遍历
        for (Customer c :
                Customers) {
            System.out.println(c.toString());
        }

    }
}


//放在TreeSet集合中的元素需要实现java.lang.Comparable接口
//并且实现compareTo方法,equals可以不写
class Customer implements Comparable<Customer>{
    int age;

    public Customer(int age){
        this.age = age;
    }

    @Override
    //重写toString()方法
    public String toString(){

        return "Customer[age=" + age + "]";
    }

    @Override
    //重写compareTo()方法
    //需要在这个方法中编写比较的逻辑或者规则，按照什么进行比较？
    //k.compareTo(t.key)
    //拿着参数k和集合中每一个k进行比较，返回值可能<0 =0 >0
    public int compareTo(Customer c) {  //c1.compareTo(c2)
        // this是c1
        // c是c2
        // c1和c2比较的时候，就是this和c进行比较
        /*
        int age1 = this.age;
        int age2 = c.age;
        if (age1 == age2) {
            return 0;
        } else if (age1 > age2) {
            return 1;
        } else {
            return -1;
        }
         */
//        return c.age - this.age; //降序
        return this.age - c.age;
    }
}
