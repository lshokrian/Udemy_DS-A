package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
        Queue queue1 = new Queue(5);

        queue1.enQueue(2);
        queue1.printQueue();
        queue1.enQueue(98);
        queue1.printQueue();
        queue1.enQueue(24);
        queue1.printQueue();
        queue1.enQueue(36);
        queue1.printQueue();
        queue1.enQueue(89);
        queue1.printQueue();
        queue1.enQueue(43);
        queue1.printQueue();

        System.out.println("");
        System.out.println("deQueue from top of Queue: " + queue1.deQueue());
        queue1.printQueue();
        System.out.println("deQueue from top of Queue: " + queue1.deQueue());
        queue1.printQueue();
        System.out.println("Peek from top of Queue: " + queue1.peekQueue());
        queue1.printQueue();
        System.out.println("deQueue from top of Queue: " + queue1.deQueue());
        queue1.printQueue();
        System.out.println("Peek from top of Queue: " + queue1.peekQueue());
        queue1.printQueue();
        System.out.println("deQueue from top of Queue: " + queue1.deQueue());
        queue1.printQueue();
        System.out.println("deQueue from top of Queue: " + queue1.deQueue());
        queue1.printQueue();
        System.out.println("deQueue from top of Queue: " + queue1.deQueue());
        queue1.printQueue();


    }
}
