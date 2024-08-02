package com.baimiaomiao.reflect;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className Test
 * @since 1.0
 */


public class Test {

    public static void main(String[] args) {
        // 不使用反射机制调用这些方法
        SomeService someService = new SomeService();

        someService.doSome();

        /**
         * 分析：调用一个方法，当中含有几个要素？四要素
         *  第一要素：对象
         *  第二要素：方法
         *  第三要素：参数
         *  第四要素：返回值
         *
         *  即：调用哪个对象的哪个方法，传什么参数，返回什么值
         *
         *  即使是使用反射机制调用方法，也同样需要这些要素
         */
        String s1 = someService.doSome("张三");
        System.out.println(s1);

        String s2 = someService.doSome("李四", 250);
        System.out.println(s2);
    }
}
