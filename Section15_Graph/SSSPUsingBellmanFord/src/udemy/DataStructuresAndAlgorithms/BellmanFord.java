package udemy.DataStructuresAndAlgorithms;

import java.util.ArrayList;

public class BellmanFord {
    ArrayList<WeightedGraphNode> nodeList;

    public BellmanFord(ArrayList<WeightedGraphNode> nodeList) {
        this.nodeList = nodeList;
        for(WeightedGraphNode node: nodeList) {
            node.setDistance(Integer.MAX_VALUE/10);
        }
    }

    public void bellmanFordFindPath(WeightedGraphNode sourceNode){
        sourceNode.setDistance(0);

        for (int i = 1; i < nodeList.size(); i++) {
            for (WeightedGraphNode presentNode : nodeList) {
                for (WeightedGraphNode neighbor : presentNode.getNeighbors()) {
                    if (neighbor.getDistance() > (presentNode.getDistance() + presentNode.getWeightMap().get(neighbor))) {
                        neighbor.setDistance(presentNode.getDistance() + presentNode.getWeightMap().get(neighbor));
                        neighbor.setParent(presentNode);
                    } //if neighbor distance > present distance + edge between present & neighbor
                } //for each neighbor of current node
            } //for each node in graph
        } //for total nodes - 1 times

        //check for negative loop
        System.out.println("Checking for Negative Cycle...");
        //for each node check if update is possible, if true then negative cycle is there: report error
        for (WeightedGraphNode presentNode: nodeList) {
            for (WeightedGraphNode neighbor : presentNode.getNeighbors()) {
                if (neighbor.getDistance() > presentNode.getDistance() + presentNode.getWeightMap().get(neighbor)) {
                    System.out.println("Negative cycle found: \n");
                    System.out.println("Vertex Name: " + neighbor.getName());
                    System.out.println("Old Distance: " + neighbor.getDistance());
                    int newDistance = presentNode.getDistance() + presentNode.getWeightMap().get(neighbor);
                    System.out.println("New Distance: " + newDistance);
                    return;
                }
            }
        }

        System.out.println("Negative cycle not found!");

        //Print table of node with minimum distance and shortest path from source
        System.out.println("Printing Paths: ");
        for (WeightedGraphNode nodeToCheck : nodeList) {
            if (nodeToCheck.getDistance() != Integer.MAX_VALUE/10) {
                System.out.print("Node " + nodeToCheck.getName() + ", distance: " + nodeToCheck.getDistance() + ", Path: " );
                pathPrint(nodeToCheck);
            } else {
                System.out.print("No path for node: " + nodeToCheck);
            }
            System.out.println();
        }
    }

    public static void pathPrint(WeightedGraphNode node) {
        if (node.getParent() != null) {
            pathPrint(node.getParent());
            System.out.print("->" + node.getName());
        } else {
            System.out.print(node);
        }
    }

    public void addWeightedEdge(int i, int j, int d) {
        WeightedGraphNode first = nodeList.get(i - 1);
        WeightedGraphNode second = nodeList.get(j - 1);
        first.getNeighbors().add(second);
        first.getWeightMap().put(second, d); //put wait for edge between first to second node
    }
}
