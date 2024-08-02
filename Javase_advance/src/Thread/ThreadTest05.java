package Thread;

/*
    1、怎么获取当前线程对象？
        Thread t = Thread.currentThread();
        返回值t就是当前线程
    2、获取线程对象的名字
        String name = 线程对象.getName();
        【获取当前线程的名字：Thread.currentThread().getName();】
    3、修改线程对象的名字
        线程对象.setName();
    4、当前线程没有设置名字的时候，默认的名字有什么规律？
        Thread-0
        Thread-1
        Thread-2
        Thread-3
        ...
 */
public class ThreadTest05 {
    public static void main(String[] args) {

        //currentThread就是当前线程对象
        //这个代码出现在main方法中，所以当前线程就是主线程
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getName()); //main
        //创建线程对象
        MyThread2 t1 = new MyThread2();
        MyThread2 t2 = new MyThread2();

        //获取线程名字
        System.out.println(t1.getName()); //0
        System.out.println(t2.getName()); //1

        //修改线程名字
        t1.setName("t1");
        t2.setName("t2");

        //启动线程
        t1.start();
        t2.start();
    }
}

class MyThread2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            //currentThread就是当前线程对象，当前线程是谁呢？
            //当t1线程执行run方法，当前线程就是t1；
            //当t2线程执行run方法，当前线程就是t2；
            Thread currentThread = Thread.currentThread();
            System.out.println(currentThread.getName() + "的分支线程--->" + i);
            //也可以写
//            System.out.println(this.getName() + "的分支线程--->" + i);
//            System.out.println(super.getName() + "的分支线程--->" + i);
        }
    }
}
