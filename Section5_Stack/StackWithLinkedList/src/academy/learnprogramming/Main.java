package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
        Stack stack1 = new Stack();
        stack1.createStack(3);
        stack1.printStack();

        stack1.push(12);
        stack1.printStack();

        stack1.push(15);
        stack1.printStack();

        stack1.push(10);
        stack1.printStack();

        stack1.push(3);
        stack1.printStack();

        stack1.push(45);
        stack1.printStack();

        stack1.push(5);
        stack1.printStack();

        System.out.println("Pop!: " + stack1.pop());
        stack1.printStack();

        System.out.println("Pop!: " + stack1.pop());
        stack1.printStack();

        System.out.println("Pop!: " + stack1.pop());
        stack1.printStack();

        System.out.println("Pop!: " + stack1.pop());
        stack1.printStack();

        System.out.println("Pop!: " + stack1.pop());
        stack1.printStack();

        System.out.println("Pop!: " + stack1.pop());
        stack1.printStack();

        System.out.println("Pop!: " + stack1.pop());
        stack1.printStack();

        System.out.println("Pop!: " + stack1.pop());
        stack1.printStack();

        stack1.push(45);
        stack1.printStack();

        stack1.deleteStack();
        stack1.push(45);
        stack1.printStack();
    }
}
