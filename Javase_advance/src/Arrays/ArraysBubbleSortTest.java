package Arrays;

import Array.ArrayTest09;

/*
    选择排序法：
        每一次从每一堆数据中找到最小的元素放到最前面

        比冒泡排序法好在：每一次的交换位置都是有意义的
 */
public class ArraysBubbleSortTest {
    public static void ExchangeSort(int[] arr){

        int count = 0;
        int count2= 0;
        //n个元素，循环n-1次【arr.length - 1】
        for (int i = 0; i < arr.length - 1; i++) {

            //假设第一个元素最小
            int min = i;

            for (int j = i + 1; j < arr.length; j++) {
                count++;
                //交换数据的下标
                if (arr[j] < arr[min]){
                    min = j; //最小的元素下标是j，将其交换
                }

            }

            //如果i和min相等，不需要交换，i和min不相等，则需要交换位置
            if(i != min){
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
                count2++;
            }
        }
        System.out.println("循环次数为：" + count);
        System.out.println("交换次数为：" + count2);
    }

    public static void main(String[] args) {
        int[] a= {5,7,0,1,4};
        ArrayTest09.printArray(a);

        System.out.println();

        ExchangeSort(a);
        ArrayTest09.printArray(a);
    }
}
