package IOStream;

import java.io.File;
import java.io.IOException;

/*
    File类：
        1、File类和四大家族没有关系，所以File类不能完成文件的读和写
        2、File对象表示什么？
            文件和目录路径名的抽象表现形式
        3、需要掌握File类的常用方法：

 */
public class FileTest01 {
    public static void main(String[] args) {
        File f1 = new File("javase_advance/src/IOStream/File/temp");

        //判断是否存在
        System.out.println(f1.exists());  //true

        //如果不存在，就以文件的形式创建出来
        if (!f1.exists()){
            try {
                f1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //如果不存在，就以目录的形式创建出来
        if(!f1.exists()){
            f1.mkdir();
        }

        //获取文件的父路径
        String parentPath = f1.getParent();
        System.out.println(parentPath);
        File parentFile = f1.getParentFile();
        System.out.println("父路径：" + parentFile);

        //获取文件的绝对路径
        System.out.println("绝对路径：" + f1.getAbsoluteFile());
    }
}
