package ThreadSafe.Test2;

public class ThreadSafeTest02 {
    public static void main(String[] args) {
        //创建账户对象
        Account act = new Account("act-001",10000);

        //创建两个线程
        Thread t1 = new AccountThread(act);
        Thread t2 = new AccountThread(act);

        //设置name
        t1.setName("t1");
        t2.setName("t2");

        //开启支线程
        t1.start();
        t2.start();


    }
}
