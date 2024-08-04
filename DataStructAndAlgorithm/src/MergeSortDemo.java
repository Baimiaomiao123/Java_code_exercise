/**
 * @author baimiaomiao
 * @version 1.0
 * @className MergeSortDemo
 * @since 1.0
 */


public class MergeSortDemo {
    public static void main(String[] args) {
        /*
        Merge sort is a sort method recursively divide array in 2, sort, re-combine
        run-time complexity = O(n log n)
        space complexity = O(n)
         */

        int[] array = {8, 2, 5, 3, 4, 7, 6, 1};


        System.out.print("Before merge sort: ");
        for (int i: array) {
            System.out.print(i);
        }

        System.out.println();
        mergeSort(array);

        System.out.print("After merge sort: ");
        for (int i: array) {
            System.out.print(i);
        }

    }


    private static void mergeSort(int[] array) {
        int length = array.length;
        if (length <= 1) return; //base case

        int middle = length / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length-middle];

        int i = 0; // left array
        int j = 0; // right array

        for (; i < length; i++) {
            if (i < middle) {
                leftArray[i] = array[i];
            }else {
                rightArray[j] = array[i];
                j++;
            }
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, array);
    }

    private static void merge(int[] leftArray, int[] rightArray, int[] array){
        int leftSize = array.length / 2;
        int rightSize = array.length - leftSize;

        int i = 0, l = 0, r = 0; // indices

        // check the condition for merging
        while (l < leftSize && r < rightSize){
            if (leftArray[l] < rightArray[r]){
                array[i] = leftArray[l];
                i++;
                l++;
            }else {
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }

        while (l < leftSize) {
            array[i] = leftArray[l];
            i++;
            l++;
        }

        while (r < rightSize) {
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }
}
