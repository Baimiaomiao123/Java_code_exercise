import java.time.ZonedDateTime;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className T
 * @since 1.0
 */


public class T {

    public static void main(String[] args) {
        ZonedDateTime zbj = ZonedDateTime.now(); //默认时区
        System.out.println(zbj); //2023-07-06T22:30:09.590981+08:00[Asia/Shanghai]
    }
}
