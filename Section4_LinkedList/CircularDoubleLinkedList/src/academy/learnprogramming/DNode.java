package academy.learnprogramming;

public class DNode {
    private int value;
    private DNode prevNode;
    private DNode nextNode;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public DNode getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(DNode prevNode) {
        this.prevNode = prevNode;
    }

    public DNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(DNode nextNode) {
        this.nextNode = nextNode;
    }
}
