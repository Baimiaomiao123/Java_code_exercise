import java.util.*;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className Application
 * @since 1.0
 */


public class Application {
    public static void main(String[] args) {
        System.out.println("============================== Stack ==============================");
        Stack<String> stack = new Stack<String>();

        // check if the stack is empty or not
        System.out.println(stack.empty());

        // push() method for adding element
        stack.push("Minecraft");
        stack.push("Skyrim");
        stack.push("DOOM");
        stack.push("Broderlands");
        stack.push("FFVII");

        System.out.println(stack.empty());

        // print the list of the stack
        System.out.println(stack);

        // pop() method for remove the element
        String myFavGame = stack.pop();

        System.out.println(stack);
        // peek() method for returning the last element in the stack
        System.out.println(stack.peek());
        System.out.println(myFavGame);

        // search() method for returning the index of the element in stack, in which the index from the top to bottom
        System.out.println(stack.search("Broderlands")); // The "Broderlands" is last element in the stack now, so it will return 1
        System.out.println(stack.search("DNF")); // It will return -1 when the element is not in the stack

        // print all elements in stack by For loops structure or For-each loops structure
        for (int i = 0; i < stack.size(); i++) {
            System.out.println(stack.get(i));
        }

        System.out.println("==============================");

        for (String element : stack) {
            System.out.println(element);
        }

        System.out.println("============================== Queue ==============================");

        Queue<String> queue = new LinkedList<>();

        System.out.println("The queue is empty? "+ queue.isEmpty());

        // add elements into queue
        queue.offer("Karen");
        queue.offer("Chad");
        queue.offer("Steve");
        queue.offer("Harold");

        System.out.println("The queue is empty? "+ queue.isEmpty());

        System.out.println(queue);
        System.out.println(queue.peek());

        // remove the elements from bottom to top(First-in, First-out)
        queue.poll();
        queue.poll();

        System.out.println(queue);
        System.out.println("Does the queue contain Steve? " + queue.contains("Steve"));
        System.out.println("Does the queue contain Karen? " + queue.contains("Karen"));

        System.out.println("============================== Priority Queue ==============================");
        /* Priority Queue is a FIFO data structure that serves elements with the highest priorities first
            than elements with lower priority
        */
        // Queue<Double> queue1 = new PriorityQueue<>();
        // The parameter you input(Collections.reverseOrder()) is to reverse the order
        Queue<Double> queue1 = new PriorityQueue<>(Collections.reverseOrder());

        queue1.offer(3.0);
        queue1.offer(2.5);
        queue1.offer(4.0);
        queue1.offer(1.5);
        queue1.offer(2.0);

        // remove and print the elements we have stored in the queue before
        while (!queue1.isEmpty()) {
            System.out.println(queue1.poll());
        }

        System.out.println("==============================");
        Queue<String> queue2 = new PriorityQueue<>(Collections.reverseOrder());

        queue2.offer("B");
        queue2.offer("C");
        queue2.offer("A");
        queue2.offer("F");
        queue2.offer("D");

        while (!queue2.isEmpty()) {
            System.out.println(queue2.poll());
        }

        System.out.println("============================== Linked List ==============================");
        /* LinkedList stores nodes in 2 parts (data + address), where nodes are in non-consecutive memory locations and
            elements are linked using pointers. And we have two types of linked list: singly linked list and doubly linked list
                               Singly Linked List
               AdjacencyMatrix.Node                 AdjacencyMatrix.Node                AdjacencyMatrix.Node
           [data | address] -> [data | address] -> [data | address]

                               Doubly Linked List
                      AdjacencyMatrix.Node                             AdjacencyMatrix.Node
           [address | data | address] < - > [address | data | address]

            advantages?
            1. Dynamic Data Structure (allocates needed memory while running)
            2. Insertion and Deletion of Nodes is easy. O(1)
            3. No/Low memory waste

            disadvantage?
            1. Greater memory usage (additional pointer)
            2. No random access of elements (no index [i])
            3. Accessing/searching elements is more time consuming. O(n)

            Users?
            1. implement Stacks/Queues
            2. GPS navigation
            3. music playlist
        */
        LinkedList<String> linkedList = new LinkedList<>();
        LinkedList<String> linkedList1 = new LinkedList<>();


        // push() method and pop() method
        // adding elements
        linkedList.push("A");
        linkedList.push("B");
        linkedList.push("C");
        linkedList.push("D");
        linkedList.push("F");

        System.out.println("Initial elements: " + linkedList);
        // remove elements
        linkedList.pop();
        linkedList.pop();

        System.out.println("After removing elements: " + linkedList);

        System.out.println("==============================");
        // push() method and pop() method
        // adding elements
        linkedList1.offer("A");
        linkedList1.offer("B");
        linkedList1.offer("C");
        linkedList1.offer("D");
        linkedList1.offer("F");

        linkedList1.add(4, "E");
        linkedList1.remove("E");

        // check the first element
        System.out.println(linkedList1.peekFirst()); // A
        // check the last element
        System.out.println(linkedList1.peekLast()); // F

        linkedList1.addFirst("0");
        linkedList1.addLast("G");
        linkedList1.removeFirst();
        linkedList1.removeLast();

        System.out.println("Initial elements: " + linkedList1);
        // remove elements
        linkedList1.poll();
        linkedList1.poll();

        System.out.println("After removing elements: " + linkedList1);

        System.out.println("============================== Dynamic Array ==============================");
        DynamicArray dynamicArray = new DynamicArray(5);

        // check whether the dynamic array is empty or not
        System.out.println("empty: " + dynamicArray.isEmpty());

        // add element
        dynamicArray.add("A");
        dynamicArray.add("B");
        dynamicArray.add("C");

        System.out.println("empty: " + dynamicArray.isEmpty());

        // print the dynamic array
        System.out.println(dynamicArray);

        // access the size and capacity of dynamic array
        System.out.println("The size of the dynamic array is " + dynamicArray.getSize() +
                "; The capacity of the dynamic array is " + dynamicArray.getCapacity());

        System.out.println("==============================");
        // insert the elements by index
        dynamicArray.insert(0, "X");

        // print the dynamic array
        System.out.println(dynamicArray);

        // access the size and capacity of dynamic array
        System.out.println("The size of the dynamic array is " + dynamicArray.getSize() +
                "; The capacity of the dynamic array is " + dynamicArray.getCapacity());

        dynamicArray.delete("A");
        // print the dynamic array
        System.out.println("After deleting the A, the dynamic are " + dynamicArray);

        System.out.println("The index of element C in dynamic array is " + dynamicArray.search("C"));

        // expand the capacity of dynamic array
        dynamicArray.add("D");
        dynamicArray.add("E");
        dynamicArray.add("F");

        System.out.println("After adding three elements into the old array, now the capacity of the new array is " + dynamicArray.getCapacity());

        System.out.println("==============================");

        dynamicArray.delete("D");
        dynamicArray.delete("E");
        dynamicArray.delete("F");

        System.out.println("After deleting three elements into the old array, now the capacity of the new array is " + dynamicArray.getCapacity());




    }
}
