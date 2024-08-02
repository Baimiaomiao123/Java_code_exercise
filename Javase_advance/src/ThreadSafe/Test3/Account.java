package ThreadSafe.Test3;


public class Account {
    //账号
    private String sctno;

    //余额
    private double balance;

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
    //在实例方法可以加synchronized方法吗？可以。
    /*synchronized出现在实例方法上，一定锁的是this
        没得谈，只能是this。不能是其他的对象了
        所以这种方式不灵活

        另外还有一个缺点：synchronized出现在实例方法上，
        表示整个方法体都要同步，可能会无故扩大同步的范围
        导致程序的执行效率降低。所以这种方式不常用

        synchronized使用在实例方法上有什么优点？
            代码洁简

        如果共享的对象是this，并且需要同步的代码块整个需要同步，建议使用这种方式
     */
    public synchronized void withdraw(double money){

        //取款之间的余额
        double before= this.getBalance();
        System.out.println("取款之前的余额为：" + before);

        //取款之后的余额
        double after = before - money;

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //更新余额
        this.setBalance(after);
        System.out.println("取款之后的余额为：" + this.getBalance());

        System.out.println("账户" + this.getSctno() + "取款成功，余额：" + this.getBalance());

    }
}
