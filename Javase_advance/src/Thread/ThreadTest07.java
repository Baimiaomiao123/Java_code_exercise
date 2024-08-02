package Thread;

/*
    关于Thread.sleep()方法的一个面试题
 */
public class ThreadTest07 {
    public static void main(String[] args) {
        MyThread3 t = new MyThread3();
        t.setName("t");
        t.start();

        ////调用sleep方法
        try {
            //问题：这行代码会让线程t进入休眠状态吗？
            //不会，因为这个线程是主线程，Thread.sleep实际上是让主方法休眠5秒
            t.sleep(1000 * 5); //由于sleep方法是静态方法，
                                     //这里实际上代码还是Thread.sleep(1000 * 5);
                                     //由于实在main方法中写的sleep方法，所以是让主方法休眠5秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //5秒之后，才会睡眠
        System.out.println("Hello World!");
    }
}

class MyThread3 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName() + "--->" + i);
        }
    }
}
