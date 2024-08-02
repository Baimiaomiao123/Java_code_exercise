package IOStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/*
    java.io.PrintStream：标准的字节输出流。默认输出到控制台
 */
public class PrintStreamTest {
    public static void main(String[] args) {
        //联合起来写
        System.out.println("hello world!");

        //分开写
        PrintStream ps = System.out;
        ps.println("hello baimiaomiao");
        ps.println("hello lisi");

        //标准输出流不需要手动close()关闭
        //可以改变标准输出流的输出方向吗？ 可以。
        /*
        //这些是之前System类使用过的方法和属性
        System.gc();
        System.currentTimeMillis();
        PrintStream ps2 = System.out;
        System.exit(0);
        System.arraycopy(....);
         */
        try {
            //标准输出流不再指向控制台，而是指向javase_advance/src/IOStream/File/log文件中
            System.setOut(new PrintStream(new FileOutputStream("javase_advance/src/IOStream/File/log")));

            System.out.println("hello baimiaomiao");
            System.out.println("hello lisi");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
