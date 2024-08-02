package com.baimiaomiao.reflect;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className SomeService
 * @since 1.0
 */


public class SomeService {

    public void doSome(){
        System.out.println("public void doSome()执行...");
    }

    public String doSome(String s){
        System.out.println("public String doSome(String s)执行...");
        return s;
    }

    public String doSome(String s,int i){
        System.out.println("public String doSome(String s,int i)执行...");
        return s + i;
    }
}
