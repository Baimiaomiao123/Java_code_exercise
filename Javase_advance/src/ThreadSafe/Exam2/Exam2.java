package ThreadSafe.Exam2;

/*
    面试题:doOther的执行需不需要doSome的执行结束？
        答案：需要，因为doOther方法有synchronized关键字修饰
 */
public class Exam2 {
    public static void main(String[] args) {
        Myclass mc = new Myclass();

        Thread t1 = new Mythread(mc);
        Thread t2 = new Mythread(mc);

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
    public synchronized void doSome(){
        System.out.println("doSome begin!");
        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("doSome over!");
    }

    public synchronized void doOther(){
        System.out.println("doOther begin!");
        System.out.println("doOther over!");
    }
}