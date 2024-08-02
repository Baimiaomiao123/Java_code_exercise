package Thread;

/*
    实现线程的第一种方式：
        编写一个类，直接继承java.lang.Thread，重写run方法
    怎么创建线程对象？怎么启动线程方法

    注意：
        更古不变的原理：
            方法体中的代码总是从上而下依次执行

    以下程序的输出结果有这样的特点：
        有先有后
        有多有少
        这是咋回事？ ——与线程的生命周期有关
 */
public class ThreadTest02 {
    public static void main(String[] args) {
        //这是main方法，这里的代码属于主线程，在主栈中运行
        //创建一个分支线程对象
        MyThread myThread = new MyThread();

        //启动线程
        //start()方法的作用是：启动一个分支线程，在JVM中开辟一个新的栈空间，这段代码任务瞬间就结束了
        //这段代码的任务只是为了开启一个新的栈空间，只要新的栈空间开出来，start()方法就结束了。线程就启动成功了
        //启动成功的线程会自动调用一个run方法，并且run方法在分支栈的栈底部（压栈）
        //run方法在分支栈的栈底部，main方法在主栈的栈底部。run和main是平级的
        //如果直接调用run方法，不用启动线程，不会分配新的分支栈，不能并发，如果调用这个方法就是单线程的
        myThread.start();

        //这里的代码还是运行在主线程中
        for (int i = 0; i <1000 ; i++) {
            System.out.println("主线程--->" + i);
        }
    }
}


class MyThread extends Thread {

    @Override
    public void run() {
        //编写程序，这段程序运行在分支线程中（分支线）
        for (int i = 0; i < 1000; i++) {
            System.out.println("分支线程--->" + i);
        }
    }
}