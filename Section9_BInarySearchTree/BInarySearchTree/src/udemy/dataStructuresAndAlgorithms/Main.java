package udemy.dataStructuresAndAlgorithms;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        BinarySearchTreeLL bstLL = new BinarySearchTreeLL();

        bstLL.createBinarySearchTree();
        bstLL.insertNode(100);
        bstLL.insertNode(80);
        bstLL.insertNode(70);
        bstLL.insertNode(90);
        bstLL.insertNode(50);
        bstLL.insertNode(200);
        bstLL.insertNode(150);
        bstLL.insertNode(40);
        bstLL.insertNode(300);
        bstLL.insertNode(400);
        bstLL.insertNode(140);
        bstLL.insertNode(160);
        bstLL.insertNode(250);
        bstLL.insertNode(60);

        bstLL.printTreeGraphically();
        System.out.println("Pre order Traversal");
        bstLL.traversePreOrder(bstLL.root);
        System.out.println("");
        System.out.println("Level order Traversal");
        bstLL.traverseLevelOrder();
        System.out.println("");

        System.out.println("Deleting Node 50");
        bstLL.deleteNode(bstLL.root, 50);
        bstLL.printTreeGraphically();

        System.out.println("Level order Traversal");
        bstLL.traverseLevelOrder();
        System.out.println("");
    }
}
