package Exception;
/*
    SUN提供的JDK内置的异常肯定是不够用的，在实际开发中，有很多业务
    这些业务出现异常之后，JDK中都是没有的。和业务挂钩的。
    异常类可以程序员自己定义

    Java中怎么自定义异常呢？
    两步：
        第一步：编写一个类继承Exception或者RuntimeException
        第二步：提供两个构造方法，一个无参数，一个有参数
 */
public class MyException extends Exception { //编译时异常
    public MyException() {
    }

    public MyException(String s){
        super(s);
    }
}
