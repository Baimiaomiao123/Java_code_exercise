package IOStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
    java.io.FileInputStream
        1、文件字节输入流，万能的，有任何类型的文件都可以采用这个流来读
        2、字节的方式，完成输入的操作，完成读的操作（硬盘 -------> 内存）
 */
public class FileInputStreamTest01 {
    public static void main(String[] args) {
        //创建文件字节输入流对象
        //文件路径：/Users/miaopeng/code/java/code_exercise/javase_advance/src/IOStream/File/temp
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("/Users/miaopeng/code/java/code_exercise/javase_advance/src/IOStream/File/temp");

            //开始读
            int readData = fis.read();
            System.out.println(readData); //97

            //每读一次"指针"就会往后移动一位
            readData = fis.read();
            System.out.println(readData); //98

            readData = fis.read();
            System.out.println(readData); //99

            readData = fis.read();
            System.out.println(readData); //100

            readData = fis.read();
            System.out.println(readData); //101

            readData = fis.read();
            System.out.println(readData); //102

            readData = fis.read();
            System.out.println(readData); //103

            //当指针指到文件最后一个字符的时候，再次读取的时候就会读出-1
            readData = fis.read();
            System.out.println(readData); //-1

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //在finally语句中确保流一定关闭
            if(fis != null){ //避免空指针异常
                //关闭流的前提是：流不是空。流是null的时候就没必要关闭
                try {
                    fis.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }




    }
}
