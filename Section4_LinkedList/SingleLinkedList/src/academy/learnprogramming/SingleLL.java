package academy.learnprogramming;

public class SingleLL {
    private Node head;
    private Node tail;
    private int size;// denotes size of list


    public Node createSingleLinkedList(int nodeValue) {
        head = new Node();
        Node node = new Node();
        node.setValue(nodeValue);
        node.setNextNode(null);
        head = node;
        tail = node;
        size = 1;// size =1
        return head;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


    public void insertNode(int nodeValue, int location) {
        Node node = new Node();
        node.setValue(nodeValue);
        if (!existsLinkedList()) { // Linked List does not exists
            System.out.println("The linked list does not exist!!");
            createSingleLinkedList(nodeValue);
            return;
        } else if (location == 0) {// insert at first position
            node.setNextNode(head);
            head = node;
        } else if (location >= size) {// insert at last position
            node.setNextNode(null);
            tail.setNextNode(node);
            tail = node;
        } else {// insert at specified location
            Node tempNode = head;
            int index = 0;
            while (index < location - 1) {// loop till we reach specified node
                tempNode = tempNode.getNextNode();
                index++;
            }//tempNode currently references to node after which we should insert new node
            Node nextNode = tempNode.getNextNode(); //this is the immediate next node after new node
            tempNode.setNextNode(node);//update reference of tempNode to reference to new node
            node.setNextNode(nextNode);//update newly added nodes' next.
        }
        setSize(getSize()+1);
    }


    public boolean existsLinkedList() {
        // if head is not null retrun true otherwise return false
        return head != null;
    }


    //Traverses Linked List
    void traverseSingleLL() {
        if (existsLinkedList()) {
            Node tempNode = head;
            for (int i = 0; i < getSize(); i++) {
                System.out.print(tempNode.getValue());
                if (i != getSize() - 1) {
                    System.out.print(" -> ");
                }
                tempNode = tempNode.getNextNode();
            }
        }else {
            System.out.println("Linked List does not exists !");
        }
        System.out.println("\n");
    }


    //Deletes entire Linked List
    void deleteSingleLL() {
        System.out.println("\n\nDeleting Linked List...");
        head = null;
        tail = null;
        System.out.println("Linked List deleted successfully !");
    }


    //Searches a node with given value
    boolean searchSingleLL(int nodeValue) {
        if (existsLinkedList()) {
            Node tempNode = head;
            for (int i = 0; i < getSize(); i++) {
                if (tempNode.getValue() == nodeValue) {
                    System.out.print("Found the node at location: "+i+"\n");
                    return true;
                }
                tempNode = tempNode.getNextNode();
            }
        }
        System.out.print("Node not found!! \n");
        return false;
    }


    //Deletes a node having a given value
    public void deleteNode(int location) {
        if (!existsLinkedList()) {
            System.out.println("The linked list does not exist!!");// Linked List does not exists
            return;
        } else if (location == 0) { // we want to delete first element
            head = head.getNextNode();
            setSize(getSize()-1);
            if(getSize() == 0) { // if there are no more nodes in this list
                tail = null;
            }
        }else if (location >= getSize()){ //If location is not in range or equal, then delete last node
            Node tempNode = head;
            for (int i = 0; i < size - 1; i++) {
                tempNode = tempNode.getNextNode(); //temp node points to 2nd last node
            }
            if (tempNode == head) { //if this is the only element in the list
                tail = head = null;
                setSize(getSize()-1);
                return;
            }
            tempNode.setNextNode(null);
            tail= tempNode;
            setSize(getSize()-1);

        }else { //if any inside node is to be deleted
            Node tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.getNextNode(); // we need to traverse till we find the location
            }
            tempNode.setNextNode(tempNode.getNextNode().getNextNode()); // delete the required node
            setSize(getSize()-1);
        }//end of else

    }//end of method
}
