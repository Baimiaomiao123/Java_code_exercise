package IOStream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
    java.io.DataOutputStream：数据专属的流
        这个流可以将数据连同数据的类型一并写入文件
        注意：这个文件不是普通文本文档（这个文件使用记事本打不开）
 */
public class DataOutputStreamTest {
    public static void main(String[] args) {
        try {
            //创建数据专属的字节输出流
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("javase_advance/src/IOStream/File/data"));

            //写数据
            byte b = 100;
            short s =200;
            int i = 300;
            long l = 400L;
            float f = 3.0f;
            double d = 3.14;
            boolean sex = false;
            char c = 'a';

            //写，把数据类型一并写入
            dos.writeByte(b);
            dos.writeShort(s);
            dos.writeInt(i);
            dos.writeLong(l);
            dos.writeFloat(f);
            dos.writeDouble(d);
            dos.writeBoolean(sex);
            dos.writeChar(c);


            dos.flush();
            dos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
