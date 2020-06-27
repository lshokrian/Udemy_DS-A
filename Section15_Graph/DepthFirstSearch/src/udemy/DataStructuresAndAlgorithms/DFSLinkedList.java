package udemy.DataStructuresAndAlgorithms;

import udemy.DataStructuresAndAlgorithms.node.GraphNode;

import java.util.ArrayList;
import java.util.Stack;

public class DFSLinkedList {
    ArrayList<GraphNode> nodeList;

    public DFSLinkedList(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }

    public void dfsIterative() {
        for (GraphNode node : nodeList) {
            if (!node.isVisited()){
                dfsVisitIterative(node);
            }
        }
    }

    public void dfsVisitIterative(GraphNode node){
        Stack<GraphNode> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            GraphNode presetNode = stack.pop();
            presetNode.setVisited(true);

            System.out.print(presetNode.getName() + " ");
            for (GraphNode neighbor : presetNode.getNeighbors()) {
                if (!neighbor.isVisited()){
                    stack.add(neighbor);
                    neighbor.setVisited(true);
                }
            }
        }

        System.out.println("");
    }

    public void dfsRecursive() {
        for (GraphNode node: nodeList) {
            if (!node.isVisited()) {
                dfsVisitRecursive(node);
            }
        }
    }

    public void dfsVisitRecursive(GraphNode node) {
        node.setVisited(true);

        System.out.print(node.getName()+ " ");

        for (GraphNode neighbor : node.getNeighbors()) {
            if (!neighbor.isVisited()) {
                dfsVisitRecursive(neighbor);
            }
        }
    }


    public void addUndirectedEdge(int indexFirst, int indexSecond) {
        GraphNode nodeFirst = nodeList.get(indexFirst-1);
        GraphNode nodeSecond = nodeList.get(indexSecond-1);

        nodeFirst.getNeighbors().add(nodeSecond);
        nodeSecond.getNeighbors().add(nodeFirst);
    }
}
