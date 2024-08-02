package String;
/*
    String类中的常用方法：
        1.(掌握)char charAt()：返回字符串下标所对应的字符
        2.(了解)int compareTo()：按照字典顺序比较两个字符串的值，返回值为0(前后一致)/1(前大后小)/-1(前小后大)
        3.(掌握)boolean contains()：判断前面的字符串是否包含后面的子字符串
        4.(掌握)boolean endsWith()：判断当前字符串是否以某个字符串结尾
        5.(掌握)boolean equalsIgnoreCase()：判断两个字符串是否相等（忽略大小写）
        6.(掌握)byte[] getBytes()：将字符串对象转换成字节数组
        7.(掌握)int indexOf()：判断某个子字符串在当前字符串中第一次出现处的索引
        8.(掌握)boolean isEmpty()：判断某个字符串是否为空字符串
        9.(掌握)int lastIndexOf()：判断某个子字符串在当前字符串中最后一次出现处的索引
        10.(掌握)String replace()：用新的字符串替换旧的字符串
        11.(掌握)String[] split()：拆分字符串
        12.(掌握)boolean starsWith()：判断当前字符串是否以某个字符串开始
        13.(掌握)String substring()：截取字符串
        14.(掌握)char[] toCharArray()：将字符串转换成数组
        15.(掌握)String toLowerCase()：将字符串全部转换为小写
        16.(掌握)String toUpperCase()：将字符串全部转换为大写
        17.(掌握)String trim()：去除字符串前后空白
        18.(掌握)static String valueOf()：将非字符串转换为字符串 (该方法为静态方法，不需要创建对象)

 */
public class StringTest03 {

    public static void main(String[] args) {
        //1.charAt()方法
        char c = "中国人".charAt(1);
        System.out.println(c); //国

        //2.compareTo()方法
        int result = "abc".compareTo("abc");
        System.out.println(result); //0

        int result2 = "abcd".compareTo("abce");
        System.out.println(result2); //-1

        int result3 = "abce".compareTo("abcd");
        System.out.println(result3); //1

        System.out.println("xyz".compareTo("yzx")); //-1

        //3.contains()方法
        System.out.println("HelloWorld.java".contains("java")); //true
        System.out.println("helloWorld.java".contains("baimiaomiao")); //false

        //4.endsWith()方法
        System.out.println("test.txt".endsWith("txt")); //true
        System.out.println("test.txt".endsWith("test")); //false

        //5.equalsIgnoreCase()方法
        System.out.println("abc".equalsIgnoreCase("ABC")); //true
        System.out.println("abc".equals("ABC")); //false

        //6.getBytes()方法
        byte[] bytes = "abcdef".getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.print(bytes[i]+" "); //97 98 99 100 101 102
        }
        System.out.println();

        //7.indexOf()方法
        int a = "abcd".indexOf("bc");
        System.out.println(a); //1

        //8.isEmpty()方法
        //判断数组的长度是length属性，判断字符串长度是isEmpty()方法(其本质就是字符串为0)
        System.out.println("".isEmpty()); //true
        System.out.println("abc".isEmpty()); //false

        //9.lastIndexOf()方法
        System.out.println("abcdcd".lastIndexOf("cd")); //4

        //10.replace()方法
        System.out.println("http://www.baidu.com".replace("http:/","https:/")); //https://www.baidu.com
        System.out.println("abcb===bagdsg==asdf=".replace("=",":")); //abcb:::bagdsg::asdf:

        //11.split()方法
        String[] ymd = "1970-01-01".split("-");
        for (int i = 0; i < ymd.length; i++) {
            System.out.print(ymd[i]+" "); //1970 01 01
        }
        System.out.println();

        //12.startsWith()方法
        System.out.println("http://www.baidu.com".startsWith("http")); //true
        System.out.println("http://www.baidu.com".startsWith("www")); //false

        //13.subString()方法
        System.out.println("http://www.baidu.com".substring(0,4)); //http(起始位置包括，结束位置不包括)

        //14.toCharArray()方法
        char[] chars = "白喵喵".toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]+" "); //白 喵 喵
        }
        System.out.println();

        //15.toLowerCase()方法
        System.out.println("ABCDE".toLowerCase()); //abcde

        //16.toUpperCase()方法
        System.out.println("abcde".toUpperCase()); //ABCDE

        //17.trim()方法
        System.out.println("   Hello World!   ".trim()); //Hello World!

        //18.valueOf()方法
        String str = String.valueOf(true);
        System.out.println(str); //true
        String str2 = String.valueOf(new test());
        System.out.println(str2); //我是白喵喵
        //本质上System.out.println()都是将括号里的东西转换成字符串再进行输出
    }
}

class test{

    @Override
    public String toString() {
        return "我是白喵喵";
    }
}
