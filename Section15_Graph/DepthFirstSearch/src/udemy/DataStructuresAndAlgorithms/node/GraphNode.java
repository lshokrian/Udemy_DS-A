package udemy.DataStructuresAndAlgorithms.node;

import java.util.ArrayList;

public class GraphNode {
    private String name;
    private int index;
    private ArrayList<GraphNode> neighbors = new ArrayList<>();
    private boolean isVisited;
    private GraphNode parentNode;

    public GraphNode(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public GraphNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public ArrayList<GraphNode> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(ArrayList<GraphNode> neighbors) {
        this.neighbors = neighbors;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public GraphNode getParentNode() {
        return parentNode;
    }

    public void setParentNode(GraphNode parentNode) {
        this.parentNode = parentNode;
    }
}
