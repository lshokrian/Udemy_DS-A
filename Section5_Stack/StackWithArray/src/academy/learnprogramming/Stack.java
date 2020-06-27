package academy.learnprogramming;

import java.util.Arrays;

public class Stack {
    int[] stackArray;
    int numContents = 0;

    public Stack(int size) {
        this.stackArray = new int[size];
    }

    public int getNumContents() {
        return numContents;
    }

    public void createStack(int size) {
        this.stackArray = new int[size] ;
    }

    public boolean stackExists() {
        return stackArray != null;
    }

    public int pop() {
        if(stackExists()) {
            if (!isEmpty()) {
                numContents = numContents - 1;
                System.out.println("Popping " + this.stackArray[numContents] + " of the stack.");
                return this.stackArray[numContents];
            } else {
                System.out.println("The stack is already empty.");
                return Integer.MIN_VALUE;
            }
        } else {
            System.out.println("No stack exists to pop from.");
            return Integer.MIN_VALUE;
        }
    }

    public void push(int value) {
        if(stackExists()) {
            if (!isFull()) {
                System.out.println("Pushing " + value + " onto the stack.");
                numContents++;
                this.stackArray[numContents-1] = value;
            } else {
                System.out.println("The stack is already full.");
            }
        } else {
            System.out.println("No stack exists to push to.");
        }
        return;
    }

    public int peek() {
        if(stackExists()) {
            if (!isEmpty()) {
                System.out.println("Peaking " + this.stackArray[numContents-1] + " at the top of stack.");
                return this.stackArray[numContents-1];
            } else {
                System.out.println("The stack is already empty.");
                return Integer.MIN_VALUE;
            }
        } else {
            System.out.println("No stack exists to pop from.");
            return Integer.MIN_VALUE;
        }
    }

    public boolean isEmpty() {
        return numContents == 0;
    }

    public boolean isFull() {
        return numContents == stackArray.length;
    }

    public void deleteStack() {
        System.out.println("Deleting entire stack.");
        this.stackArray = null;
    }

    public void printStack() {
        if (stackExists()) {
            for (int i = 0; i < numContents; i++) {
                System.out.print(this.stackArray[i] + " : ");
            }
            System.out.println("");
        } else {
            System.out.println("No stack exists to print.");
        }
    }
}
