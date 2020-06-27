package udemy.dataStructuresAndAlgorithms;

public class minHeap {
    int[] heapArray;
    int lastElementIndex;

    public minHeap(int size) {
        heapArray = new int[size+1];
        lastElementIndex = 0;
    }

    public void insertToHeap(int num) {
        if (heapFull()) {
            System.out.println("Heap is full, can't insert into array.");
            return;
        } else {
            lastElementIndex++;
            heapArray[lastElementIndex] = num;
            heapifyBottomtoTop();
            System.out.println("Value [" + num + "] inserted into heap.");
        }
    }

    public void heapifyBottomtoTop() {
        if (lastElementIndex > 0) {
            int currentNode = lastElementIndex;
            int parentNode;

            while (currentNode > 1) {
                if (currentNode % 2 == 0) {
                    parentNode = currentNode / 2;
                } else {
                    parentNode = (currentNode - 1) / 2;
                }

                if (heapArray[parentNode] > heapArray[currentNode]) {
                    int temp = heapArray[parentNode];
                    heapArray[parentNode] = heapArray[currentNode];
                    heapArray[currentNode] = temp;
                }
                currentNode = parentNode;
            }
        } else {
            System.out.println("Done with heapify.");
        }
        return;
    }

    public boolean heapFull() {
        if (lastElementIndex == heapArray.length - 1) {
            return true;
        } else {
            return false;
        }
    }

    public void sortHeap() {
        int[] sortedArr = new int[lastElementIndex+1];
        int i = 0;
        while (lastElementIndex > 0) {
            sortedArr[i] = extract();
            i++;
        }

        //don't print last 0
        for (int j = 0; j < sortedArr.length-1; j++) {
            System.out.print(sortedArr[j] + " ");
        }
        System.out.println("");
    }

    public int extract() {
        if (lastElementIndex > 0) {
            int topOfHeap = heapArray[1];
            heapArray[1] = heapArray[lastElementIndex];
            lastElementIndex--;
            heapifyToptoBottom(1);
            System.out.println("Value [" + topOfHeap + "] has been extracted from the heap.");
            return topOfHeap;
        } else {
            System.out.println("Heap is empty.");
            return -1;
        }
    }

    public void heapifyToptoBottom(int currentNode) {
        if (lastElementIndex > 0) {
            // check for both children exist
            if ((currentNode*2 <= lastElementIndex) && (currentNode*2+1 <= lastElementIndex)) {
                //check whether left node or right node is smaller
                if (heapArray[currentNode*2] < heapArray[currentNode*2 + 1]) {
                    if (heapArray[currentNode] > heapArray[currentNode*2]) {
                        int temp = heapArray[currentNode*2];
                        heapArray[currentNode*2] = heapArray[currentNode];
                        heapArray[currentNode] = temp;
                        heapifyToptoBottom(currentNode*2);
                    } else if (heapArray[currentNode] > heapArray[currentNode*2 + 1]) {
                        int temp = heapArray[currentNode*2+1];
                        heapArray[currentNode*2+1] = heapArray[currentNode];
                        heapArray[currentNode] = temp;
                        heapifyToptoBottom(currentNode*2+1);
                    }
                } else {
                    if (heapArray[currentNode] > heapArray[currentNode*2 + 1]) {
                        int temp = heapArray[currentNode * 2 + 1];
                        heapArray[currentNode * 2 + 1] = heapArray[currentNode];
                        heapArray[currentNode] = temp;
                        heapifyToptoBottom(currentNode * 2 + 1);
                    } else if (heapArray[currentNode] > heapArray[currentNode*2]) {
                        int temp = heapArray[currentNode*2];
                        heapArray[currentNode*2] = heapArray[currentNode];
                        heapArray[currentNode] = temp;
                        heapifyToptoBottom(currentNode*2);
                    }
                }
                //check one child
            } else if (currentNode*2 <= lastElementIndex) {
                if (heapArray[currentNode] > heapArray[currentNode * 2]) {
                    int temp = heapArray[currentNode * 2];
                    heapArray[currentNode * 2] = heapArray[currentNode];
                    heapArray[currentNode] = temp;
                    heapifyToptoBottom(currentNode * 2);
                }
            }
        } else {
            System.out.println("Heap is empty.");
        }
        return;
    }
}
