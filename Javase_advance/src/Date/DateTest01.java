package Date;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
    1.获取当前时间java.util包中的Date类，无参构造即可
    2.date ----> String：通过java.text包中的SimpleDateFormat类中的format方法进行转换即可
    3.String ----> date：通过java.text包中的SimpleDateFormat类中的parse方法进行转换即可
 */
public class DateTest01 {

    public static void main(String[] args) throws Exception {
        //获取系统当前时间
        //直接调用无参构造方法
        Date nowTime = new Date();

        //Date类的toString方法已经被重写
        //输出的不是一个内存地址，而是一个日期字符串
        System.out.println(nowTime);

        //日期的格式化：将Date转换成具有一定格式的日期字符串（date ----> String）
        //SimpleDateFormat类，位于java.text包下，专门负责日期格式化
        /*
        yyyy 年（年是4位，最高是9999）
        MM 月（月是2位）
        dd 日
        HH 时
        mm 分
        ss 秒
        SSS 毫秒（毫秒3位，最高是999，1000ms = 1s）
         */
        //注意：在日期格式中，除了y M d H m s S这些字符不能随便写，其他随便写
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss SSS");
        String nowTimeStr = sdf.format(nowTime);
        String nowTimeStr2 = sdf2.format(nowTime);
        System.out.println(nowTimeStr);
        System.out.println(nowTimeStr2);

        //如有现在又一个字符串，怎么转换成Date
        //parse()方法，但是格式要一一对应，否则就会出现ParseException类型错误
        String time = "08/08/2018 08:08:08 888";
        Date datetime = sdf2.parse(time);
        System.out.println(datetime);

    }
}
