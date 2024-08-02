package ControlRight.Test02;

import ControlRight.Test01.User;


public class ControlRightTest02 {

    public static void main(String[] args) {

        //创建user对象
        User user = new User();
        //访问user对象的属性
//        System.out.println(user.id);  该属性不行，因为id为private
//        System.out.println(user.age); //该属性不行，因为age为protected
//        System.out.println(user.name);该属性不行，因为name为defalut

        //weight可以，因为weight是公开的
        System.out.println(user.weight);

    }
}
