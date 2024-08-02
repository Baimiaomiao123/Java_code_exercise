package Set.Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/*
    测试contains方法
    结论：存放在集合中的类型一定要重写equals方法
 */
public class CollectionTest05 {
    public static void main(String[] args) {
        //创建集合对象
        Collection c = new ArrayList();
        //创建用户对象
        User u1 = new User("jack");
        User u2 = new User("jack");

        //加入集合
        c.add(u1);

        //判断集合中是否包含u2
        System.out.println(c.contains(u2)); //如果没有重写equals方法（默认用==进行比较），false；但是重写equals方法就是true

        //底层代码实际上比较是的c(u1).equals(u2)，默认比较的是地址，重写之后才是比较的内容

        //remove方法呢？ 同样如果也是重写了equals方法比较的是内容，就能够删除
        c.remove(u2);
        System.out.println(c.size());

        System.out.println("==========");

        Collection cc = new ArrayList();
        String s1 = new String("Hello");
        cc.add(s1);
        String s2 = new String("Hello");
        cc.remove(s2);
        System.out.println(cc.size()); //0


    }
}

class User{
    private String name;
    public User(){}
    public User(String name){
        this.name = name;
    }

    //重写equals方法
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        //不再比较对象的内存地址，而是比较对象的name是否相同
        return Objects.equals(name, user.name);
    }

}