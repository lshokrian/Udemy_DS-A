package udemy.DataStructuresAndAlgorithms.bfs;

import udemy.DataStructuresAndAlgorithms.node.GraphNode;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Will store Nodes in this list
        ArrayList<GraphNode> nodeList = new ArrayList<>();

        // Create 10 nodes: V1 - 10
        for (int i = 1; i < 11; i++) {
            nodeList.add(new GraphNode("V" + i, i - 1));
        }

        // Pass Graph array list for further processing
        BFSbyLinkedList graph = new BFSbyLinkedList(nodeList);

        graph.addUndirectedEdge(1, 2);
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

        System.out.println("Print BFS from source: V1");
        graph.bfs();

        ArrayList<GraphNode> nodeListAA = new ArrayList<>();

        for (int i = 1; i < 11; i++) {
            nodeListAA.add(new GraphNode("V" + i, i -1));
        }

        BFSbyAdjacencyMatrix graphAA = new BFSbyAdjacencyMatrix(nodeListAA);

        graphAA.addUndirectedEdge(1,2);
        graphAA.addUndirectedEdge(1,4);
        graphAA.addUndirectedEdge(2,3);
        graphAA.addUndirectedEdge(2,5);
        graphAA.addUndirectedEdge(3,6);
        graphAA.addUndirectedEdge(3,10);
        graphAA.addUndirectedEdge(4,7);
        graphAA.addUndirectedEdge(5,8);
        graphAA.addUndirectedEdge(6,9);
        graphAA.addUndirectedEdge(7,8);
        graphAA.addUndirectedEdge(8,9);
        graphAA.addUndirectedEdge(9,10);

        System.out.println("Print BFS from Adjacency Matrix");
        graphAA.bfs();


    }
}
