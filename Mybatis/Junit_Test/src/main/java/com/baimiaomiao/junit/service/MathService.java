package com.baimiaomiao.junit.service;

/**
 * 数学业务类
 * @author baimiaomiao
 * @version 1.0
 * @since 1.0
 */
public class MathService {
    /**
     * 求和的业务方法
     * @param a
     * @param b
     * @return
     */
    public int sum(int a,int b){
        return a + b;
    }

    /**
     * 相减的业务方法
     * @param a
     * @param b
     * @return
     */
    public int sub(int a,int b){
        return a - b;
    }
}
