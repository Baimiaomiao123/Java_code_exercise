package IOStream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
    BufferedReader：
        带有缓冲区的字符流
        使用这个流的时候不需要自定义char数组，或者说不需要要定义byte数组
 */
public class BufferedReaderTest01 {
    public static void main(String[] args) {
        //当一个流的构造方法需要一个流的时候，这个被传进来的流称为：节点流
        //外部负责包装的这个流，叫做：包装流，还有一个名字叫做处理流
        //reader就是节点流，br就是包装流
        try {
            FileReader reader = new FileReader("javase_advance/src/IOStream/File/writer_file_copy");
            BufferedReader br = new BufferedReader(reader);

            /*
            //一行一行的读
            String firstLine = br.readLine();
            System.out.println(firstLine); //中国人

            String secondLine = br.readLine();
            System.out.println(secondLine); //我是一名java工程师
             */

            //循环方式读
            String s = null;
            while ((s = br.readLine()) != null){  //注意它不会读换行符，需要我们自带换行符
                System.out.println(s);
            }

            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
