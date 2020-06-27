package academy.learnprogramming;

import org.w3c.dom.Node;

public class DoubleLL {
    private DNode head;
    private DNode tail;
    private int size;

    public DNode getHead() {
        return head;
    }

    public void setHead(DNode head) {
        this.head = head;
    }

    public DNode getTail() {
        return tail;
    }

    public void setTail(DNode tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void createDLL(int value) {
        System.out.println("Creating a new Double Linked List.");
        DNode node = new DNode();
        node.setValue(value);
        node.setPrevNode(null);
        node.setNextNode(null);
        head = node;
        tail = node;
        size = 1;
    }

    public boolean existsDLL() {
        return this.head != null;
    }

    public boolean insertNode (int value, int location) {
        if (existsDLL()) {
            DNode node = new DNode();
            node.setValue(value);
            if (location == 0) {
                //insert at head
                node.setNextNode(this.head);
                node.setPrevNode(null);
                this.head.setPrevNode(node);
                this.head = node;
            } else if (location >= size) {
                //insert at tail
                node.setNextNode(null);
                node.setPrevNode(this.tail);
                this.tail.setNextNode(node);
                this.tail = node;
            } else {
                //somewhere in the middle
                DNode tmpNode = this.head;
                int i = 0;
                while (i < location - 1) {
                    i++;
                    tmpNode = tmpNode.getNextNode();
                }
                node.setNextNode(tmpNode.getNextNode());
                node.setPrevNode(tmpNode);
                tmpNode.getNextNode().setPrevNode(node);
                tmpNode.setNextNode(node);
            }
            size++;
            return true;
        } else {
            System.out.println("Linked list doesn't exist. Cannot insertNode.");
            return false;
        }
    }

    public void traverseForwards () {
        DNode tmpNode = this.head;
        System.out.println("Traversing the list forwards.");
        while (tmpNode != null) {
            System.out.print(tmpNode.getValue() + "->");
            tmpNode = tmpNode.getNextNode();
        }
        System.out.println("");
    }

    public void traverseBackwards () {
        DNode tmpNode = this.tail;
        System.out.print("Traversing the list backwards.");
        while (tmpNode != null) {
            System.out.print(tmpNode.getValue() + "->");
            tmpNode = tmpNode.getPrevNode();
        }
        System.out.println("");
    }

    public boolean searchDLL(int value) {
        DNode tmpNode = this.head;
        System.out.println("Searching list for " + value + " ...");
        while (tmpNode != null) {
            if (tmpNode.getValue() == value) {
                System.out.println("Found the value!");
                return true;
            }
            tmpNode = tmpNode.getNextNode();
        }
        return false;
    }

    public boolean deleteDLL() {
        if (existsDLL()) {
            DNode tmpNode = this.head;
            while (tmpNode != null) {
                tmpNode.setPrevNode(null);
                tmpNode = tmpNode.getNextNode();
            }
            this.head = null;
            this.tail = null;
            size = 0;
            return true;
        } else {
            System.out.println("There is no list to delete.");
            return false;
        }
    }

    public boolean deleteNode(int location) {
        if (existsDLL()) {
            if (location == 0) {
                if (this.head.getNextNode() == null & this.head.getPrevNode() == null ) {
                    //only element
                    this.head = null;
                    this.tail = null;
                } else {
                    this.head.getNextNode().setPrevNode(null);
                    //this.head.setNextNode(null); //<- do I need to do this?!
                    this.head = this.head.getNextNode();
                }
            } else if (location >= size -1) {
                if (this.tail.getPrevNode() == null) { //only element
                    this.head = null;
                    this.tail = null;
                } else {
                    this.tail.getPrevNode().setNextNode(null);
                    this.tail = this.tail.getPrevNode();
                }
            } else {
                //somewhere in the middle
                DNode tmpNode = this.head;
                int i = 0;
                while (i < location) {
                    i++;
                    tmpNode = tmpNode.getNextNode();
                }
                tmpNode.getPrevNode().setNextNode(tmpNode.getNextNode());
                tmpNode.getNextNode().setPrevNode(tmpNode.getPrevNode());
            }
            size--;
            return true;
        } else {
            System.out.println("There is no list to delete.");
            return false;
        }
    }
}
