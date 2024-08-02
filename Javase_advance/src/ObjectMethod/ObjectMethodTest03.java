package ObjectMethod;

/*
    问题：java语言当中的字符串String有没有重写toString方法？有没有重写euqals方法？
    总结：
        1.String类已经重写了equals方法，比较两个字符串不能使用==，必须使用equals方法
        equals是通用的

        2.String类已经重写了toString方法

    大结论：
        java中什么类型的数据可以使用"=="判断？
            java中基本数据类型是否相等，使用==

        java中什么类型的数据可以使用equals方法判断？
            java中所有引用数据类型统一使用equals方法来判断是否相等
 */
public class ObjectMethodTest03 {

    public static void main(String[] args) {
        //大部分情况下，采用这样的方式创建字符串对象
        String s1 = "hello";
        String s2 = "hello";
        System.out.println(s1 == s2); //true

        //实际上String是一个类，属于引用数据类型
        //String一定存在构造方法

        String s3 = new String("Test1");
        String s4 = new String("Test1");

        System.out.println(s3 == s4);  //false，==比较的是内存地址
        //所以，如果要比较两个字符串不能使用双等号，必须要使用equals方法
        System.out.println(s3.equals(s4)); //true

        System.out.println("==========================");

        String x = new String("白喵喵");
        //如果String方法没有重写toString方法，则返回的是java.lang.String@十六进制
        //如果重写了toString方法，则返回的是白喵喵
        System.out.println(x.toString()); //结果：白喵喵，可见java的String类已经重写了toString方法
        System.out.println(x); //不写，也会默认调用toString方法

    }
}
