package academy.learnprogramming;

public class CircularLL {
    private Node head;
    private Node tail;
    private int size;

    Node createCircularLinkedList(int value) {
        System.out.println("Creating Circular Linked List");
        head = new Node();
        Node node = new Node();
        node.setValue(value);
        node.setNextNode(node); //references it's own location
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    public Node getHead() {
        return this.head;
    }

    public Node getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private boolean existsLL() {
        return this.head != null;
    }

    public void insertNode(int value, int location) {
        Node node = new Node();
        node.setValue(value);
        if (!existsLL()) {
            System.out.println("There is no linked list.");
            return;
        } else {
            System.out.println("Inserting new node at location: " + location);
            if (location == 0) {
                //at head
                node.setNextNode(head);
                tail.setNextNode(node); //have tail point to head
                head = node;
            } else if (location >= size) {
                //at tail
                tail.setNextNode(node);
                node.setNextNode(head);
                tail = node;
            } else {
                //in middle
                Node tmpNode = new Node();
                tmpNode = this.head;
                int i = 0;
                while (i < location - 1) {
                    i++;
                    tmpNode = tmpNode.getNextNode();
                }
                node.setNextNode(tmpNode.getNextNode());
                tmpNode.setNextNode(node);
            }
            size++;
            return;
        }
    }

    public void traverseCircularLL () {
        if (existsLL()) {
            Node tmpNode = this.head;
            int i = 0;
            while (i < size) {
                System.out.print(tmpNode.getValue() + " -> ");
                i++;
                tmpNode = tmpNode.getNextNode();
            }
            System.out.println("");
        } else {
            System.out.println("There is no list to traverse.");
        }
    }

    public boolean searchCLL(int value) {
        if (existsLL()) {
            Node tmpNode = this.head;
            int i = 0;
            while (i < size) {
                if (tmpNode.getValue() == value) {
                    System.out.println("Value is located at : " + i);
                    return true;
                }
                i++;
                tmpNode = tmpNode.getNextNode();
            }
        }
        return false;
    }

    public void deleteCircularLL () {
        this.tail.setNextNode(null);
        this.head = null;
        this.tail = null;
    }

    public void deleteNode (int location) {
        if (existsLL()) {
            if (location == 0) {
                //delete head
                this.tail.setNextNode(this.head.getNextNode());
                this.head = this.head.getNextNode();
            } else if (location >= size - 1) {
                Node tmpNode = this.head;
                int i = 0;
                while (i < size - 2) {
                    i++;
                    tmpNode = tmpNode.getNextNode();
                }
                tmpNode.setNextNode(this.head);
                this.tail = tmpNode;
            } else {
                Node tmpNode = this.head;
                int i = 0;
                while (i < location - 1) {
                    i++;
                    tmpNode = tmpNode.getNextNode();
                }
                tmpNode.setNextNode(tmpNode.getNextNode().getNextNode());
            }
            size--;
        } else {
            System.out.println("There is no Linked List to delete a node from.");
        }
    }

    public void printHeadThroughTail() {
        if (existsLL()) {
            System.out.println("The head value through the tail is: " + tail.getNextNode().getValue());
        }
    }
}
