package Thread;

/*
    线程合并
 */
public class ThreadTest13 {
    public static void main(String[] args) {
        System.out.println("main begin!");

        Thread t = new Thread(new MyRunnable7());
        t.setName("t");
        t.start();

        //合并线程
        try {
            t.join(); //t合并到当前线程用，当前线程受阻，t线程执行直到结束
                      //这里是让main线程暂停，让t线程run方法执行完成之后，才会继续执行main线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main over!");
    }
}

class MyRunnable7 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName() + "--->" + i);
        }
    }
}
