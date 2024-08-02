package Integer;
/*
    在JDK1.5之后，支持自动装箱和自动拆箱
 */
public class IntegerTest05 {
    public static void main(String[] args) {
        //自动装箱
        //int类型自动转换为Interger类型
        Integer i = 100;

        //自动拆箱
        //Interger类型自动转换为int类型
        int j = i;

        //z是一个引用，z是一个变量，z还是保存了一个对象的内存地址
        Integer z = 100;
        //这里的+号将会自动导致integer类型转换为基本数据类型
        System.out.println(z + 1); //101

        Integer a = 1000; //a保存的是一个内存地址
        Integer b = 1000; //b保存的是另一个内存地址
        //只有+ - * %才会触发自动拆箱机制
        System.out.println(a == b); //false，==比较的是内存地址，且不会触发自动拆箱机制

    }
}
