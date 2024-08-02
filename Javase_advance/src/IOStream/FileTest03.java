package IOStream;

import java.io.File;

/*
    File中的listFiles方法：
        File[] listFiles(); 获取当前目录下所有的子文件
 */
public class FileTest03 {
    public static void main(String[] args) {
        File f = new File("javase_advance/src/IOStream");

        //获取了文件下所有的子文件（这里就是获取了IOStream文件子的所有子文件）
        File[] files = f.listFiles();

        for (File file:
             files) {
            System.out.println(file.getAbsoluteFile());
        }
    }
}
