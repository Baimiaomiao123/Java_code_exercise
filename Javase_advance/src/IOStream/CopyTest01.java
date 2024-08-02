package IOStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
    使用FileInputStream + FileOutputStream完成文件的拷贝
        拷贝的过程应该是一边读，一边写
        使用以上的字节流拷贝文件的时候，文件类型随意，万能的。什么样的文件都能拷贝
 */
public class CopyTest01 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            //创建一个输入流对象
            fis = new FileInputStream("javase_advance/src/IOStream/File/myfiles");
            //创建一个输出流对象
            fos = new FileOutputStream("javase_advance/src/IOStream/File/myfiles_copy");

            //最核心的部分：一边读，一边写
            //建立"拷贝缓冲区"，大小为1MB = 1024kb * 1024kb
            byte[] bytes = new byte[1024 * 1024]; //1MB （一次最多拷贝1MB）

            int readCount = 0;
            while((readCount = fis.read(bytes)) != -1){
                fos.write(bytes,0,readCount);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //如果fis和fos一起try，其中一个出现异常可能会影响另一个流的关闭，如上面出现了异常，下面的就不会关
            //分开try

            if(fos != null ){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
