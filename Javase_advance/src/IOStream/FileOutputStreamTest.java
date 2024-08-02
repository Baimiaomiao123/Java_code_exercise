package IOStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
    文件字节输出流，
 */
public class FileOutputStreamTest {

    public static void main(String[] args) {
        FileOutputStream fos = null;

        try {
            //当文件不存的时候会自动新建
            //这种方式谨慎使用！！！，这种方式会将文件清空，然后再重写写入
//            fos = new FileOutputStream("javase_advance/src/IOStream/File/myfiles");

            //以追加的方式写入文件，跟true即可
            fos = new FileOutputStream("javase_advance/src/IOStream/File/myfiles",true);
            byte[] bytes = {97,98,99,100,101,102};

//            fos.write(bytes); //这里就会按照输出路径输出一个文件，里面包含了abcdef
            //f创建fos的时候append是true，就会忘文件的末尾追加
            fos.write(bytes,0,2); //向起始末尾追加两个字符，并且追加的字符从数组的第一位开始 最后结果是adcdefab

            fos.flush();

            //传递字符进去
            String s = "我是一个中国人，我骄傲！！！";
            byte[] bytes1 = s.getBytes();
            fos.write(bytes1);

            //写完之后一定要注意刷新
            fos.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (fos != null){
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            }
        }
    }

}
