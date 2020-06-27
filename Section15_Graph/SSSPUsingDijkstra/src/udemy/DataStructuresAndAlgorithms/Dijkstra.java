package udemy.DataStructuresAndAlgorithms;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra {
    ArrayList<WeightedGraphNode> nodeList = new ArrayList<>();

    public Dijkstra(ArrayList<WeightedGraphNode> nodeList) {
        this.nodeList = nodeList;
    }

    public void dijkstraFindPath(WeightedGraphNode node) {
        PriorityQueue<WeightedGraphNode> queue = new PriorityQueue<>();
        node.setDistance(0); //Distance is 0 from first node
        queue.addAll(nodeList);
        while(!queue.isEmpty()) {
            WeightedGraphNode presentNode = queue.remove();
            for (WeightedGraphNode neighbor : presentNode.getNeighbors()) {
                if (queue.contains(neighbor)) {
                    if (neighbor.getDistance() > (presentNode.getWeightMap().get(neighbor))) {
                        neighbor.setDistance(presentNode.getDistance()+presentNode.getWeightMap().get(neighbor));
                        neighbor.setParentNode(presentNode);
                        queue.remove(neighbor); // so that the queue rehashes
                        queue.add(neighbor);
                    } // if (neighbor > current distance + currentEdge)
                } // if queue contains
            } // for loop neighbors
        } //end of while loop


        for(WeightedGraphNode nodeToCheck: nodeList) {
            System.out.print("Node " + nodeToCheck + ", distance: " + nodeToCheck.getDistance() + ", Path:");
            pathPrint(nodeToCheck);
            System.out.println();
        }
    }

    private static void pathPrint(WeightedGraphNode node) {
        if (node.getParentNode() != null) {
            pathPrint(node.getParentNode());
            System.out.print("->" + node);
        } else {
            System.out.print(node);
        }
    }

    public void addWeightedEdge(int i, int j, int d) {
        WeightedGraphNode first = nodeList.get(i-1);
        WeightedGraphNode second = nodeList.get(j-1);
        first.getNeighbors().add(second);
        first.getWeightMap().put(second, d);
    }
}
