package udemy.dataStructuresAndAlgorithms;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] array = {132,15,85,123,52,24,74,122};
        printArray(array);

        //bubbleSort(array);
        //printArray(array);

        //selectionSort(array);
        //printArray(array);

       //insertionSort(array);
       //printArray(array);

        //bucketSort(array);
        //printArray(array);

        // mergeSort(array, 0, array.length -1);
        // printArray(array);

        //quickSort(array, 0, array.length -1);
        //printArray(array);
        minHeap minHeap1 = new minHeap(8);
        for (int i = 0; i < array.length; i++) {
            minHeap1.insertToHeap(array[i]);
        }

        minHeap1.sortHeap();

    }

    // Print Array
    public static void printArray (int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        // outer loop iterates from 0 to n
        for (int i = 0; i < arr.length; i++) {
            // inner loop does element swap
            for (int j = 0; j < arr.length - i -1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    // Selection Sort
    public static void selectionSort(int[] arr) {
        // outer loop iterates from 0 to n-1
        for (int i = 0; i < arr.length - 1; i++) {
            // inner loop iterates from i to n-1 to find min value
            int minElement = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minElement]) {
                    minElement = j;
                }
            }
            // swap with minElement
            if (minElement != i) {
                int temp = arr[minElement];
                arr[minElement] = arr[i];
                arr[i] = temp;
            }
        }
    }

    public static void selectionSortWithSize(int[] arr, int size) {
        // outer loop iterates from 0 to n-1
        for (int i = 0; i < size - 1; i++) {
            // inner loop iterates from i to n-1 to find min value
            int minElement = i;
            for (int j = i; j < size; j++) {
                if (arr[j] < arr[minElement]) {
                    minElement = j;
                }
            }
            // swap with minElement
            if (minElement != i) {
                int temp = arr[minElement];
                arr[minElement] = arr[i];
                arr[i] = temp;
            }
        }
    }

    // Insertion Sort
    public static void insertionSort(int[] arr) {
        int j;
        // outer loop iterates from 0 to n
        for (int i = 1; i < arr.length; i++) {
            j = i;
            while (j > 0 && (arr[j] < arr[j-1])) {
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
            //printArray(arr);
        }
    }

    // Bucket Sort
    public static void bucketSort(int[] arr) {
        int numOfBuckets = (int) Math.ceil(Math.sqrt(arr.length));
        int bucketSelect;
        double dbucketSelect;
        int[][] buckets = new int[numOfBuckets][arr.length];
        int[] bucketNumOfContents = new int[numOfBuckets]; // already initialized to 0
        int maxVal = Integer.MIN_VALUE;
        // find max value
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxVal) maxVal = arr[i];
        }
        System.out.println("The max value is: " + maxVal + " with " + numOfBuckets + " buckets.");
        // put elements into buckets
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Working on [" + arr[i] + "] from main array.");
            dbucketSelect = (Math.ceil(((double)arr[i] * (double)numOfBuckets)/(double)maxVal) ) - 1;
            bucketSelect = (int)dbucketSelect;
            System.out.println("\tPlace element in [" + bucketSelect + "] selected bucket.");
            //find where the pointer is for that bucket
            System.out.println("\t\tStatus of bucket points: ");
            printArray(bucketNumOfContents);
            buckets[bucketSelect][bucketNumOfContents[bucketSelect]] = arr[i];
            System.out.println("Print buckets: ");
            bucketNumOfContents[bucketSelect]++;
            // System.out.println("Bucket 0: ");
            // printArray(buckets[0]);
            // System.out.println("Bucket 1: ");
            // printArray(buckets[1]);
            // System.out.println("Bucket 2: ");
            // printArray(buckets[2]);
        }

        // sort each bucket
        // concatenate buckets together
        System.out.println("Sort buckets and add to target...");
        int targetArrIndex = 0;
        for (int i = 0; i < buckets.length; i++) {
            System.out.println("**** sorting *****");
            selectionSortWithSize(buckets[i], bucketNumOfContents[i]);
            // System.out.println("Print buckets: ");
            // System.out.println("Bucket 0: ");
            // printArray(buckets[0]);
            // System.out.println("Bucket 1: ");
            // printArray(buckets[1]);
            // System.out.println("Bucket 2: ");

            for (int j = 0; j < bucketNumOfContents[i]; j++) {
                arr[targetArrIndex] = buckets[i][j];
                targetArrIndex++;
            }
        }
        printArray(arr);
    }

    // Merge Sort
    public static void mergeSort(int[] arr, int l, int r) {
        // keep breaking down
        if (r > l) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            merge(arr, l, m, r);
        } else {
            return;
        }
    }

    // merge for Merge Sort
    public static void merge(int[] arr, int l, int m, int r) {
        // create temp array for left array and right array
        System.out.println("Into merge l= " + l + "   m= " + m + "   r= " + r);
        int[] lArray = new int[m - l + 2];
        int[] rArray = new int[r - m + 1];

        for (int i = 0; i <= m-l; i++) {
            lArray[i] = arr[l+i];
        }
        for (int i = 0; i < r-m; i++) {
            rArray[i] = arr[m+1+i];
        }

        lArray[m - l + 1] = Integer.MAX_VALUE;
        rArray[r - m] = Integer.MAX_VALUE;

        System.out.println("\t lArray: ");
        printArray(lArray);
        System.out.println("\t rArray: ");
        printArray(rArray);
        int i = 0, j = 0;
        //bubble sort
        for (int k = l; k <= r; k++) {
            if (lArray[i] < rArray[j]) {
                arr[k] = lArray[i];
                i++;
            } else {
                arr[k] = rArray[j];
                j++;
            }
        }
    }

    // Quick Sort - get pivot then recursive to left of pivot and right of pivot
    public static void  quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int p = r;
            int i = l - 1;
            for (int j = l; j <= r; j++) {
                if (arr[j] <= arr[p]) {
                    //swap:
                    i++;
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
            quickSort(arr, l, i-1);
            System.out.println("Going into right partition.");
            quickSort(arr, i+1, r);
        } else {
            return;
        }
    }


}
