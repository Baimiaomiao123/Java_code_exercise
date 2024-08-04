package AdjacencyMatrix;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className AdjacencyMatrix.GraphDemo
 * @since 1.0
 */


public class GraphDemo {
    public static void main(String[] args) {
        /*
        Adjacency matrix is an array to store 1's/0's to represent edges
                                           # of rows = # of unique nodes
                                           # of columns = # of unique nodes

        runtime complexity to check an Edge: O(1)
        space complexity: O(v^2)
         */

        Graph graph = new Graph(5);

        graph.addNode(new Node('A'));
        graph.addNode(new Node('B'));
        graph.addNode(new Node('C'));
        graph.addNode(new Node('D'));
        graph.addNode(new Node('E'));

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 0);
        graph.addEdge(4, 2);

        graph.print();

        System.out.println("====================================");


        /*
        Adjacency List is an array/arraylist of linkedlist
        Each LinkedList has a unique node at the head
        All adjacency neighbors to that node are added to that node's linkedlist

        runtime complexity to check an Edge: O(v)
        space complexity: O(v+e)
         */


    }
}
