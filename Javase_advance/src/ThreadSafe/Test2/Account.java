package ThreadSafe.Test2;

/*
    银行账户
        使用线程同步机制，解决线程安全问题
 */
public class Account {
    //账号
    private String sctno;

    //余额
    private double balance;

    //对象
    Object obj = new Object(); //实例变量。（Account对象是多线程共享的，Account中的实例变量obj也是共享的）

    public Account() {
    }

    public Account(String sctno, double balance) {
        this.sctno = sctno;
        this.balance = balance;
    }

    public String getSctno() {
        return sctno;
    }

    public void setSctno(String sctno) {
        this.sctno = sctno;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    //取款的方法
    public void withdraw(double money){

        //以下这几行代码必须是线程排队的，不能并发
        //一个线程把这里的代码全部执行完了之后，另一个线程才能进来
        /*
            线程同步机制的语法是：
                synchronized(){
                    //线程同步代码块
                }
                注意：synchronized后面小括号中传递的这个"数据"是相当关键的
                这个数据必须是多线程共享的数据，才能达到多线程排队

                ()写什么？
                    那要看你想让哪些线程同步
                    假设t1、t2、t3、t4、t5，有5个线程
                    你只希望t1，t2，t3排队，t4，t5不需要排队，怎么办？
                    你一定要在()中写一个t1，t2，t3共享的对象。而这个
                    对象对于t4，t5来说不是共享的

                这里的共享对象是：账户对象
                账户对象是共享的，那么this就是账户对象，所以把this这个关键写入括号即可
                注意：不一定是this，这里只要是共享的那个对象就行

                在java语言中，任何一个对象都有"一把锁"，其实这把锁就是标记（只是把他叫做锁）
                100个对象，100把锁，1个对象1把锁

                以下代码的执行原理？
                    1、假设t1和t2线程并发，开始执行以下代码的时候，肯定有一个先一个后
                    2、假设t1先执行了，遇到了synchronized，这个时候自动找"后面共享对象的"对象锁
                    找到之后，并占有这把锁，然后执行同步代码块中的程序，在程序执行过程中一直都是
                    占有这把锁的，直到同步代码块代码结束，这把锁才会释放
                    3、假设t1已经占有这把锁，此时t2也遇到了synchronized关键字，也会去占有后面共享
                    对象的这把锁，结果这把锁被t1占有，t2只能在同步代码块外面等待t1的结束，直到t1把同步代码块
                    执行结束了，t1会归还这把锁，此时t2终于等到这把锁，然后t2占有这把锁之后，进入同步代码块执行恒旭

                    这样就达到类线程排队执行
                    这里需要注意的是：这个共享对象一定要选好。这个共享对象一定是你需要排队执行的这些线程对象所
                    共享的

         */
//        synchronized (this){ 同一个对象的线程会同步
//        synchronized ("abc"){ abc在字符串常量池中，所有线程都会同步
        synchronized (obj){
            double before = this.getBalance();
            System.out.println("取款之前的余额为：" + before);
            double after = before - money;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.setBalance(after);
            System.out.println("取款之后的余额为：" + this.getBalance());
            System.out.println("账户" + this.getSctno() + "取款成功，余额：" + this.getBalance());
        }
    }
}
