package Thread;

public class ThreadTest03 {
    public static void main(String[] args) {
        //创建一个可运行的对象
//        MyRunnable r = new MyRunnable();
        //将可运行的对象封装成一个线程对象
//        Thread t = new Thread(r);

        //合并代码
        Thread t = new Thread(new MyRunnable());

        t.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("主线程--->" + i);
        }
    }
}


//这并不是一个线程类，是一个可运行的类。它还不是一个线程。
//需要将它封装成一个线程类，就需要可运行的类对象创建出来，再把这个对象传到线程类里
class MyRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("分支线程--->" + i);
        }
    }
}
