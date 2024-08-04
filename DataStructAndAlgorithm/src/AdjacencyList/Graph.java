package AdjacencyList;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className Graph
 * @since 1.0
 */


public class Graph {

    ArrayList<LinkedList<Node>> aList;

    public Graph() {
        this.aList = new ArrayList<>();
    }

    public void addNode(Node node) {
        LinkedList<Node> currentList = new LinkedList<>();
        currentList.add(node);
        aList.add(currentList);
    }

    public void addEdge(int src, int dst) {
        LinkedList<Node> currentList = aList.get(src);
        Node dstNode = aList.get(dst).get(0);
        currentList.add(dstNode);

        //aList.get(src).add(dstNode);

    }

    public boolean checkEdge(int src, int dst) {
        LinkedList<Node> currentList = aList.get(src);
        Node dstNode = aList.get(dst).get(0);

        for (Node node :
                currentList) {
            return node == dstNode;
        }

        return false;
    }

    public void print() {
        for (LinkedList<Node> currentList : aList) {
            for (Node node : currentList) {
                System.out.print(node.data + "->");
            }
            System.out.println();
        }
    }
}
