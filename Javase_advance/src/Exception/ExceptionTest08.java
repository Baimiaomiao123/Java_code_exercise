package Exception;
/*
    异常对象有两个非常重要的方法
        String msg = exception.getMessage(); 获取异常简单的信息描述
        exception.printStackTrace(); 打印异常追踪的堆栈信息

 */
public class ExceptionTest08 {

    public static void main(String[] args) {
        //这里只是为了测试getMessage()方法和printStackTrace()方法
        //这里只是new了异常对象，但是没有将异常对象抛出，JVM只会认为这只是一个普通的java对象
        NullPointerException npe = new NullPointerException("空指针异常");

        //获取异常简单概述信息：这个信息实际上就是构造方法上面的String参数
        System.out.println(npe.getMessage());

        //打印异常堆栈信息
        //java后台打印异常堆栈追踪信息的时候，采用了异步线程的方法打印
        npe.printStackTrace();
        System.out.println("Hello World!");
    }
}
