package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //Remember: variables don't go onto the stack until the function is exited (temporarily)
        System.out.println("Factorial 5 = " + factorial(5));
        System.out.println("Factorial 7 = " + factorial(7));

        System.out.println("Fibonacci 5 = " + fibonacci(5));
        System.out.println("Fibonacci 7 = " + fibonacci(7));

        int[] arrayIn = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110};
        System.out.println("Binary search for 70: " + binarySearch(arrayIn, 0, arrayIn.length-1, 70));
    }

    //Factorial:
    public static int factorial (int n) {
        if (n <= 1)
            return n;
        else
            return n*factorial(n-1);
    }

    //Fibonacci:
    public static int fibonacci (int n) {
        if (n < 1)
            return -1;
        else if (n == 1 || n == 2)
            return n-1;
        else
            return fibonacci(n-1) + fibonacci(n-2);
    }

    //Binary Search
    public static int binarySearch(int[] array, int startElem, int endElem, int number) {
        if (endElem == startElem) {
            if (array[startElem] == number) {
                return startElem;
            } else {
                System.out.println("error");
                return -1;
            }
        }
        int middle = startElem + (endElem - startElem)/2;
        System.out.println("Middle element is: " + middle + " with value " + array[middle]);
        if (array[middle] == number) {
            return middle;
        } else if (array[middle] > number) {
            return binarySearch(array, startElem, middle-1, number);
        } else
            return binarySearch(array, middle + 1, endElem, number);
    }
}
