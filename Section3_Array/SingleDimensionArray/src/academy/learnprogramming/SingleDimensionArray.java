package academy.learnprogramming;

public class SingleDimensionArray {
    int[] arr = null;
    int arrSize;

    public SingleDimensionArray(int arrSize) {
        this.arr = new int[arrSize];
        this.arrSize = arrSize;
        for (int i = 0; i < arrSize; i++) {
            arr[i] = Integer.MIN_VALUE;
        }
    }

    public void traverseArray() {
        try {
            for (int i = 0; i < arrSize; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println("");
        } catch (Exception e) {
            System.out.println("Array no longer exists.");
        }
    }

    public boolean insertInArray(int number, int location) {
        try {
            if (arr[location] > Integer.MIN_VALUE) {
                System.out.println("This location is already occupied by another value.");
                return false;
            } else {
                arr[location] = number;
                System.out.println("Value " + number + " has been successfully inserted to location : " + location);
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index to access array!");
            return false;
        }
    }


    public boolean deleteInArray(int location) {
        try {
            arr[location] = Integer.MIN_VALUE;
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index to access array!");
            return false;
        }
    }

    public int searchInArray(int value) {
        try {
            for (int i = 0; i < arrSize; i++) {
                if (arr[i] == value) return i;
            }
            return -1;
        } catch (Exception e) {
            System.out.println("Array no longer exists.");
            return -1;
        }
    }

}
