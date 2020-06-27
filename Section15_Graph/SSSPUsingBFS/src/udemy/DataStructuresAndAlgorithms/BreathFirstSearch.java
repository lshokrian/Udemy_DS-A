package udemy.DataStructuresAndAlgorithms;

import java.util.ArrayList;
import java.util.Queue;

public class BreathFirstSearch {
    ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

    public BreathFirstSearch(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }
/*
    public void bfsSearch() {
        for (GraphNode node : nodeList) {
            if (!node.isVisited()) {
                bfsVisit(node);
            }
        }
    }
*/

    public void bfsVisitSSSP(GraphNode node) {
        ArrayList<GraphNode> queue = new ArrayList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            GraphNode presentNode = queue.remove(0);
            presentNode.setVisited(true);
            System.out.print("Printing path for node " + presentNode.getName() + ": ");
            pathPrint(presentNode);
            System.out.println();
            for (GraphNode neighbor : presentNode.getNeighbors()) {
                if (!neighbor.isVisited()) {
                    queue.add(neighbor);
                    neighbor.setParent(presentNode);
                    neighbor.setVisited(true);
                }
            }
        }
    }

    public static void pathPrint(GraphNode node) {
        if (node.getParent() != null) {
            pathPrint(node.getParent()); //recursive call to parent
        }
        System.out.print(node.getName() + " ");
    }

    public void addUndirectedEdge(int index1, int index2) {
        GraphNode first = nodeList.get(index1);
        GraphNode second = nodeList.get(index2);
        first.getNeighbors().add(second);
        second.getNeighbors().add(first);
    }
}
