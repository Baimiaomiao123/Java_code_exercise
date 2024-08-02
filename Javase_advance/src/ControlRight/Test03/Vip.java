package ControlRight.Test03;

import ControlRight.Test01.User;

public class Vip extends User {

    //实例方法
    public void shopping(){
        System.out.println(this.age); //age是受保护的，如果在其他包调用的话需要继承所需要使用的类所在的包
//        编译无法通过，因为name是默认的，默认表示只在本类或同包下才能访问，就算继承了也无法访问
//        System.out.println(this.name); //name在ControlRightTest.Test01.User中不是公共的; 无法从外部程序包中对其进行访问
        System.out.println(this.weight); //weight是公开的，随便都可以访问
    }

    public static void main(String[] args) {
        User user = new Vip();
        Vip user1 = (Vip) user;
        user1.shopping();
    }

}
