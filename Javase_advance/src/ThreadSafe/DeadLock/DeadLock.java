package ThreadSafe.DeadLock;

/*
    死锁代码需要会写
    一般面试官要求会写
    只有会写的，才会在以后的工作中注意
    因为死锁很难调试
 */
public class DeadLock {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();

        //t1,t2两个线程共享o1,o2
        Thread t1 = new MyThread1(o1,o2);
        Thread t2 = new MyThread2(o1,o2);

        t1.setName("t1");
        t2.setName("t2");

        t1.start();
        t2.start();
    }
}

class MyThread1 extends Thread{
    Object o1;
    Object o2;

    public MyThread1(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }


    @Override
    public void run() {
        synchronized (o1){

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (o2){

            }
        }
    }
}

class MyThread2 extends Thread{
    Object o1;
    Object o2;

    public MyThread2(Object o1,Object o2){
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        synchronized (o2){

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (o1){

            }
        }
    }
}