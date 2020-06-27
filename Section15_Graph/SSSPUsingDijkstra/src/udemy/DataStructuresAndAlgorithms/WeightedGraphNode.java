package udemy.DataStructuresAndAlgorithms;

import java.util.ArrayList;
import java.util.HashMap;

public class WeightedGraphNode implements Comparable<WeightedGraphNode> {
    private String name;
    private int index;
    private ArrayList<WeightedGraphNode> neighbors = new ArrayList<WeightedGraphNode>();
    private HashMap<WeightedGraphNode, Integer> weightMap = new HashMap<>();
    private boolean isVisited = false;

    public WeightedGraphNode(String name) {
        this.name = name;
        this.distance = Integer.MAX_VALUE;
    }

    public HashMap<WeightedGraphNode, Integer> getWeightMap() {
        return weightMap;
    }

    public void setWeightMap(HashMap<WeightedGraphNode, Integer> weightMap) {
        this.weightMap = weightMap;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    private WeightedGraphNode parentNode;
    private int distance;

    public ArrayList<WeightedGraphNode> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(ArrayList<WeightedGraphNode> neighbors) {
        this.neighbors = neighbors;
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

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public WeightedGraphNode getParentNode() {
        return parentNode;
    }

    public void setParentNode(WeightedGraphNode parentNode) {
        this.parentNode = parentNode;
    }

    @Override
    public int compareTo(WeightedGraphNode o) {
        return this.distance - o.distance;
    }

    @Override
    public String toString() {
        return name;
    }
}
