package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
	// write your code here
        SingleDimensionArray oneDArray = new SingleDimensionArray(10);

        System.out.println("Printing array: ");
        oneDArray.traverseArray();

        System.out.println("Insert value into array...");
        oneDArray.insertInArray(5, 6);
        oneDArray.insertInArray(4, 2);
        oneDArray.insertInArray(3, 2);

        System.out.println("Printing array: ");
        oneDArray.traverseArray();
        oneDArray.insertInArray(6, 1);
        oneDArray.insertInArray(16, 3);
        oneDArray.insertInArray(10, 4);
        oneDArray.insertInArray(7, 5);

        System.out.println("Printing array: ");
        oneDArray.traverseArray();

        oneDArray.deleteInArray(4);
        System.out.println("Search for 16: " + oneDArray.searchInArray(16));
        System.out.println("Printing array: ");
        oneDArray.traverseArray();


    }
}
