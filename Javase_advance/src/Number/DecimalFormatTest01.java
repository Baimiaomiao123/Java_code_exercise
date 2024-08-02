package Number;

import java.text.DecimalFormat;

public class DecimalFormatTest01 {

    public static void main(String[] args) {
        //DecimalFormat

        /*
        数字的格式：
            # 代表任意数字
            , 代表千分位
            . 代表小数点
            0 代表不够时补0
         */

        DecimalFormat df = new DecimalFormat("###,###,###.##");
        String s = df.format(1123.56);
        System.out.println(s); //1,123.56

        DecimalFormat df2 = new DecimalFormat("###,###,###.0000");
        String s1 = df2.format(1123.56);
        System.out.println(s1); //1,123.5600


    }
}
