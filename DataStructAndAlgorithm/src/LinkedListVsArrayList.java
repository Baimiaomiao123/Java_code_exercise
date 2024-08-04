import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className LinkedListVsArrayList
 * @since 1.0
 */


public class LinkedListVsArrayList {
    public static void main(String[] args) {
        /*
        Comparing the running time of linkedList and arrayList
         */
        LinkedList<Integer> linkedList = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        long startTime;
        long endTime;
        long elapsedTime;

        for (int i = 0; i < 1000000; i++) {
            linkedList.add(i);
            arrayList.add(i);
        }
        // *****************************Linked List*****************************
        startTime = System.nanoTime();

        // linkedList.get(0);
        // linkedList.get(500000);
        // linkedList.get(999999);
        // linkedList.remove(0);
        // linkedList.remove(500000);
        linkedList.remove(999999);

        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("LinkedList:\t" + elapsedTime + " ns");
        // *****************************Array List*****************************
        startTime = System.nanoTime();

        // arrayList.get(0);
        // arrayList.get(500000);
        // arrayList.get(999999);
        // arrayList.remove(0);
        //arrayList.remove(500000);
        arrayList.remove(999999);

        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("ArrayList:\t" + elapsedTime + " ns");
    }
}
