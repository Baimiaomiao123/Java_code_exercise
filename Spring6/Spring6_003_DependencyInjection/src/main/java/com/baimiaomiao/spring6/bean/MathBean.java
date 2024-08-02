package com.baimiaomiao.spring6.bean;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className MathBean
 * @since 1.0
 */


public class MathBean {
    private String result;

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "MathBean{" +
                "result='" + result + '\'' +
                '}';
    }
}
