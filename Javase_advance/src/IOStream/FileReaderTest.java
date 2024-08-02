package IOStream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
    FileReader：
        文件字符输入流，只能读取普通文本
        读取文本内容时，比较方便，快捷
    方法类似于FileInputStream,有read close等
 */
public class FileReaderTest {
    public static void main(String[] args) {
        FileReader reader = null;

        try {
            reader = new FileReader("javase_advance/src/IOStream/File/temp");
            char[] chars = new char[4];
            reader.read(chars);
            for (char c:   //遍历一次读的4个字符
                 chars) {
                System.out.println(c);
            }
            /*
            char[] chars = new char[4]; //一次读取四个字符
            int readCount = 0;
            while ((readCount = reader.read(chars)) != -1 ){
                System.out.println(new String(chars,0,readCount));
            }
             */
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
