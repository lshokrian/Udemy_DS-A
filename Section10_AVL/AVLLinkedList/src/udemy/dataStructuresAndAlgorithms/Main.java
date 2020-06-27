package udemy.dataStructuresAndAlgorithms;

public class Main {

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();

        avlTree.createAVLTree();

        avlTree.insertNode(30);
        avlTree.insertNode(20);
        avlTree.insertNode(40);
        avlTree.insertNode(10);
        avlTree.insertNode(5);
        avlTree.insertNode(3);
        avlTree.insertNode(4);
        avlTree.insertNode(50);
        avlTree.insertNode(60);
        avlTree.insertNode(70);
        avlTree.insertNode(65);

        System.out.print("Traversing the tree: ");
        avlTree.traversePreOrder(avlTree.root);
        System.out.println("");
        System.out.print("Traversing the tree: ");
        avlTree.traverseLevelOrder();
        System.out.println("");

        avlTree.deleteNode(avlTree.root, 30);
        System.out.print("Traversing the tree: ");
        avlTree.traverseLevelOrder();
        System.out.println("");

        avlTree.printTreeGraphically();
    }
}
