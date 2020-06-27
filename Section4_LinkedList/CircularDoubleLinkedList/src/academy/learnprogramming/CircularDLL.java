package academy.learnprogramming;

public class CircularDLL {
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

    public DNode createCircularDLL(int value) {
        DNode node = new DNode();
        node.setValue(value);
        System.out.println("Creating a Circular Double Linked List.");
        node.setPrevNode(node);
        node.setNextNode(node);
        this.head = node;
        this.tail = node;
        return this.head;
    }

    public boolean existsCDLL() {
        return this.head != null;
    }

    public boolean insertNode(int value, int location) {
        if (existsCDLL()) {
            System.out.println("size is: " + size);
            DNode node = new DNode();
            node.setValue(value);
            if (location == 0) {
                node.setNextNode(this.head);
                node.setPrevNode(this.tail);
                this.head.setPrevNode(node);
                this.head = node;
                this.tail.setNextNode(node);
            } else if (location >= size) {
                node.setNextNode(this.head);
                node.setPrevNode(this.tail);
                this.tail.setNextNode(node);
                this.tail = node;
                this.head.setPrevNode(node);
            } else {
                System.out.println("Inserting in the middle");
                DNode tmpNode = this.head;
                int i = 0;
                while (i < location - 1) {
                    i++;
                    tmpNode = tmpNode.getNextNode();
                }
                System.out.println("We're at node: " + i + " with value: " + tmpNode.getValue());
                node.setPrevNode(tmpNode);
                node.setNextNode(tmpNode.getNextNode());
                tmpNode.getNextNode().setPrevNode(node);
                tmpNode.setNextNode(node);
                System.out.println("tmpvalue.next = " + tmpNode.getNextNode().getValue());
            }
            size++;
            return true;
        } else {
            System.out.println("There is no linked list to insert into.");
            return false;
        }
    }

    public void traverseCDLLForwards() {
        if (existsCDLL()) {
            DNode tmpNode = this.head;
            System.out.println("Traversing the list forwards...");
            while (tmpNode != this.tail) {
                System.out.print(tmpNode.getValue() + " -> ");
                tmpNode = tmpNode.getNextNode();
            }
            //print tail value
            System.out.print(tmpNode.getValue());
            System.out.println("");
        } else {
            System.out.println("There is no list to traverse.");
        }
    }

    public void traverseCDLLBackwards() {
        if (existsCDLL()) {
        DNode tmpNode = this.tail;
        System.out.println("Traversing the list backwards...");
        while(tmpNode != this.head) {
            System.out.print(tmpNode.getValue() + " -> ");
            tmpNode = tmpNode.getPrevNode();
        }
        //print head value
        System.out.print(tmpNode.getValue());
        System.out.println("");
    } else {
        System.out.println("There is no list to traverse.");
    }
}

    public boolean searchCDLL(int value) {
        if (existsCDLL()) {
            DNode tmpNode = this.head;
            System.out.println("Searching the list for " + value);
            while (tmpNode != this.tail) {
                if (tmpNode.getValue() == value) {
                    System.out.println("\tFound the value!");
                    return true;
                }
                tmpNode = tmpNode.getNextNode();
            }
            //check tail
            if (tmpNode.getValue() == value) {
                System.out.println("Found the value!");
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean deleteNode(int location) {
        if (existsCDLL()) {
            if (location == 0) {
                if (this.head == this.tail) {
                    //only node
                    this.head.setPrevNode(null);
                    this.head.setNextNode(null);
                    this.head = null;
                    this.tail = null;
                } else {
                    this.head.getNextNode().setPrevNode(this.tail);
                    this.head = this.head.getNextNode();
                    this.tail.setNextNode(this.head);
                }
            } else if (location >= size - 1){
                if (this.head == this.tail) {
                    this.tail.setPrevNode(null);
                    this.tail.setNextNode(null);
                    this.tail = null;
                    this.head = null;
                } else {
                    this.tail.getPrevNode().setNextNode(this.head);
                    this.tail = this.tail.getPrevNode();
                    this.head.setPrevNode(this.tail);
                }
            } else {
                //somewhere in the middle
                DNode tmpNode = this.head;
                int i = 0;
                while (i < location - 1) {
                    i++;
                    tmpNode = tmpNode.getNextNode();
                }
                tmpNode.getNextNode().getNextNode().setPrevNode(tmpNode);
                tmpNode.setNextNode(tmpNode.getNextNode().getNextNode());
            }
            size--;
            return true;
        } else {
            System.out.println("There is no list to delete from.");
            return false;
        }
    }

    public void deleteCDLL() {
        if (existsCDLL()) {
            DNode tmpNode = this.head;
            while (tmpNode != this.tail) {
                tmpNode.setPrevNode(null);
                tmpNode = tmpNode.getNextNode();
            }
            this.head = null;
            this.tail = null;
        } else {
            System.out.println("There is no list to delete.");
        }
    }
}
