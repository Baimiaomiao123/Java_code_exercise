package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask; //JUC包下的。属于java的并发包，老JDK没有这个包

/*
    实现线程的第三种方式：
        实现Callable接口
        这种方式的优点：可以获取到线程的执行结果
        这种方式的缺点：效率比较低，在获取t线程执行结果的时候，该线程会受阻
 */
public class ThreadTest15 {
    public static void main(String[] args) {
        System.out.println("main begin");
        // 第一步：创建一个未来任务对象
        FutureTask task = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception { //call方法相当于run方法，只不过这个有返回值
                //线程执行一个任务，执行之后可能会有一个执行结果
                //模拟执行
                System.out.println("call method begin");
                Thread.sleep(1000 * 10);
                System.out.println("call method over");
                int a = 100;
                int b = 100;
                return a + b; //自动装箱（200结果变成Integer）
            }
        });

        //创建线程对象
        Thread t = new Thread(task);

        //启动线程
        t.start();

        //在这里是main方法，在主线程中
        //在主线程中，怎么获取t线程的返回结果？
        //get()方法的执行会导致"当前线程阻塞"
        try {
            Object obj = task.get();
            System.out.println("线程执行结果" + obj);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //main方法这里的程序要执行必须等get()方法的结束
        //而get()方法可能需要等很久。因为get()方法是未来拿另一个线程的执行结果
        //另一个线程执行是需要时间的
        System.out.println("main over");
    }
}
