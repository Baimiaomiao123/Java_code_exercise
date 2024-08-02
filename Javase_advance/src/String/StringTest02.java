package String;

/*
    关于String类的构造方法
        1.String s = new String("");
        2.String s = "";
        3.String s = new String(char数组);
        4.String s = new String(char数组,起始下标,长度);
        5.String s = new String(byte数组);
        6.String s = new String(byte数组,起始下标,长度);


 */
public class StringTest02 {
    public static void main(String[] args) {

        //创建字符串对象最常用的一种方式
        String s1 = "Hello World!";
        //s1保存的是一个内存地址
        //已经重写了toString()方法
        System.out.println(s1);


        byte[] bytes = {97,98,99};
        //s2的构造方法
        String s2 = new String(bytes);
        //重写了toString()方法
        System.out.println(s2);

        String s3 = new String(bytes,1,2); //1表示起始位置，2表示长度
        System.out.println(s3); //bc

        char[] chars = {'我','是','中','国','人'};
        String s4 = new String(chars,2,3);
        System.out.println(s4); //中国人

        String s5 = new String("hello world");
        System.out.println(s5);
    }
}
