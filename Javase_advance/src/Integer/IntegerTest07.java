package Integer;

import java.lang.reflect.Type;

/*
    总结以下之前所学的经典异常？
        空指针异常：NullPointException
        类型转换异常：ClassCastException
        数组下标越界异常：IndexOutOfBoundsException
        数字格式化异常：NumberFormatException

     Integer类当中有那些常用的方法：
        1.(掌握) static int parseInt(String s)：静态方法，传参String，返回int
        2.(了解) static String toBinaryString(int i)：将十进制转换为二进制
        3.(了解) static String toHexString(int i)：将十进制转为十六进制
        4.(了解) static String toOctalString(int i)：将十进制转为八进制s
        5.(了解) static Integer valueOf(int i)：返回一个指定的int值的Integer实例对象

 */
public class IntegerTest07 {
    public static void main(String[] args) {
        //手动装箱
        Integer x = new Integer(1000);

        //手动拆箱
        int y = x.intValue();
        System.out.println(y);

        //编译时没有问题，符合java语法
        //不是一个数字，可以包装成Integer嘛？不能。运行时会出错
        //java.lang.NumberFormatException
//        Integer a = new Integer("中文"); //NumberFormatException

        //1.parseInt()方法
        int retValue = Integer.parseInt("123"); //String -----> int
        System.out.println(retValue + 100); //223
        //同理，其他包装类也会有parse方法
        Double retValue2 = Double.parseDouble("123.0");
        System.out.println(retValue);
        System.out.println("-------------------以下内容了解，不需要掌握-------------------");

        //-------------------以下内容了解，不需要掌握-------------------
        //2.toBinaryString()方法
        String binaryString = Integer.toBinaryString(3);
        System.out.println(binaryString); //二进制:11

        //3.toHexString()方法
        String hexString = Integer.toHexString(16);
        System.out.println(hexString);//十六进制:10

        //4.toOctalString()方法
        String octalString = Integer.toOctalString(8);
        System.out.println(octalString);

        //5.valueOf()方法
        //int ----> Integer
        Integer i1 = Integer.valueOf(100);
        System.out.println(i1);

        //String ----> Integer
        Integer i2 = Integer.valueOf("100");
        System.out.println(i2);

        System.out.println("----------int转换成String的方法----------");
        int i = 100;
        //方法一：数字+""
        String s1 = i+"";
        //方法二：String.valueOf(int)
        String s2 = String.valueOf(i);

        System.out.println("----------String转换成int的方法----------");
        //Integer.parseInt(String)
        int i3 = Integer.parseInt("123");

        System.out.println("----------int转换成Integer的方法----------");
        //装箱
        Integer i4 = new Integer(123);
        Integer i5 = Integer.valueOf(123);
        //自动装箱
        Integer i6 = 123;

        System.out.println("----------Integer转换成int的方法----------");
        //拆箱
        int i8 = i6.intValue();
        //自动拆箱
        int i7 = i6;

        System.out.println("----------String转换成Integer的方法----------");
        Integer i9 = Integer.valueOf("123");

        System.out.println("----------Integer转换成Strings的方法----------");
        String s3 = String.valueOf(i9);
        System.out.println(s3);


    }
}
