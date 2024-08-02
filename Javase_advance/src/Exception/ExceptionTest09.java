package Exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/*
    异常对象的两个方法
        String msg = exception.getMessage();
        exception.printStackTrace();

    以后查看异常的追踪信息，应该怎么看来调试信息？
        异常信息追踪信息，从上往下一行一行看
        但是SUN写的代码就不用看了（看包名），一般问题都是出在自己
 */
public class ExceptionTest09 {

    public static void main(String[] args) {
        try {
            m1();
        } catch (FileNotFoundException e) {
            //打印异常堆栈追踪信息！！
            //在实际的开发中，建议使用这个！
            //这行代码应该写上，不然出问题你不知道！
            e.printStackTrace();
            /*
            java.io.FileNotFoundException: adsfa (No such file or directory)
	            at java.base/java.io.FileInputStream.open0(Native Method)
	            at java.base/java.io.FileInputStream.open(FileInputStream.java:219)
	            at java.base/java.io.FileInputStream.<init>(FileInputStream.java:157)
	            at java.base/java.io.FileInputStream.<init>(FileInputStream.java:112)
	            at Exception.ExceptionTest09.m3(ExceptionTest09.java:37)
	            at Exception.ExceptionTest09.m2(ExceptionTest09.java:33)
	            at Exception.ExceptionTest09.m1(ExceptionTest09.java:29)
	            at Exception.ExceptionTest09.main(ExceptionTest09.java:17)

	            解读：37行的错误引起33行的错误，33行的错误引起29行的错误，29行的错误引起17行的错误
             */
        }

        //这里程序会继续执行，因为已经用try..catch捕捉了异常信息
        System.out.println("Hello World!");
    }

    private static void m1() throws FileNotFoundException {
        m2();
    }

    private static void m2() throws FileNotFoundException {
        m3();
    }

    private static void m3() throws FileNotFoundException {
        new FileInputStream("adsfa");
    }
}
