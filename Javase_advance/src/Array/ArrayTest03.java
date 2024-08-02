package Array;


public class ArrayTest03 {

    //main方法的编写方式，还可以采用c++的语法格式
    public static void main(String[] args) {
        System.out.println("Hello World!");

        //调用方法
        int[] x = {1, 2, 3, 4};
        printArray(x);
        String[] s = new String[10];
        printArray(s);

        //方法重载
        System.out.println("============");
        printArray(new String[2]);
        printArray(new int[2]);

        System.out.println("============");
        //没有这种语法：printArray[{1,2,3}]
        //另外一种特别的语法(如果要传递一个静态数组的话，必须这样写)
        printArray(new int[4]); //动态数组
        printArray(new int[]{1,2,3,4}); //静态数组
    }

    public static void printArray(int[] array) {
        for (int i = 0; i <= array.length - 1; i++) {
            System.out.println(array[i]);
        }
    }

    public static void printArray(String[] args) {
        for (int i = 0; i <= args.length - 1; i++) {
            System.out.println(args[i]);
        }

    }
}
