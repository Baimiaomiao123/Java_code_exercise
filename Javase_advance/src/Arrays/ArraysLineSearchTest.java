package Arrays;

import java.awt.desktop.SystemEventListener;
import java.util.Scanner;

/*
    顺序查找法：
        将所要查找的元素与数组中的元素一一比对
 */
public class ArraysLineSearchTest {
    public static void LineSearch(int[] array){
        System.out.println("请输入你所需要查找的元素的值：");

        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num){
                System.out.println("该元素存在，且该元素的下标为：" + i);
                return;
            }
        }

        //程序执行至此，说明列表中没有所要查找的元素
        System.out.println("该数组不存在该元素");
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        LineSearch(a);
    }
}
