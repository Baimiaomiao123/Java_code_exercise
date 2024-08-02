package com.baimiaomiao.bank.pojo;

/**
 * 账户类：封装账户数据
 * @author baimiaomiao
 * @version 1.0
 * @since 1.0
 */
public class Account {
    private long id;
    private String actno;
    private Double balance;

    public Account() {
    }

    public Account(long id, String actno, Double balance) {
        this.id = id;
        this.actno = actno;
        this.balance = balance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getActno() {
        return actno;
    }

    public void setActno(String actno) {
        this.actno = actno;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", actno='" + actno + '\'' +
                ", balance=" + balance +
                '}';
    }
}
