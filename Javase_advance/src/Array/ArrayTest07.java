package Array;
/*
    关于一维数组的扩容：
    在java开发中，数组长度一旦确定不可变，数组如果满了需要扩容：
        先建立一个大容量的数组，然后将小容量的数组中的数据一个个拷贝进大容量的数组当中

    结论：数组扩容效率较低，因为设计拷贝问题，所以在以后的开发中，尽可能少的进行数组的扩容
    所以在创建数组对象的时候预估一下多长合适，最好预估准确，这样既可以减少数组的扩容次数、提高效率，又可以避免内存空间的浪费
 */
public class ArrayTest07 {
    public static void main(String[] args) {
        //java中的数组进行拷贝:System.arraycopy()方法
//        System.arraycopy();（5个参数）

        //拷贝源
        int[] src = {1,11,22,3,4};

        //拷贝目标（拷贝到这个目标数组上）
        int[] dest = new int[7];

        //拷贝过程，注意：拷贝的是对象的内存地址，多出来的数组元素的值为该元素数据类型的默认值
        System.arraycopy(src,1,dest,3,2);

        //遍历数组
        for (int i = 0; i < dest.length; i++) {
            System.out.print(dest[i]);
        }

        System.out.println();
        System.out.println("===================");

        //将src全部拷贝至dest
        System.arraycopy(src,0,dest,0,src.length);
        for (int i = 0; i < dest.length; i++) {
            System.out.print(dest[i]);
        }

        System.out.println();
        System.out.println("===================");



    }
}
