package Arrays;

import java.util.Arrays;

/*
    二分法查找：
        1.基于排序的基础之上
        2.从一组数组中找出中间的数进行比较，目标元素小于中间数，则在左边区间进一步查找；大于中间数，则在右边区间进一步查找
        3.
 */
public class ArraysBinarySearchTest {

    public static void main(String[] args) {
        int[] arr = {100,200,300,400,500,600};
        System.out.println(Arrays.toString(arr));

        int i = 400;
        int index = BinarySearch(arr,i);
        System.out.println(i +"在该数组的下标为" + (index == -1? "该数组没有该元素":index));


    }

    /**
     *  二分法查找（前提：数据经过排序）
     * @param arr 被查找的数组
     * @param i 查找的目标值
     * @return 目标值在数组中所对应的下标
     */
    public static int BinarySearch(int[] arr, int i) {
        //为保证二分法运行成功，可以先利用java.util包Arrays类的sort方法，对传入的数组进行排序
        Arrays.sort(arr);
        //开始元素的下标
        int begin = 0;
        //结束下标
        int end = arr.length - 1;
        while (begin <= end) { //当end > begin时，说明程序迭代结束
            //中间元素下标
            int mid = (begin + end) / 2;
            if (arr[mid] == i) {
                return mid; //中间下标的值恰好为目标值，则直接返回目标值对应的下标
            } else if (arr[mid] < i) {
                begin = mid + 1; //中间下标的值小于目标值，说明目标值对应的下标在数组的偏右侧
            } else {
                end = mid - 1; //中间下标的值大于目标值，说明目标值对应的下标在数组的偏左侧
            }
        }
        return -1; //程序执行值此处，说明该数组中不存在该目标值，返回-1
    }

}
