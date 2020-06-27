package udemy.DataStructuresAndAlgorithms;

import java.util.ArrayList;
import java.util.HashMap;

public class WeightedGraphNode {
    private ArrayList<WeightedGraphNode> neighbors = new ArrayList<WeightedGraphNode>();
    private HashMap<WeightedGraphNode, Integer> weightMap = new HashMap<>();
    private WeightedGraphNode parent;
    private int index;
    private String name;
    private int distance;
    private boolean isVisited = false;

    public WeightedGraphNode(String name) {
        this.name = name;
        this.distance = Integer.MAX_VALUE;
    }

    public ArrayList<WeightedGraphNode> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(ArrayList<WeightedGraphNode> neighbors) {
        this.neighbors = neighbors;
    }

    public HashMap<WeightedGraphNode, Integer> getWeightMap() {
        return weightMap;
    }

    public void setWeightMap(HashMap<WeightedGraphNode, Integer> weightMap) {
        this.weightMap = weightMap;
    }

    public WeightedGraphNode getParent() {
        return parent;
    }

    public void setParent(WeightedGraphNode parent) {
        this.parent = parent;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }
}
