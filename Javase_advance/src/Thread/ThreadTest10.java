package Thread;

/*
    怎么合理终止一个线程
 */
public class ThreadTest10 {
    public static void main(String[] args) {
        MyRunnable4 r = new MyRunnable4();
        Thread t = new Thread(r);
        t.setName("t");
        t.start();

        //模拟5秒
        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //终止线程
        //什么时候终止t的执行，把标记
        r.run = false;
    }
}

class MyRunnable4 implements Runnable{

    //打一个布尔标记
    boolean run = true;
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (run){
                System.out.println(Thread.currentThread().getName() + "--->" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                //return就结束了，在return之前写一些代码保存就可以了
                //sava.....
                //终止线程
                return;
            }
        }
        
    }
}
