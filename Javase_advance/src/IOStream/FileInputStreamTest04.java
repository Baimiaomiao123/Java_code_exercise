package IOStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
    最终版：需要掌握
 */
public class FileInputStreamTest04 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("javase_advance/src/IOStream/File/temp");

            //准备一个byte数组
            byte[] bytes = new byte[4];

            //改成循环方式读取文件内容
            /*
            while(true){
                int readCount = fis.read(bytes);
                if (readCount == -1){
                    break;
                }
                System.out.print(new String(bytes,0,readCount));
            }
            System.out.println();
            */

            int readCount = 0;
            while((readCount = fis.read(bytes)) != -1){
                System.out.print(new String(new String(bytes,0,readCount)));
            }

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
