package IOStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
    FileInputStream类的其他常用方法：
        int available()——返回流当剩余的没有读到的字节数量
        long skip(long n)——跳过几个字节不读
 */
public class FileInputStreamTest05 {
    public static void main(String[] args) {

        FileInputStream fis = null;
        try {

            fis = new FileInputStream("javase_advance/src/IOStream/File/temp");

//            fis.skip(3); //跳过三个字节abc，从d开始读


            System.out.println("总字节数量：" + fis.available());

            int readByte = fis.read();

            //读了一个字节之后，还剩下6个字节
            System.out.println("还剩下没有读到的字节数：" +fis.available()); //6

            //这个方法有什么？
            //不需要循环了，直接读一次就行
            byte[] bytes = new byte[fis.available()]; //这种方式不太适合太大的文件，因为byte[]数组不能太大

            int readCount = fis.read(bytes);

            System.out.println(new String(bytes));


        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
