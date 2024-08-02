package IOStream;

import java.io.File;
import java.text.SimpleDateFormat;

/*
    File类的常用方法
 */
public class FileTest02 {
    public static void main(String[] args) {
        File f1 = new File("javase_advance/src/IOStream/File/temp");

        //获取文件名
        System.out.println("文件名" + f1.getName()); //temp

        //判断是否是一个目录
        System.out.println(f1.isDirectory()); //false

        //判断是否是一个文件
        System.out.println(f1.isFile()); //true

        //获取文件最后一次修改时间
        long time = f1.lastModified(); //这个时间是从1970年到现在的总毫秒数——时间戳
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String strTime = sdf.format(time);
        System.out.println(strTime);

        //获取文件的大小
        System.out.println(f1.length()); //7个字节

        //
    }
}
