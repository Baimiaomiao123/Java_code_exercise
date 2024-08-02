package Exception;
/*
    1.什么是异常类？异常机制有什么用？
        以下程序执行过程中发生了不正常的情况，而这种不正常的情况叫做：异常
        java语言是很完善的语言，提供了异常的处理方式，程序出现异常时候会将异常信息打印输出至控制台
        java程序员看到异常信息之后，可以对程序进行修改，让程序更加完善
    2.以下程序执行控制台出现了：
        Exception in thread "main" java.lang.ArithmeticException: / by zero
	    at Exception.ExceptionTest01.main(ExceptionTest01.java:19)
        这个信息被称为：异常信息，被打印输出至控制台

 */
public class ExceptionTest01 {

    public static void main(String[] args) {
        /*
        int a = 10;
        int b = 0;
        //加入判断语句，程序更加正常
        if (b==0){
            System.out.println("除数不能为0");
            return;
        }
        System.out.println(a/b);
         */

        int a = 10;
        int b = 0;
        int c = a/b; //实际上JVM在执行到此处时，会new异常对象:new ArithmeticException("/ by zero");
        //并且JVM将new异常对象输出，打印信息至控制台
        System.out.println(c);

    }
}
