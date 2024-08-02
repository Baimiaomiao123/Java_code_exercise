package String;
/*
    java.lang.StringBuilder
    StringBuffer和StringBuilder的区别
        StringBuffer中的方法都有synchronized关键字修饰，表示StringBuffer在多线程环境下运行是安全的
        StringBuilder中的方法没有有synchronized关键字修饰，表示StringBuffer在多线程环境下运行是不安全的
 */
public class StringBuilderTest {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        sb.append("a");
        sb.append("b");
        sb.append(100);
        sb.append(true);
        System.out.println(sb.toString()); //ab100true
    }
}
