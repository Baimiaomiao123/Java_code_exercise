package String;

/*
    关于java JDK内置的一个类：String类
        1.String类表示字符串类型，属于引用数据类型，不属于基本数据类型
        2.在java中随便使用双引号括起来的字符串都是String对象
        3.java中规定：双引号括起来的字符串是不可变的
        4.在JDK当中，双引号括起来的字符串，都是直接存储在方法区的"字符串常量池"中
            ——因为字符串实际开发中使用太频繁，为了执行效率，所以将其放置在"字符串常量池中"
        5.java的String类自己已经重写了equals方法，可以直接调用（比较时，将目的字符串作为对象可以避免空指针异常）

 */
public class StringTest01 {
    public static void main(String[] args) {
        String s1 = "abcd";
        String s4 = "abcd";
        String s2 = "abcd" + "xyz"; //重新在方法区内存的字符串常量池中开辟xyz和abcdxyz两个常量

        //调用String的构造方法：会在堆内存中创建一个String对象，对象内有一个地址，该地址指向方法区内存字符串常量池中的常量(字符串对象)
        String s3 = new String("edf");
        String s5 = new String("abcd");

        System.out.println(s1 == s4);//注意：==比较地址

        //判断s1中的字符串是否为abcd
        System.out.println("abcd".equals(s1));//String类已经重写了equals方法，可以直接在字符串对象中调用该方法判断两个字符串是否相等
        System.out.println(s1.equals("abcd"));//该方法调用可能会出现空指针异常，尽量用上面的方法

        System.out.println(s3 == s5);//比较地址


    }
}
