package IOStream;

import java.io.File;
import java.net.StandardSocketOptions;

/*
    拷贝目录：将文件从一个地方拷贝至另一个地方
    需要使用到：
        FileInputStream
        FileOutputStream
        File
    可能需要使用到递归
 */
public class CopyTest03 {
    public static void main(String[] args) {
        //拷贝源
        File srcFile = new File("");

        //拷贝目标
        File destFile = new File("");

        //调用方法拷贝
        copy(srcFile,destFile);
    }

    private static void copy(File srcFile, File destFile) {
        if (srcFile.isFile()){
            //srcFile如果是一个文件的话，递归结束
            return;
        }
        //获取源下面的子目录
        File[] files = srcFile.listFiles();
        for (File file:
             files) {
            //获取所有文件的（包括目录和文件）的绝对路径
//            System.out.println(file.getAbsolutePath());
            if (file.isDirectory()){
                //新建对应的目录
                String srcDir = file.getAbsolutePath();
                String destDir = destFile.getAbsolutePath();
            }
            //递归调用
            copy(file,destFile);
        }
    }
}
