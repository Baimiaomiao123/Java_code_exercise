package Array;

/*
    数组：
        1.java语言中的数组是一个引用数据类型，不属于基本数据类型。数组的父类是Object

        2.数组实际上是一个容器，可以同时容纳多个元素（数组是一个数据的集合）

        3.数组可以存储"基本数据类型"的数据，也可以存储"引用数据"类型的数据

        4.数组因为是引用类型，所以数组对象是在堆内存中（数组是存储在堆当中）

        5.数组当中如果存储的是"java对象"的话，实际上存储的是对象的"引用（内存地址）"

        6.数组一旦创建，在java中规定，长度不可变

        7.数组的分类：一维数组、二维数组、三维数组、多维数组...（一维数组较多，二维数组偶尔使用）

        8.所有数组对象都有length属性（java自带），用来获取数组中元素的个数

        9.java中的数组要求数组中元素的类型统一（数组中存储的元素类型统一）
            比如int类型数组只能存储int类型，Person类型数组只能存储Person类型

        10.数据在内存方面存储的时候，数组中的元素的内存地址是连续的（存储的每一个元素都是有规则的挨着排列的）。内存地址连续
            这是数组存储元素的特点（特色）。数组实际上是一种简单的数据结构

        11.所有的数组都是拿"第一个小方框的内存地址"作为整个数组对象的内存地址（数组中首元素的内存地址作为整个数组对象的内存地址）

        12.数组中每一个元素都是有下标的，下标从0开始，以1递增。最后一个元素的下标是：length-1
            下标非常重要，因为我们对数组中元素进行"存储"的时候，都需要通过下标来进行

        13.数组这种数据结构的优点和缺点是什么？
            优点：查询/查找/检索某个下标上的元素时，效率极高。可以说是查询效率最高的数据结构。
                第一：每个元素的内存地址在空间储存上是连续的
                第二：每个元素类型相同，所以占用空间大小一样
                第三：知道第一个元素内存地址，知道每一个元素占用空间的大小，又知道下标，所以
                     通过一个数学表达式就可以计算出某个下标上元素的内存地址。直接通过内存地址定位
                     元素，所以数组的检索效率是最高的

                    数组中存储100个元素，或者存储100万个元素，在元素查询/检索方面，效率是相同的
                    因为数组中元素查找的时候不会一个一个找，是通过数学表达式计算出来的（算出一个内存地址，直接定位）

            缺点：
                第一：由于为了保证数组中每个元素的内存地址连续，所以在数组上随机删除或者增加元素的时候效率较低
            因为随机增删元素会设计后面元素统一向前或向后位移的操作
                第二：不能存储较大的数据，因为很难在内存空间中找到一块特别大的连续内存空间

            注意：对于数组中最后一个元素的增删，是没有效率影响的

        14.怎么声明/定义一个数组？
            语法格式：
            int[] array1;
            double[] array2;
            String[] array3;
            boolean[] array4;
            Object[] array5;

        15.怎么初始化一个一维数组？
            包括两种方式：静态初始化一维数组，动态初始化一维数组
            静态初始化语法格式：
                int[] array = {100,21000,300,55};
            动态初始化语法格式：
                int[] array = new int[5] //这里的5表示数组的元素个数（值为默认值）

        16.当创建数组时确定创建哪些具体的数组元素，采用静态初始化方法
           当创建数组时不确定创建哪些具体的数组元素，采用动态初始化方法，先分配空间，后期再赋值

 */

public class ArrayTest01 {

    public static void main(String[] args) {
        //静态初始化方法声明一个int数组类型的数组
        int[] a1 = {1,2,3,4,5};

        //C++风格，不建议java中使用
        //int a1[] = {1,2,3,4,5};

        //所有数组对象都有length属性
        System.out.println("数组中元素的个数" + a1.length);

        //数组中每一个元素都有下标
        //通过下标对数据进行存和取
        //取（读）
        System.out.println("第一个元素" + a1[0]);
        System.out.println("最后一个元素" + a1[a1.length-1]);

        //存（改）
        a1[0] = 0;
        a1[a1.length - 1] =4;
        System.out.println("第一个元素" + a1[0]);
        System.out.println("最后一个元素" + a1[a1.length-1]);

        //一维数组的遍历
        for (int i = 0; i <= a1.length-1 ; i++) {
            System.out.print(a1[i]);
        }

        System.out.println();

        for (int i = a1.length-1; i >= 0; i--) {
            System.out.print(a1[i]);
        }

        //下标越界异常
//        System.out.println(a1[6]); //java.lang.ArrayIndexOutOfBoundsException错误类型
    }
}