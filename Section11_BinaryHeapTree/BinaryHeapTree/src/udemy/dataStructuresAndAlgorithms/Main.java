package udemy.dataStructuresAndAlgorithms;

public class Main {

    public static void main(String[] args) {
        BinaryHeap bHTree = new BinaryHeap();

        bHTree.createBinaryHeap(16);
        System.out.println("Size of array: " + bHTree.sizeOfHeap());
        bHTree.insertValueInHeap(3);
        bHTree.insertValueInHeap(5);
        bHTree.insertValueInHeap(8);
        bHTree.insertValueInHeap(17);
        bHTree.insertValueInHeap(19);
        bHTree.insertValueInHeap(36);
        bHTree.insertValueInHeap(40);
        bHTree.insertValueInHeap(25);
        bHTree.insertValueInHeap(100);
        bHTree.traverseBinaryHeap();
        bHTree.insertValueInHeap(1);
        bHTree.traverseBinaryHeap();
        System.out.println("Extract Min Value: " + bHTree.extractMin());
        bHTree.traverseBinaryHeap();
        System.out.println("Extract Min Value: " + bHTree.extractMin());
        bHTree.traverseBinaryHeap();
    }
}
