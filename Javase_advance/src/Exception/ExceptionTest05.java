package Exception;

/*
    Test04报错怎么处理？
 */
public class ExceptionTest05 {

//    //第一种：方法声明——异常上抛
//    //上抛类似于推卸责任，继续把异常传递给调用者，调用者知道
//    public static void main(String[] args) throws ClassNotFoundException {
//        //调用doSome();
//        //Unhandled exception: java.lang.ClassNotFoundException
//
//        doSome();
//    }

    //第二种：try..catch——异常捕捉
    //推卸等于把异常拦下来了，异常真正的解决了，调用者不知道
    public static void main(String[] args) {
        try {
            doSome();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    /*
    doSome方法声明了ClassNotFoundException，这表明这个方法执行中可能会遇到ClassNotFoundException异常
    叫做类没找到异常，这个异常的父类是Exception，所以ClassNotFoundException属于编译异常
     */
    public static void doSome() throws ClassNotFoundException{
        System.out.println("doSome");
    }
}