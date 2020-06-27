package academy.learnprogramming;

public class Queue {
    int[] queueArray;
    int headOfQueue = -1;
    int tailOfQueue = -1;

    public Queue(int size) {
        queueArray = new int[size];
    }

    public void enQueue(int value) {
        if (queueExists()) {
            if (!isFull()) {
                if (isEmpty()) {
                    tailOfQueue = 0;
                }
                headOfQueue++;
                queueArray[headOfQueue] = value;
                System.out.println("Inserting " + value + " to queue.");
            } else {
                System.out.println("The queue is full! Overflow!");
            }
        } else {
            System.out.println("No queue exists to insert into.");
        }
    }

    public int peekQueue() {
        if (queueExists()) {
            if (!isEmpty()) {
                return queueArray[tailOfQueue];
            } else {
                System.out.println("The queue is empty! Underflow!");
                return Integer.MIN_VALUE;
            }
        } else {
            System.out.println("No queue exists to insert into.");
            return Integer.MIN_VALUE;
        }
    }

    public int deQueue() {
        if (queueExists()) {
            if (!isEmpty()) {
                int value = queueArray[tailOfQueue];
                tailOfQueue++;
                if (tailOfQueue > headOfQueue) {
                    tailOfQueue = -1;
                    headOfQueue = -1;
                }
                return value;
            } else {
                System.out.println("The queue is empty! Underflow!");
                return Integer.MIN_VALUE;
            }
        } else {
            System.out.println("No queue exists to insert into.");
            return Integer.MIN_VALUE;
        }
    }

    public boolean queueExists() {
        return queueArray != null;
    }

    public boolean isEmpty() {
        return ((tailOfQueue == -1) || (tailOfQueue == queueArray.length));
        //return headOfQueue == tailOfQueue;
    }

    public boolean isFull() {
        return headOfQueue == (queueArray.length-1);
    }

    public void deleteQueue() {
        queueArray = null;
    }

    public void printQueue() {
        if (!isEmpty()) {
            for (int i = tailOfQueue; i <= headOfQueue; i++) {
                System.out.print(queueArray[i] + " <- ");
            }
            System.out.println("[end]");
        } else {
            System.out.println("Queue is empty.Nothing to print.");
        }
    }
}
