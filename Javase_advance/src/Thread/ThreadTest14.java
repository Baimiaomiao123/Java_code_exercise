package Thread;

/*
    守护线程
 */
public class ThreadTest14 {
    public static void main(String[] args) {
        Thread t = new BakDataThread();
        t.setName("备份数据的线程");
        //启动线程之前，将线程设置为守护线程(如果没有设置守护线程，该线程还是一个用户线程，里面的程序会一直执行下去直到完成)
        t.setDaemon(true);
        t.start();
        
        //主线程：主线程是用户线程
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "--->" + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class BakDataThread extends Thread{
    @Override
    public void run() {
        int i = 0;
        //死循环
        while (true){
            System.out.println(Thread.currentThread().getName() + "--->" + (++i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
