/**
 * @author baimiaomiao
 * @version 1.0
 * @className LinearSearchDemo
 * @since 1.0
 */


public class LinearSearchDemo {
    public static void main(String[] args) {
        /*
        Linear search is simple algorithm in which iterate through a collection one element at a time
        The runtime complexity: O(n)

        Disadvantages:
            Slow for large data sets

        Advantages:
            Fast for searches of small to medium data sets
            Does not need to sorted
            Useful for data structures that do not have random access(Linked List)
         */

        int[] array = {9, 1, 8, 2, 7, 3, 6, 4, 5};
        int index = LinearSearch(array, 8);
        if (index != -1){
            System.out.println("We have found element in index of " + index + " in the array");
        } else {
            System.out.println("We haven't found the index of the element in the array");
        }

    }

    private static int LinearSearch(int[] array, int value) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] == value){
                return i;
            }
        }

        return -1;
    }
}
