package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
        TwoDimensionalArray array = new TwoDimensionalArray(4, 3);
        array.traverseArray();

        array.insertInArray(1, 0, 5);
        array.insertInArray(2, 1, 6);
        array.insertInArray(0, 2, 15);
        array.insertInArray(1, 2, 9);
        array.insertInArray(1, 2, 9);
        array.insertInArray(2, 0, 35);

        array.traverseArray();
        array.searchArray(35);

        array.deleteFromArray(1,2);
        array.traverseArray();
    }
}
