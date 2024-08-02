package Thread;

/*
    线程让位
 */
public class ThreadTest12 {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable6());
        t.setName("t");
        t.start();
        for (int i = 1; i < 10000 ; i++) {
            System.out.println(Thread.currentThread().getName() + "--->" + i);
        }
    }
}

class  MyRunnable6 implements Runnable{

    @Override
    public void run() {
        for (int i = 1; i < 10000; i++) {
            //每100次让位1次
            if (i % 100 == 0){
                Thread.yield(); //当前线程暂停以下，让给主线程
            }
            System.out.println(Thread.currentThread().getName() + "--->" + i);
        }
    }
}
