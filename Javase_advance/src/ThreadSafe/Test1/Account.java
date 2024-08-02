package ThreadSafe.Test1;

/*
    银行账户
        不使用线程同步机制，多线程对同一个账户进行取款，出现线程安全问题
 */
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
    public void withdraw(double money){

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
        //思考：此时线程t1执行到这里了，但是还没有来得及执行下面的代码，这时候线程t2就来调用withdraw方法了，此时一定会出现问题
        this.setBalance(after);
        System.out.println("取款之后的余额为：" + this.getBalance());

        System.out.println("账户" + this.getSctno() + "取款成功，余额：" + this.getBalance());

    }
}
