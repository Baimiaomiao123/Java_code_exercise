package ThreadSafe.Exam4;

/*
    面试题:doOther的执行需不需要doSome的执行结束？
        答案：需要，因为静态方法是类锁，不管创建了几个对象，类锁只有一把
 */
public class Exam4 {
    public static void main(String[] args) {
        Myclass mc1 = new Myclass();
        Myclass mc2 = new Myclass();

        Thread t1 = new Mythread(mc1);
        Thread t2 = new Mythread(mc2);

        t1.setName("t1");
        t2.setName("t2");

        t1.start();
        try {
            Thread.sleep(1000); //这个睡眠是为了保证t1先执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();

    }
}

class Mythread extends Thread{

    private Myclass mc;

    public Mythread(Myclass mc){
        this.mc = mc;
    }

    @Override
    public void run() {

        if (Thread.currentThread().getName().equals("t1")) {
            mc.doSome();
        }

        if (Thread.currentThread().getName().equals("t2")){
            mc.doOther();
        }

    }
}

class Myclass{
    //synchronized出现在静态方法中，是类锁
    public synchronized static void doSome(){
        System.out.println("doSome begin!");
        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("doSome over!");
    }

    public synchronized static void doOther(){
        System.out.println("doOther begin!");
        System.out.println("doOther over!");
    }
}