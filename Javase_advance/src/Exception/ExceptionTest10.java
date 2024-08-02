package Exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
    关于try..catch中的finally子句：
        1.在finally子句中的代码是最后执行的，并且是一定会执行的，即使try语句块中的代码出现了异常
          finally中的语句也会执行

        2.finally语句通常是用在哪些情况下呢？
            通常在finally语句块中完成资源的释放/关闭
            因为finally中的代码比较有保障
            即使try语句块中的代码出现异常，finally中代码也会正常执行
 */
public class ExceptionTest10 {

    public static void main(String[] args) {
        //为了保证finally括号中的语句能够正常执行，需要在try以外的结构内创建对象
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("");

            String s = null;

            //这里一定会出现空指针异常
            s.toString();

            System.out.println("hello World!"); //该语句就无法执行

            //流使用完后需要关闭，因为流是占用资源的
            //即使以上程序出现异常，流也必须要关闭！
            //放在这里就有可能关不了
            fis.close();
            //所以应该使用try...catch进行关闭
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (NullPointerException e){
            e.printStackTrace();
        } finally {
            System.out.println("Hello Baimiaomiao！"); //输出该句表明程序已经执行到此处

            //关闭流
            if (fis != null){ //避免空指针异常

                try {
                    fis.close(); // close方法有异常，采用catch方法捕捉
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }

        System.out.println("Hello Kitty!");
    }
}
