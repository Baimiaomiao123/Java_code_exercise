package IOStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
    对第一个程序进行改进，利用循环的方法

    分析这个程序的特点：
        一次读取一个字节byte，这样内存和硬盘的交互太频繁，基本上时间和资源都会耗费在交互上面
        能不能一次读取多个字节呢？ 可以

 */
public class FileInputStreamTest02 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("/Users/miaopeng/code/java/code_exercise/javase_advance/src/IOStream/File/temp");

            //开始读
            /*
            while(true){
                int readData = fis.read();
                if(readData == -1){
                    break;
                }
                System.out.println(readData);
            }
             */

            //改造while循环
            int readData = 0;
            while(((readData =fis.read()) != -1)){
                System.out.println(readData);
            }




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

/*
        还可以用do...while循环，但是最后一位一定是-1，对于某些应用场景可能有奇效
            int readData;
            do{
                readData = fis.read();
                System.out.print(readData + " ");
            }while (readData != -1);
 */
