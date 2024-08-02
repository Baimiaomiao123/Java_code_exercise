package Exception;
/*
    以下代码报错的原因？
        因为doSome方法声明位置上使用了ClassNotFoundException
        而ClassNotFoundException属于编译时异常，必须预先处理，没有处理编译器就会报错
 */
public class ExceptionTest04 {

    public static void main(String[] args) {
        //调用doSome();
        //Unhandled exception: java.lang.ClassNotFoundException
//        doSome();
    }

    /*
    doSome方法声明了ClassNotFoundException，这表明这个方法执行中可能会遇到ClassNotFoundException异常
    叫做类没找到异常，这个异常的父类是Exception，所以ClassNotFoundException属于编译异常
     */
    public static void doSome() throws ClassNotFoundException{
        System.out.println("doSome");
    }
}
