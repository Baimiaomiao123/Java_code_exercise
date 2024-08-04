package AdjacencyMatrix;

import java.util.ArrayList;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className AdjacencyMatrix.Graph
 * @since 1.0
 */


public class Graph {
    int[][] matrix;
    ArrayList<Node> nodes;

    public Graph(int size) {
        nodes = new ArrayList<>();
        matrix = new int[size][size];
    }

    public Graph() {
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public void addEdge(int src, int dst) {
        matrix[src][dst] = 1;
    }

    public boolean checkEdge(int src, int dst) {
        return matrix[src][dst] == 1;
    }

    public void print() {
        System.out.print("  ");
        for (Node node : nodes) {
            System.out.print(node.data + " ");
        }
        System.out.println();

        for (int i = 0; i < matrix.length; i++) {
            System.out.print(nodes.get(i).data + " ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
