package udemy.DataStructuresAndAlgorithms;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<GraphNode> nodeList = new ArrayList<>();

        for (int i = 1; i < 9; i++) {
            nodeList.add(new GraphNode("V" + i, i -1));
        }

        TopologicalGraph graph = new TopologicalGraph(nodeList);

        graph.addDirectedEdge(1,3);
        graph.addDirectedEdge(2,3);
        graph.addDirectedEdge(2,4);
        graph.addDirectedEdge(3,5);
        graph.addDirectedEdge(4,6);
        graph.addDirectedEdge(5,6);
        graph.addDirectedEdge(5,8);
        graph.addDirectedEdge(6,7);

        System.out.println("Printing Topological Sort");
        graph.sort();

    }
}
