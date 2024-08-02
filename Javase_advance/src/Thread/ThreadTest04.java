package Thread;

/*
    采用匿名内部类可以吗？
 */
public class ThreadTest04 {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            //创建线程对象，采用匿名内部类的方式
            //"相当于"直接new了一个接口，但是实际上接口是不能new的
            //new接口需要实现接口里面所有的方法，Runnable接口只有一个run方法，在匿名内部类里直接重写即可
            //如果学会lambada表达式可以进一步化简
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("分支线程--->" + i);
                }
            }
        });
        
        //启动线程
        t.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("主线程--->" + i);
        }
    }
}
