package Arrays;
import Array.ArrayTest09;
/*
    冒泡排序算法：
        在一个维度上面，每次拿一个数据与后面一个数据比大小，取大的结果又与后续作比较，然后不断循环
        1.每一次循环之后，都要找出最大的数据，放到参与比较的这堆数据的最右边（冒出最大的气泡）

 */
public class ArraysExchangeSortTest {
    public static void main(String[] args) {
        int[] arr = {3,2,7,6,8};
        ArrayTest09.printArray(arr);

        //换行
        System.out.println();

        BubbleSort(arr);
        //调用所写的遍历数组方法
        ArrayTest09.printArray(arr);

    }

    //冒泡算法
    public static void BubbleSort(int[] array){
        for (int i = 0; i < array.length - 1; i++) {

            for (int j = 0; j < array.length - 1 - i; j++) {

                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }

        }
    }
}
