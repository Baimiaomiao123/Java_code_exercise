package IOStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
    int read(byte[] b)
        一次最多读取b.length个字节
        减少硬盘和内存的交互，提高程序的执行效率
        在byte[]数组中读
 */
public class FileInputStreamTest03 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            //相对路径的话呢？
            //IDEA默认的当前路径是那里呢？ 工程Project的根就是IDEA默认当前路径
            fis = new FileInputStream("javase_advance/src/IOStream/File/temp");

            //采用byte[]数组，一次读取多个字节。最多读取"数组.length"个字节
            byte[] bytes = new byte[4];
            //这个方法的返回值是：
            int readCount =fis.read(bytes);
            System.out.println(readCount); //第一次读到了4个字节，返回4
            //将字节数组全部转换成字符串
            System.out.println(new String(bytes,0,4)); //abcd

            readCount = fis.read(bytes);
            System.out.println(readCount); //第二次只读到了3个字节，所以只返回3，所以readCount代表的是读取的个数
            //将字节数组全部转换成字符串
//            System.out.println(new String(bytes)); //efgd
            //不应该全部转换，应该是读取了多少个字节，就转换成多少个
            System.out.println(new String(bytes,0,readCount)); //efg

            readCount = fis.read(bytes);
            System.out.println(readCount); //最后因为后面什么都没有，读不到任何数据，所以返回-1
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
