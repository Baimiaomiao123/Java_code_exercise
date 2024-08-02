package Date;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
    有参数
 */
public class DateTest03 {

    public static void main(String[] args) {

        //1970-01-01 00:00:00 000
        Date time = new Date(1); //这里的参数为毫秒
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss SSS");

        System.out.println(sdf.format(time)); //1970/01/01 08:00:00 001 (北京是东八区，所以是08)

        //获取昨天此时的时间
        Date time2 = new Date(System.currentTimeMillis() - 1000* 60 * 60 * 24);
        System.out.println(sdf.format(time2));
    }
}
