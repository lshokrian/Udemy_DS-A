package academy.learnprogramming;

public class BKUPSingleLL {
    private Node head;
    private Node tail;
    private int size;

    public BKUPSingleLL() {
        this.head = new Node();
        this.tail = new Node();
        this.size = 0;
    }

    public Node getHead() {
        return this.head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return this.tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public boolean insertNode (int value, int location) {
        Node node = new Node(value, null);
        int i = 0;
        if (this.head.getNextNode() == null) { //uninitialized list
            System.out.println("This linked list is currently empty.");
            System.out.println("Adding " + value + " to list.");
            this.head.setNextNode(node);
            this.tail.setNextNode(node);
            size++;
            return true;
        } else if (location > size) {
            System.out.println("The selected location is out of the size of the linkedlist.");
            return false;
        } else {
            Node tmpNode = this.head.getNextNode();
            if (location == 0) {
                System.out.println("Inserting value at head.");
                node.setNextNode(this.head.getNextNode());
                this.head.setNextNode(node);
                size++;
                return true;
            } else if (location == size - 1) {
                System.out.println("Inserting value at tail.");
                tail.getNextNode().setNextNode(node);
                tail.setNextNode(node);
                size++;
                return true;
            } else {
                System.out.println("Location is in the middle of list.");
                while (tmpNode != null) {
                    if (location - 1 == i) {
                        System.out.println("\tSet to location : " + location + " to value : " + value);
                        node.setNextNode(tmpNode.getNextNode());
                        tmpNode.setNextNode(node);
                        size++;
                        return true;
                    }
                    i++;
                    tmpNode = tmpNode.getNextNode();
                }
            }
        }
        return false;
    }

    public boolean searchSingleLL (int value) {
        Node tmpNode = this.head.getNextNode();
        int i = 0;
        while (tmpNode != null) {
            if (tmpNode.getValue() == value) {
                System.out.println("At location " + i + ": " + tmpNode.getValue());
                return true;
            }
            i++;
            tmpNode = tmpNode.getNextNode();
        }
        return false;
    }

    public void traverseSingleLL() {
        Node tmpNode = this.head.getNextNode();
        int i = 0;
        System.out.println("------Traversing List--------");
        if (this.head.getNextNode() == null) {
            System.out.println("There is no list to traverse.");
            System.out.println("------End Traversing List--------");
            return;
        }
        while (tmpNode != null) {
            System.out.println("At location " + i + ": " + tmpNode.getValue());
            i++;
            tmpNode = tmpNode.getNextNode();
        }
        System.out.println("------End Traversing List--------");
    }

    public void deleteSingleLL() {
        this.head.setNextNode(null);
        this.tail.setNextNode(null);
        size = 0;
    }

    public boolean deleteNode (int location) {
        Node tmpNode = new Node();
        int i = 0;
        if (this.head.getNextNode() == null) {
            System.out.println("This list is empty, there is nothing to delete.");
            return false;
        }  else if (location > size) {
            System.out.println("This location is out of the size of this linked list.");
            return false;
        } else {
            //head
            if (location == 0) {
                System.out.println("Deleting head node.");
                this.head.setNextNode(this.head.getNextNode().getNextNode());
                return true;
            } else if (location == size - 1) {
                //tail
                System.out.println("Deleting tail node.");
                tmpNode = this.head.getNextNode();
                while (tmpNode.getNextNode() != tail.getNextNode()) {
                    tmpNode = tmpNode.getNextNode();
                }
                tmpNode.setNextNode(null);
                tail = tmpNode;
                return true;
            } else {
                //middle
                tmpNode = this.head.getNextNode();
                while (i != location - 1) {
                    i++;
                    tmpNode = tmpNode.getNextNode();
                }
                i++;
                System.out.println("Deleting: " + i);
                tmpNode.setNextNode(tmpNode.getNextNode().getNextNode());
                return true;

            }
        }
    }
}
