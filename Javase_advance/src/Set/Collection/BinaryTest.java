package Set.Collection;
/*
位运算符：>>;<<

 */
public class BinaryTest {
    public static void main(String[] args) {
        //5
        // >>1 右移一位
        // >>2 右移两位
        // 10的二进制位是00001010
        // 右移一位是00000101 即5
        System.out.println(10 >> 1); //5

        // << 左移一位
        // << 左移两位
        // [10] 00001010 << 1 = 00010100 [20]
        System.out.println(10 << 1); //20

    }
}
