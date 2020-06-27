package udemy.DataStructuresAndAlgorithms;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

public class TopologicalGraph {
    ArrayList<GraphNode> graph = new ArrayList<GraphNode>();

    public TopologicalGraph(ArrayList<GraphNode> nodeList) {
        this.graph = nodeList;
    }

    public void sort() {
        Stack<GraphNode> stack = new Stack<>();
        for (GraphNode node : graph) {
            if (!node.isVisited()) {
                visit(node, stack);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().getName() + ", ");
        }
        System.out.println("");
    }

    public void visit(GraphNode node, Stack<GraphNode> stack) {
        for (GraphNode neighbor : node.getNeighbors()) {
            if (!neighbor.isVisited()) {
                visit(neighbor,stack);
            }
        }
        node.setVisited(true);
        stack.push(node);
    }

    public void addDirectedEdge(int i, int j) {
        GraphNode first = graph.get(i - 1);
        GraphNode second = graph.get(j - 1);
        first.getNeighbors().add(second);
    }
}
