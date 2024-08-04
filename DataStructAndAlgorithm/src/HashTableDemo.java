import java.util.Hashtable;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className HashTableDemo
 * @since 1.0
 */


public class HashTableDemo {
    public static void main(String[] args) {
        /*
        Hash table is a data structure that stores unique keys to values ex.<Integer, String>
        Each key/value pair is known as an Entry
        FAST insertion, look up, deletion of key/value pairs
        Not ideal for small data sets, great with large data sets

        Hashing takes a key and computes an integer (formula will vary based on key & data type)
        In a HashTable, we use the hash % capacity to calculate an index number(index = key.hashCode() % capacity)

        Bucket is an indexed storage location for one or more entries, which can store multiple entries in case of a collision (linked similarly a LinkedList)

        Collision is hash function generates the same index for more than one key(less collisions = more efficiency)

        Runtime complexity: Best Case O(1)
                            Worst Case O(n)

         */

//        Hashtable<Integer, String> table = new Hashtable<>(10);
//
//        table.put(100, "Spongebob");
//        table.put(123, "Patrick");
//        table.put(321, "Sandy");
//        table.put(555, "Squidward");
//        table.put(777, "Gary");
//
//        //table.remove(777);
//
//        for (Integer key : table.keySet()) {
//            System.out.println(key.hashCode() % 10 + "\t" + key + "\t" + table.get(key));
//        }

        Hashtable<String, String> table = new Hashtable<>(10);

        table.put("100", "Spongebob");
        table.put("123", "Patrick");
        table.put("321", "Sandy");
        table.put("555", "Squidward");
        table.put("777", "Gary");

        //table.remove("777");

        for (String key : table.keySet()) {
            System.out.println(key.hashCode() % 12 + "\t" + key + "\t" + table.get(key));
        }
    }
}
