package ObjectMethod;

import java.util.Objects;

public class ObjectMethodTest05 {

    public static void main(String[] args) {

        User u1 = new User("白喵喵",new Address("重庆","渝中区","404000"));
        User u2 = new User("白喵喵",new Address("重庆","渝中区","404000"));
        User u3 = new User("白喵喵",new Address("重庆","渝北区","404000"));

        System.out.println(u1.equals(u2)); //true
        System.out.println(u1.equals(u3)); //false


    }
}

class User{
    String name;
    Address addr;

    public User() {
    }

    public User(String name, Address addr) {
        this.name = name;
        this.addr = addr;
    }

    //重写equals方法
    //重写规则：当一个用户的name和addr都相同是，表示用一个用户

    @Override
    public boolean equals(Object obj) {
        //name和name相同，addr和addr相同时，认定为同一个用户
        if (obj == null || !(obj instanceof User)) return false;
        if(obj == this) return true;

        User u = (User) obj;
        if (this.name.equals(u.name) && this.addr.equals(u.addr)){
            return true;
        }


        return false;
    }
}

class Address{
    String city;
    String street;
    String zipcode;

    public Address(){

    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    //注意：如果没有重写equals方法
    //那么这里判断两个addr对象的时候比较的是两个对象的内存地址，而不是两个对象里面存储的内容
    //如果这里不重写，那么上面if (this.name.equals(u.name) && this.addr.equals(u.addr))中，this.addr.equals(u.addr)
    //默认比较的是两个addr的内存地址，一定是false，那么返回值一定是false，导致重写User的equals()方法失败
    //所以一定要在addr中重写equals()方法，才能满足User重写equals()方法的需求

    //重写Address的equals()方法【直接生成】
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(city, address.city) && Objects.equals(street, address.street) && Objects.equals(zipcode, address.zipcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, zipcode);
    }
}