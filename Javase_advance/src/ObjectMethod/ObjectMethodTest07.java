package ObjectMethod;
/*
    hashCode()方法：
        在Object中的hashCode()方法是怎么样的？
            public native int hashCode();
            这个方法不是非抽象方法，带有native关键字，底层调用c++程序

        hashCode()方法返回的是哈希值
            实际上就是一个java对象的内存地址，经过哈希算法，得出一个值
            所以hashCode()方法的执行结果可以等同看做一个java的对象的内存地址
 */
public class ObjectMethodTest07 {

    public static void main(String[] args) {
        Object o = new Object();
        int hashCodeValue = o.hashCode();

        //经过哈希算法，得出一个值，等同看做一个java的对象的内存地址
        System.out.println(hashCodeValue);

        Myclass mc = new Myclass();
        int hashCodeValue2 = mc.hashCode();
        System.out.println(hashCodeValue2);
    }
}

class Myclass{
}