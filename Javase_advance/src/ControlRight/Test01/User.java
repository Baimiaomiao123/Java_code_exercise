package ControlRight.Test01;

public class User {
    //给一些属性
    //私有的
    private int id;
    //受保护的
    protected int age;
    //公开的
    public int weight;
    //默认的
    String name;

    public static void main(String[] args) {
        User user = new User();
        System.out.println(user.id);
    }
}

