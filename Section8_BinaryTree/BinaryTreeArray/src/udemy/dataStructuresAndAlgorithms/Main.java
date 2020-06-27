package udemy.dataStructuresAndAlgorithms;

public class Main {

    public static void main(String[] args) {
        BinaryTreeArray arrayBT = new BinaryTreeArray();

        arrayBT.createBinaryTree(10);
        for (int i = 0; i <= 10; i++) {
            arrayBT.insertNode(i*5);
        }

        System.out.println("Level-Order Traversal");
        arrayBT.traverseLevelOrder();
        System.out.println("");

        System.out.println("Pre-Order Traversal");
        arrayBT.traversePreOrder(1);
        System.out.println("");

        System.out.println("In-Order Traversal");
        arrayBT.traverseInOrder(1);
        System.out.println("");

        System.out.println("Post-Order Traversal");
        arrayBT.traversePostOrder(1);
        System.out.println("");

        arrayBT.searchForNode(35);
        arrayBT.searchForNode(15);
        arrayBT.searchForNode(4);

        arrayBT.deleteNode(35);
        arrayBT.traverseLevelOrder();
        System.out.println("");
        arrayBT.deleteNode(15);
        arrayBT.traverseLevelOrder();
        System.out.println("");

        arrayBT.deleteTree();
        arrayBT.traverseLevelOrder();
        System.out.println("");

    }
}
