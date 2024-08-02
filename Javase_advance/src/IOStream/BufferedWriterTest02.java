package IOStream;

import java.io.*;

public class BufferedWriterTest02 {
    public static void main(String[] args) {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("javase_advance/src/IOStream/File/buffer_writer",true)));
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
