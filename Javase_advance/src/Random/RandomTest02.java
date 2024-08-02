package Random;

import java.util.Arrays;
import java.util.Random;

/*
    编写程序，生成5个不重复的随机数(0-200)，重复的话重新生成
    最终生成的5个随机数中，要求数组中这5个随机数不重复
 */
public class RandomTest02 {

    public static void main(String[] args) {
        //创建Random对象
        Random random = new Random();
        //用于装生成的5个随机数
        int[] arr = new int[5]; //默认值都是0
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }

        //准备下标
        int index = 0;

        //
        int count = 0;
        //循环，生成随机数
        while (index < arr.length) {
            int num = random.nextInt(5);
            count ++;

            if(! contains(arr,num)){
                arr[index ++] = num;
            }
        }

        //遍历以上数组
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
        System.out.println("循环次数为：" + count);
    }

    //单独编写一个方法，这个方法专门用于判断数组是否包含某个元素
    public static boolean contains(int[] arr,int key){

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == key){
                return true; //说明包含，返回值为true
            }
        }

        return false; //说明不包含，返回值为false


        /*
        //这方案有bug，前面一定是-1
        //升序
        Arrays.sort(arr);
        //进行二分法查找
        //二分法茶渣奥的结果>=0说明，这个元素找到，表示存在/包含
        return Arrays.binarySearch(arr,key) >= 0;
         */
    }
}
