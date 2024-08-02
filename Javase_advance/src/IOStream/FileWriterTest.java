package IOStream;

import java.io.FileWriter;
import java.io.IOException;

/*
    FileWriterTest：
        文件字符输出流，写
        只能输出普通文本
 */
public class FileWriterTest {
    public static void main(String[] args) {
        FileWriter out = null;
        try {
            //没有文件同样会新建一个文件，如果有文件，向该文件输出如果创建的时候不加true就会覆盖原文件
            out = new FileWriter("javase_advance/src/IOStream/File/writer_file");

            //开始写
            //可以传字符
            char[] chars = {'我','是','中','国','人'};
            out.write(chars,2,3);

            out.write("\n"); //写入一个换行符

            //也可以直接传字符串——比FileInputStream方便的地方
            out.write("我是一名java软件工程师");

            //注意：输出流用完之后一定要记得刷新
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
