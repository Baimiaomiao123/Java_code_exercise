package IOStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
    日志工具
 */
public class logger {
    public static void log(String msg){
        try {
            //改变输出方向
            //注意这里：FileOutputStream里面构造方法一定要有true，否则就会把之前的信息覆盖，只会出现最新的一次记录信息
            System.setOut(new PrintStream(new FileOutputStream("javase_advance/src/IOStream/File/log_util",true)));
            //日期当前时间
            Date nowTime = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
            String strTime = sdf.format(nowTime);

            System.out.println(strTime + ": " + msg);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
