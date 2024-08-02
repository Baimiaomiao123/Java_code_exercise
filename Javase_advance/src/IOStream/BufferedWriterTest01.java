package IOStream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
    带有缓冲的字符输出流
 */
public class BufferedWriterTest01 {
    public static void main(String[] args) {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter("javase_advance/src/IOStream/File/buffer_writer"));
            out.write("Hello World!");
            out.write("\n");
            out.write("Hello Kitty!\n");

            //注意：一定要写flush方法
            out.flush();

            //用完后关闭
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
