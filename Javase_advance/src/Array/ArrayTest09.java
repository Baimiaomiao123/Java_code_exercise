package Array;
/*
    数组循环方法
 */
public class ArrayTest09 {

    //数组循环显示方法
    public static void printArray(int[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void printArray(Object[] array){

        for (int i = 0; i < array.length; i++) {
                System.out.println(array[i]);
        }
    }

    public static void printArray(int[] array){

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }


    public static void main(String[] args) {
        //使用类方法
        printArray(new int[4][4]);
    }
}
