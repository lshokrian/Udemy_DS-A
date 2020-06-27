package udemy.DataStructuresAndAlgorithms;

import udemy.DataStructuresAndAlgorithms.node.GraphNode;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {

        ArrayList<GraphNode> nodeList = new ArrayList<>();

        for (int i = 1; i < 11; i++) {
            nodeList.add(new GraphNode("V" + i, i -1));
        }

        DFSLinkedList graph = new DFSLinkedList(nodeList);

        graph.addUndirectedEdge(1,2);
        graph.addUndirectedEdge(1,4);
        graph.addUndirectedEdge(2,3);
        graph.addUndirectedEdge(2,5);
        graph.addUndirectedEdge(3,6);
        graph.addUndirectedEdge(3,10);
        graph.addUndirectedEdge(4,7);
        graph.addUndirectedEdge(5,8);
        graph.addUndirectedEdge(6,9);
        graph.addUndirectedEdge(7,8);
        graph.addUndirectedEdge(8,9);
        graph.addUndirectedEdge(9,10);

        System.out.println("Printing DFS using LinkedList and Iterative Method");
        graph.dfsIterative();


        ArrayList<GraphNode> nodeListR = new ArrayList<>();

        for (int i = 1; i < 11; i++) {
            nodeListR.add(new GraphNode("V" + i));
        }

        DFSLinkedList graphR = new DFSLinkedList(nodeListR);

        graphR.addUndirectedEdge(1,2);
        graphR.addUndirectedEdge(1,4);
        graphR.addUndirectedEdge(2,3);
        graphR.addUndirectedEdge(2,5);
        graphR.addUndirectedEdge(3,6);
        graphR.addUndirectedEdge(3,10);
        graphR.addUndirectedEdge(4,7);
        graphR.addUndirectedEdge(5,8);
        graphR.addUndirectedEdge(6,9);
        graphR.addUndirectedEdge(7,8);
        graphR.addUndirectedEdge(8,9);
        graphR.addUndirectedEdge(9,10);

        System.out.println("Printing DFS using LinkedList and Recursive Method");
        graphR.dfsRecursive();

    }
}
