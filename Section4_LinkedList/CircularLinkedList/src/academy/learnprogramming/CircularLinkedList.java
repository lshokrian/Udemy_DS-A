package academy.learnprogramming;

public class CircularLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public CircularLinkedList() {
        this.head = new Node();
        this.tail = new Node();
        this.size = 0;
    }

    public boolean insertNode(int value, int location) {
        Node node = new Node(value);
        if (this.head.getNextNode() == null) {
            System.out.println("Adding node to an empty list.");
            node.setNextNode(node);
            this.head.setNextNode(node);
            this.tail.setNextNode(node);
            size++;
            return true;
        } else if (location > size) {
            System.out.println("Location surpasses the current size.");
            return false;
        } else {
            if (location == 0) {
                //put at head
                System.out.println("Adding node to head.");
                this.head.getNextNode().setNextNode(node);
                node.setNextNode(this.head.getNextNode());
                this.head.setNextNode(node);
                size++;
                return true;
            } else if (location >= size) {
                //put at tail
                System.out.println("Adding node to tail.");
                this.tail.getNextNode().setNextNode(node);
                node.setNextNode(this.head.getNextNode());
                this.tail.setNextNode(node);
                size++;
                return true;
            } else {
                //put in middle of list
                System.out.println("Adding node to middle.");
                Node tmpNode = this.head.getNextNode();
                int i = 0;
                while(tmpNode != null) {
                    if (location - 1 == i) {
                        node.setNextNode(tmpNode.getNextNode());
                        tmpNode.setNextNode(node);
                        return true;
                    }
                    i++;
                    tmpNode = tmpNode.getNextNode();
                }
            }
        }
        return false;
    }

    public void traverseCircularLinkedList () {
        if (this.head.getNextNode() == null) {
            System.out.println("This list is empty, there is nothing to traverse.");
            return;
        } else {
            int i = 0;
            Node tmpNode = this.head.getNextNode();
            while (tmpNode != this.tail.getNextNode()) {
                System.out.println("At location " + i + ": " + tmpNode.getValue());
                i++;
                tmpNode = tmpNode.getNextNode();
            }
            System.out.println("At location " + i + ": " + tmpNode.getValue());
        }
    }

    public boolean searchCircularLinkedList(int value) {
        if (this.head.getNextNode() == null) {
            System.out.println("This list is empty, there is nothing to search.");
            return false;
        } else {
            int i = 0;
            Node tmpNode = this.head.getNextNode();
            while (tmpNode != this.tail.getNextNode()) {
                if (value == tmpNode.getValue()) {
                    System.out.println("At location " + i + ": " + tmpNode.getValue());
                    return true;
                }
                i++;
                tmpNode = tmpNode.getNextNode();
            }
            if (value == tmpNode.getValue()) {
                System.out.println("At location " + i + ": " + tmpNode.getValue());
                return true;
            }

        }
        return false;
    }

    public void deleteNode (int location) {
        if (this.head.getNextNode() == null) {
            System.out.println("This list is empty, there is nothing to delete.");
            return;
        } else {
            if (location == 0) {
                this.head.setNextNode(this.head.getNextNode().getNextNode());
                this.tail.getNextNode().setNextNode(this.head.getNextNode());
                return;
            } else if (location == size - 1) {
                Node tmpNode = this.head.getNextNode();
                while (tmpNode.getNextNode() != this.tail.getNextNode()) {
                    tmpNode = tmpNode.getNextNode();
                }
                tmpNode.setNextNode(this.head.getNextNode());
                this.tail.setNextNode(tmpNode);
                return;
            } else {
                int i = 0;
                Node tmpNode = this.head.getNextNode();
                while (tmpNode != this.tail.getNextNode()) {
                    if (i == location - 1) {
                        tmpNode.setNextNode(tmpNode.getNextNode().getNextNode());
                        return;
                    }
                    i++;
                    tmpNode = tmpNode.getNextNode();
                }
            }
        }
    }

    public void deleteCircularLinkedList() {
        this.head.getNextNode().setNextNode(null);
        this.head.setNextNode(null);
        this.tail.setNextNode(null);
    }
}
