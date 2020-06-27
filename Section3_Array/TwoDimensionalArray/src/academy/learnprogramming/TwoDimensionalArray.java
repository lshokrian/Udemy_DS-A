package academy.learnprogramming;

public class TwoDimensionalArray {
    private int[][] arr;
    private int columns;
    private int rows;

    public TwoDimensionalArray(int columns, int rows) {
        this.columns = columns;
        this.rows = rows;
        this.arr = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = Integer.MIN_VALUE;
            }
        }
    }


    public boolean insertInArray (int row, int column, int value) {
        try {
            if (arr[row][column] == Integer.MIN_VALUE) {
                System.out.println("Successfully setting [" + row + "][" + column + "] to value " + value);
                arr[row][column] = value;
                return true;
            } else {
                System.out.println("This location has already been given a value.");
                return false;
            }
        } catch(Exception e) {
            System.out.println("Array doesn't exist.");
            return false;
        }
    }

    public boolean deleteFromArray (int row, int column) {
        try {
            arr[row][column] = Integer.MIN_VALUE;
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("This element is not in the array.");
            return false;
        }
    }

    public void traverseArray () {
        try {
            for (int i = 0; i < rows; i++) {
                System.out.print("{");
                for (int j = 0; j < columns; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.print("}\n");
            }
        } catch (Exception e) {
            System.out.println("Array doesn't exist.");
        }
    }

    public void searchArray (int value) {
        try {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if(arr[i][j] == value) {
                        System.out.println("Found " + value + " at [" + i + "][" + j + "]");
                        return;
                    }
                }
            }
            System.out.println("Didn't find the element.");
            return;
        } catch (Exception e) {
            System.out.println("Array doesn't exist.");
        }
    }
}
