package Number;

import java.math.BigDecimal;

/*
    1.BigDecimal 属于大数据，不属于基本数据类型，属于引用数据类型
      这是SUN提供的一个类，专用在财务软件当中
    2.注意：财务软件中double是不够的，必须要用BigDecimal
 */
public class BigDecimalTest01 {

    public static void main(String[] args) {
        BigDecimal v1 = new BigDecimal(100);
        BigDecimal v2 = new BigDecimal(100);
        //求和
        //不能使用v1+v2，因为数据类型是引用数据类型，不能直接使用求和
        BigDecimal v3 = v1.add(v2);
    }
}
