package Constructor.example01;

public class User {

    //无参数的构造方法
    public User(){
        System.out.println("不带有int类型的构造器");
        System.out.println("User's default constructor");
    }

    //有参数的构造方法
    public User(int i){
        System.out.println("带有int类型的构造器");
        System.out.println("User's default constructor presents " + i);
    }
}
