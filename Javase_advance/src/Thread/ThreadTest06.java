package Thread;

/*
    关于线程的sleep方法
        static void sleep(long millis)
        1、静态方法：Thread.sleep(1000)
        2、参数是毫秒
        3、作用：让当前线程进入进入休眠，进入"阻塞状态"。放弃占有CPU时间片，让给其它线程使用
            这行代码出现在A线程，A线程会进入休眠
            这行代码出现在B线程，B线程会进入休眠
 */
public class ThreadTest06 {
    public static void main(String[] args) {
        //让当前线程进入休眠，睡眠5秒
        //这里线程是主线程！！！
        /*
        try {
            Thread.sleep(1000*5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         */

        //五秒钟之后才会执行该程序
        System.out.println("Hello world!");

        for (int i = 0; i < 10; i++) {
            //当前方法是main方法中，所以Thread.currentThread.getName是main
            System.out.println(Thread.currentThread().getName() + "--->" + i);

            //睡眠一秒
            try {
                Thread.sleep(1000); //在哪个线程中调用，就会使哪个线程进入"阻塞状态"
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
