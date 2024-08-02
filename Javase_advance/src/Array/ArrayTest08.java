package Array;

/*
    java中的二维数组：
        1.二维数组其实是一个特殊一维数组，特殊在这个一维数组当中每一个元素都是一个一维数组

        2.三维数组其实是一个特殊二维数组，特殊在这个二维数组当中每一个元素都是一个二维数组

        3.关于二维数组的读和改
          读：a[二维数组中的一维数组的下标][一位数组中元素的下标]
             a[0][0]：二维数组中第一个一位数组中第一个元素的值
          改：a[二维数组中的一维数组的下标][一位数组中元素的下标] = 待修改的值

 */
public class ArrayTest08 {
    public static void main(String[] args) {
        //二维数组
        int[][] a = {{1,2,3,4},{4,5,6},{7,8,9}};
        System.out.println(a.length); //描述的是二维数组中一维数组的个数 3
        System.out.println(a[0].length); //描述的二维数组中第一个一维数组的元素个数 4

        //三维数组
        int[][][] b = {{{1,2,6,7,8,8,9},{3,4},{5,6},{1,2,3},{7,8,9}},
                        {{1,2},{3,4}},
                        {{1,2},{3,4}}
        };
        System.out.println(b.length); //描述的三维数组中二维数组的个数 3
        System.out.println(b[0].length); //描述的三维数组中第一个二维数组的元素个数 5
        System.out.println(b[0][0].length); //描述的是三维数组中第一个二维数组中第一个一维数组的元素个数 7

        //元素的读和取：
        //改a中的第3个二维数组的第2个元素为32，并读
        a[2][1] = 32;
        int a_32 = a[2][1];
        System.out.println(a_32);

        //分割线
        System.out.println("=========================");
        //遍历二维数组
        for (int i = 0; i < a.length; i++) {
            //内存循环负责输出一行
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + "\t");
            }

            //输出换行符
            System.out.println();
        }

    }
}
