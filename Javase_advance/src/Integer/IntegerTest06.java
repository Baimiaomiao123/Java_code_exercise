package Integer;

/*
    分析以下程序为什么？
 */

public class IntegerTest06 {

    public static void main(String[] args) {
        Integer a = 128;
        Integer b = 128;
        System.out.println(a == b); //false

        /*
            java中为了提高程序执行效率，将-128-127之间所有包装对象提前创建好
            放到了一个方法区的整数型常量池当中取出来，目的是只要用了这个区间的数据不需要再new了，直接从整数型常量池中取出来

            原理：x变量中保存的对象的内存地址和y变量保存的内存地址一致，所以==判断的结果是true
         */
        Integer x = 127;
        Integer y = 127;
        System.out.println(x == y); //true
    }
}
