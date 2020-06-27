package academy.learnprogramming;

public class Stack {
    private Node head;

    public void createStack(int value) {
        Node node = new Node(value);
        this.head = node;
    }

    public int pop() {
        if (stackExists()) {
            if (!isEmpty()) {
                Node tmpNode = head;
                    head = head.getNextNode();
                    return tmpNode.getValue();
            } else {
                System.out.println("This stack is empty.");
                return Integer.MIN_VALUE;
            }
        } else {
            System.out.println("There is no stack to pop from.");
            return Integer.MIN_VALUE;
        }
    }

    public int peek() {
        if (stackExists()) {
            return this.head.getValue();
        } else {
            System.out.println("There is no stack to peek from.");
            return Integer.MIN_VALUE;
        }

    }

    public void push(int value) {
        if (stackExists()) {
            Node node = new Node(value);
            node.setNextNode(head);
            head = node;
        } else {
            System.out.println("There is no stack to push to.");
        }

    }

    public boolean isEmpty() {
       return head == null;
    }

    public boolean stackExists() {
        return head != null;
    }

    public void deleteStack() {
        head = null;
    }

    public void printStack() {
        if (stackExists()) {
            Node tmpNode = head;
            while (tmpNode != null) {
                System.out.print(tmpNode.getValue() + " <- ");
                tmpNode = tmpNode.getNextNode();
            }
            System.out.println("[bottom]");
        } else {
            System.out.println("There is no stack to print.");
        }
    }
}
