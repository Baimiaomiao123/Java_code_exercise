/**
 * @author baimiaomiao
 * @version 1.0
 * @className InterpolationSearchDemo
 * @since 1.0
 */


public class InterpolationSearchDemo {
    public static void main(String[] args) {
        /*
        Interpolation search is improvement over binary search best used for "uniformly" distributed data
        "guesses" where a value might be based on calculated probe results
        if probe is incorrect, search area is narrowed, and a new probe is calculated

        average case: O(log(logn))
        worst case: O(n) [values increase exponentially]
         */

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int index = interpolationSearch(array, 8);

        if (index != -1){
            System.out.println("We have found the element in a array at location: " + index);
        } else {
            System.out.println("We haven't found the element in a array");
        }
    }

    private static int interpolationSearch(int[] array, int value) {
        int high = array.length - 1;
        int low = 0;

        while (value >= array[low] && value <= array[high] && low <= high){
            int probe = low + (high - low) * (value - array[low]) / (array[high] - array[low]);
            if (array[probe] == value) {
                return probe;
            } else if (array[probe] < value) {
                low = probe + 1;
            } else {
                high = probe - 1;
            }
        }
        return -1;
    }
}
