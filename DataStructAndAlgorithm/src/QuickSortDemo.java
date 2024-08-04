/**
 * @author baimiaomiao
 * @version 1.0
 * @className QuickSortDemo
 * @since 1.0
 */


public class QuickSortDemo {
    public static void main(String[] args) {
        /*
        Quick sort is a sort method moves smaller elements to left of a pivot with recursively divide array in 2 partition

        run-tim complexity = Best case O(n log n)
                             Average case O(n log n)
                             Worst case O(n^2) if already sorted
        space complexity = O(log n) due to recursion
         */
        int[] array = {8, 2, 5, 3, 4, 7, 6, 1};


        System.out.print("Before merge sort: ");
        for (int i: array) {
            System.out.print(i);
        }

        System.out.println();
        quickSort(array, 0, array.length - 1);

        System.out.print("After merge sort: ");
        for (int i: array) {
            System.out.print(i);
        }

    }

    private static void quickSort(int[] array, int start, int end) {
        if(end <= start) return; //base case;

        int pivot = partition(array, start, end);
        quickSort(array, start, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if(array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        i++;
        int temp = array[i];
        array[i] = array[end];
        array[end] = temp;

        return i;

    }
}
