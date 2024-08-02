package String;

/*
    问题：因为java中的字符串不可变，每一次拼接都会产生新的字符串，这样会造成占用大量的方法区内存而导致储存空间浪费
    解决：StringBuffer类的append()方法
        如何优化StringBUffer的使用？
            在创建StringBuffer的时候尽可能给一个初始化容量
            最好减少底层数组的扩容次数，预估一下给一个大一点的初始化容量
            关键：给定一个合适的初始化容量，可以提高程序的执行效率
 */
public class StringBufferTest {

    public static void main(String[] args) {
        //下列代码会导致方法区字符串常量池大量内存被占用
        /*
        String s = "";
        for (int i = 0; i < 20; i++) {
            s = s + i;
            System.out.println(s);
        }
         */

        //创建一个初始化容量为16个byte[]数组。（字符串缓冲区）
        StringBuffer stringbuffer = new StringBuffer();

        //拼接字符串，统一调用append()方法，append()方法
        stringbuffer.append("a");
        stringbuffer.append("b");
        stringbuffer.append("c");
        stringbuffer.append(100L);
        System.out.println(stringbuffer.toString()); //abc100


    }
}
