package Arrays;
import java.util.Arrays;
import Array.*;
/*
    java.util.Arrays工具类：
        SUN公司已经为数组写好了一个工具类，可以用于数组中的数据处理

 */
public class ArraysUtilTest {

    public static void main(String[] args) {
        int[] a = {1,5,7,4,7,8,9,4,3};
        ArrayTest09.printArray(a);

        System.out.println();

        int index =  Arrays.binarySearch(a,9);
        System.out.println(index);
    }

}
