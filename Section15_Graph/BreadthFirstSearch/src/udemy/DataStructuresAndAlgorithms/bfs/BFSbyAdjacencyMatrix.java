package udemy.DataStructuresAndAlgorithms.bfs;

import udemy.DataStructuresAndAlgorithms.node.GraphNode;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.LinkedList;

public class BFSbyAdjacencyMatrix {
    ArrayList<GraphNode> nodeList = new ArrayList<>();
    int [][] adjacencyMatrix;

    public BFSbyAdjacencyMatrix(ArrayList<GraphNode> nodeList){
        this.nodeList = nodeList;
        adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
    }

    //BFS Algorithm
    void bfs() {
        for (GraphNode node: nodeList) {
            if (!node.isVisited())
                bfsVisit(node);
        }
    }

    void bfsVisit(GraphNode node) {
        LinkedList<GraphNode> queue = new LinkedList<>();

        queue.add(node);
        while (!queue.isEmpty()) {
            GraphNode presentNode = queue.remove(0);
            presentNode.setVisited(true);
            System.out.print(presentNode.getName() + " ");

            ArrayList<GraphNode> neighbors = getNeighbors(presentNode);
            for (GraphNode neighbor : neighbors) {
                if (!neighbor.isVisited()) {
                    queue.add(neighbor);
                    neighbor.setVisited(true);
                }
            }
        }
        System.out.println("");
    }

    public ArrayList<GraphNode> getNeighbors(GraphNode node) {
        ArrayList<GraphNode> neighbors = new ArrayList<>();

        int nodeIndex = node.getIndex();

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            // if a column has 1 in that row than there is a neighbors and add it to list
            if(adjacencyMatrix[nodeIndex][i] == 1) {
                neighbors.add(nodeList.get(i));
            }
        }
        return neighbors;
    }



    // Add UndirectedEdge
    public void addUndirectedEdge(int firstIndex, int secondIndex) {
        firstIndex--;
        secondIndex--;
        adjacencyMatrix[firstIndex][secondIndex] = 1;
        adjacencyMatrix[secondIndex][firstIndex] = 1;
    }
}
