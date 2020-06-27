package udemy.DataStructuresAndAlgorithms;

import java.util.ArrayList;

public class GraphNode {
    private ArrayList<GraphNode> neighbors = new ArrayList<GraphNode>();
    private String name;
    private int index;
    private GraphNode parent;
    private boolean isVisited = false;

    public GraphNode(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public GraphNode(String name) {
        this.name = name;
    }

    public ArrayList<GraphNode> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(ArrayList<GraphNode> neighbors) {
        this.neighbors = neighbors;
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

    public GraphNode getParent() {
        return parent;
    }

    public void setParent(GraphNode parent) {
        this.parent = parent;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }
}
