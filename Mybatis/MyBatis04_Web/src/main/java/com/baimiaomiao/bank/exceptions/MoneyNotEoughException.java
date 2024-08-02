package com.baimiaomiao.bank.exceptions;

public class MoneyNotEoughException extends Exception{
    public MoneyNotEoughException() {
    }

    public MoneyNotEoughException(String msg){
        super(msg);
    }
}
