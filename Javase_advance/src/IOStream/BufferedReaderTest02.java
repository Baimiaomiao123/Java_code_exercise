package IOStream;

import java.io.*;


public class BufferedReaderTest02 {
    public static void main(String[] args) {

        try {
            /*
            //字节流
            FileInputStream in = new FileInputStream("javase_advance/src/IOStream/File/writer_file_copy");

            //通过转换流转换(InputStreamReader将字节流转换成字符流)
            //在这in是节点流，reader是包装流
            InputStreamReader reader = new InputStreamReader(in);

            //这个构造方法只能传一个字符流，不能传字节流
            //在这reader是节点流，br是包装流
            BufferedReader br = new BufferedReader(reader);
            */

            //合并写法
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("javase_advance/src/IOStream/File/writer_file_copy")));


            String line = null;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }

            //关闭最外层
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
