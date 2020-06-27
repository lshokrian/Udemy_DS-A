package udemy.DataStructuresAndAlgorithms.bfs;

import udemy.DataStructuresAndAlgorithms.node.GraphNode;

import java.util.ArrayList;

public class BFSbyLinkedList {
    ArrayList<GraphNode> nodeList;

    public BFSbyLinkedList(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }

    // BFS Algorithm
    public void bfs() {
        // if a node is unvisited than run BFS on it
        for (GraphNode node: nodeList) {
            if (!node.isVisited()) {
                bfsVisit(node);
            }
        }
    }

    public void bfsVisit(GraphNode node) {
        ArrayList<GraphNode> queue = new ArrayList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            GraphNode presentNode = queue.remove(0);
            presentNode.setVisited(true);
            System.out.print(presentNode.getName() + " ");
            for (GraphNode neighbor : presentNode.getNeighbors()) {
                if (!neighbor.isVisited()) {
                    queue.add(neighbor);
                    neighbor.setVisited(true);
                }
            }
        }
        System.out.println("");
    }


    // connect vectors
    public void addUndirectedEdge(int indexFirst, int indexSecond) {
        GraphNode first = nodeList.get(indexFirst - 1);
        GraphNode second = nodeList.get(indexSecond - 1);
        // add neighbors for first
        first.getNeighbors().add(second);
        // add neighbors for second
        second.getNeighbors().add(first);
    }
}
