package ThreadSafe.Test2;

public class AccountThread extends Thread{

    //两个线程必须共享同一个账户对象
    private Account act;

    //通过构造方法传递过来账户对象
    public AccountThread(Account act){
        this.act = act;
    }
    @Override
    public void run() {
        //或者直接在这里写，只不过扩大了同步范围，效率更低
        //不能写synchronized(this) 这个this代表的是AccountThread对象，在Test02中生成了两个对象，自然就不会存在线程同步问题
        synchronized (act) {
            //run方法的执行表示取款操作
            //假设取款5000
            double money = 5000;
            act.withdraw(money);
        }
    }
}
