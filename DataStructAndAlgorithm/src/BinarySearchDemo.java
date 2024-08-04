import java.util.Arrays;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className BinarySearchDemo
 * @since 1.0
 */


public class BinarySearchDemo {
    public static void main(String[] args) {
        int[] array = new int[100];
        int target = 42;

        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        int index = BinarySearch(array, target);
        // or Using the java.utils.Arrays method
        //index = Arrays.binarySearch(array, target);

        if (index != -1){
            System.out.println("We have found the element in a array at location: " + index);
        } else {
            System.out.println("We haven't found the element in a array");
        }

    }

    private static int BinarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - 1);

            // check middle element
            if (array[mid] == target){
                return mid;
            }

            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }


}
