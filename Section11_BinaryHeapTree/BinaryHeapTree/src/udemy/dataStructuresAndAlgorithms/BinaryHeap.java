package udemy.dataStructuresAndAlgorithms;

public class BinaryHeap {
    int [] arrayBH;
    int lastElementAdded = -1;
    boolean maxHeap;

    public void createBinaryHeap(int size) {
        if (maxHeap) {
            System.out.println("Creating Max Binary Heap...");
        } else {
            System.out.println("Creating Min Binary Heap...");
        }
        arrayBH = new int[size+1];
        lastElementAdded = 0;
        return;
    }

    // insertValueInHeap
    public void insertValueInHeap(int value) {
        if (isArrayFull()) {
            System.out.println("Error: The Binary Heap is full.");
        } else {
            lastElementAdded++;
            arrayBH[lastElementAdded] = value;
            heapifyBottomToTop();
            System.out.println(value + " was inserted into array");
        }
        return;
    }

    // heapifyBottomToTop
    public void heapifyBottomToTop() {
        if (lastElementAdded > 0) {
            int currentNode = lastElementAdded;
            int parentNode = Integer.MAX_VALUE;

            while (currentNode > 1) {
                // get parent
                if (currentNode % 2 == 0) {
                    // child is a left node
                    parentNode = currentNode / 2;
                } else {
                    // child is a right node
                    parentNode = (currentNode - 1) / 2;
                }
                if (maxHeap) {
                    if (arrayBH[currentNode] > arrayBH[parentNode]) {
                        // swap
                        int temp = arrayBH[parentNode];
                        arrayBH[parentNode] = arrayBH[currentNode];
                        arrayBH[currentNode] = temp;
                    }
                } else {
                    if (arrayBH[currentNode] < arrayBH[parentNode]) {
                        // swap
                        int temp = arrayBH[parentNode];
                        arrayBH[parentNode] = arrayBH[currentNode];
                        arrayBH[currentNode] = temp;
                    }
                }
                currentNode = parentNode;
            }
        } else {
            System.out.println("Error: The Binary Heap is empty.");
        }
    }

    // peekTopOfHeap
    public int peekTopOfHeap() {
        return arrayBH[1];
    }

    // sizeOfHeap
    public int sizeOfHeap() {
        return lastElementAdded;
    }

    // extractMin
    public int extractMin() {
        // replace the first element with last element
        int minValue = arrayBH[1];
        arrayBH[1] = arrayBH[lastElementAdded];
        lastElementAdded--;

        // now move the first element to last
        heapifyTopToBottom(1);

        return minValue;
    }


    // heapifyBottomToTop
    public void heapifyTopToBottom(int currentNode) {
        //System.out.println("Enter heapify Top to Bottom starting at node " + currentNode);
        if (lastElementAdded > 0) {
            //check if Node has children
            if ((currentNode*2 <= lastElementAdded) && (currentNode*2+1 <= lastElementAdded)) {
                //System.out.println("Node has two children.");
                if (arrayBH[currentNode*2] < arrayBH[currentNode*2+1]) {
                    //System.out.println("Left child is less than right child.");
                    // left node is less than right
                    if (arrayBH[currentNode] > arrayBH[currentNode*2]) {
                        swapElements(currentNode, currentNode*2);
                        heapifyTopToBottom(currentNode*2);
                    } else if (arrayBH[currentNode] > arrayBH[currentNode*2+1]) {
                        swapElements(currentNode, currentNode*2+1);
                        heapifyTopToBottom(currentNode*2+1);
                    }
                } else {
                    if (arrayBH[currentNode] > arrayBH[currentNode*2+1]) {
                        swapElements(currentNode, currentNode*2+1);
                        heapifyTopToBottom(currentNode*2+1);
                    } else if (arrayBH[currentNode] > arrayBH[currentNode*2]) {
                        swapElements(currentNode, currentNode*2);
                        heapifyTopToBottom(currentNode*2);
                    }
                }
            } else if (currentNode*2 <= lastElementAdded) {
                //System.out.println("Node has only left child.");
                if (arrayBH[currentNode] > arrayBH[currentNode*2]) {
                    swapElements(currentNode, currentNode*2);
                    heapifyTopToBottom(currentNode*2);
                }
            }
            return;
        }
    }

    public void swapElements(int elementOne, int elementTwo) {
        System.out.println("  Swap " + arrayBH[elementOne] + " with " + arrayBH[elementTwo]);
        int temp = arrayBH[elementOne];
        arrayBH[elementOne] = arrayBH[elementTwo];
        arrayBH[elementTwo] = temp;
    }

    // extractMax
    public int extractMax() {
        return -1;

    }

    public void traverseBinaryHeap() {
        if (lastElementAdded > 0) {
            for (int i = 1; i <= lastElementAdded; i++) {
                System.out.print(arrayBH[i] + " ");
            }
            System.out.println("");
        } else {
            System.out.println("Error: The Binary Heap is empty.");
        }
    }

    // deleteHeap
    public void deleteHeap() {
        arrayBH = null;
    }

    // isArrayFull
    public boolean isArrayFull() {
        return (lastElementAdded == (arrayBH.length - 1));
    }
}
