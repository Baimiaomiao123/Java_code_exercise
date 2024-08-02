package IOStream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
    使用FileReader + FileWriter完成文件的拷贝
 */
public class CopyTest02 {
    public static void main(String[] args) {
        FileReader in = null;
        FileWriter out = null;

        try {
            in = new FileReader("javase_advance/src/IOStream/File/writer_file");
            out = new FileWriter("javase_advance/src/IOStream/File/writer_file_copy");

            char[] chars = new char[1024 * 512]; //1MB
            int readCount = 0;
            while ((readCount = in.read(chars)) != -1){
                out.write(chars,0,readCount);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //分开关闭
            if (out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
