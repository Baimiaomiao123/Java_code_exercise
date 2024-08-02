package Constructor.example02;

//账户类
public class Account {

    //账号
    private String actno;

    //余额
    private double balance;

    //无参数构造器
    public Account(){

    }

    //不同参数构造器
    public Account(double d){
        balance = d;
    }
    public Account(String s){
        actno = s;
    }
    public Account(String s,double d){
        actno = s;
        balance = d;
    }

    public String getActno() {
        return actno;
    }

    public void setActno(String actno) {
        this.actno = actno;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


}
