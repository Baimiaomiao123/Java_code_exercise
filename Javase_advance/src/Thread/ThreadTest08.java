package Thread;

/*
    sleep睡眠太久，如果希望半道上醒来，怎么叫醒一个睡眠现象？
        注意：这个不是中断线程的执行，是终止线程的睡眠
 */
public class ThreadTest08 {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable2());
        t.setName("t");
        t.start();

        //希望5秒之后，t线程醒来(主线程手里的活干完了)
        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //中断t线程的睡眠，这种中断睡眠的方式依靠了java的异常处理机制
        t.interrupt(); //干扰，会手动抛出异常，从而中断线程的睡眠
    }
}

class MyRunnable2 implements Runnable{

    //重点：run()当中的异常不能throws，只能try..catch
    //因为run()方法在父类中没有抛出异常，而在异常处理的原则中：子类不能比父类抛出更多的异常
    //所以必须要在try...catch方法将异常信息处理掉才行
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "---> begein");

        //睡眠一年
        try {
            Thread.sleep(1000 * 60 * 60 *24 *365);
        } catch (InterruptedException e) {
            e.printStackTrace();
            //如果不想异常信息出现，注释掉这行代码异常信息就不会出现了
        }
        System.out.println(Thread.currentThread().getName() + "---> end");


        //run方法中只能try...catch
        try {
            doOther();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //其它方法可以throws，因为其它方法的父类抛出了异常，所以这个方法可以直接抛出异常
    public void doOther() throws Exception{

    }
}
