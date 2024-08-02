package Thread;

/*
    了解：关于线程的优先级

 */
public class ThreadTest11 {
    public static void main(String[] args) {
//        System.out.println("最高优先级："+Thread.MAX_PRIORITY); //10
//        System.out.println("最低优先级：" + Thread.MIN_PRIORITY); //1
//        System.out.println("默认优先级：" + Thread.NORM_PRIORITY); //5
        //main线程的默认优先级为：5

        Thread currentThread = Thread.currentThread();
        currentThread.setPriority(1);
        System.out.println(currentThread.getName() + "线程的默认优先级为：" + currentThread.getPriority());
        Thread t = new Thread(new MyRunnable5());
        t.setName("t");
        t.setPriority(10);
        t.start();
        //想要多线程执行，注意一定要把想要运行的程序放在t.start()方法后面
        for (int i = 0; i < 10000; i++) {
            System.out.println(currentThread.getName() + "--->" + i);
        }

        //优先级较高的只是抢到CPU时间片相对多一些，并不代表优先级高的一定会先运行，并不是绝对的

    }
}

class MyRunnable5 implements Runnable{
    @Override
    public void run() {
        //获取线程的优先级
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getName() +"线程的默认优先级为：" + currentThread.getPriority()); //5
        for (int i = 0; i < 10000; i++) {
            System.out.println(currentThread.getName() + "--->" + i);
        }
    }
}
