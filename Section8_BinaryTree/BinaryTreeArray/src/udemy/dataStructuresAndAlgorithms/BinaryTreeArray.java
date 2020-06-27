package udemy.dataStructuresAndAlgorithms;

public class BinaryTreeArray {
    int[] array;
    int lastUsedIndex;

    public void createBinaryTree(int size) {
        array = new int[size+1];
        lastUsedIndex = 0;
    }

    // insert Node
    public void insertNode(int value) {
        if (lastUsedIndex < array.length - 1) {
            array[++lastUsedIndex] = value;
            System.out.println("Inserted value [ " + value + " ] in tree at.");
            return;
        }
        System.out.println("Binary Tree is already full - can't insert value [ " + value + "]");
        return;
    }

    // search tree
    public void searchForNode(int value) {
        for (int i = 1; i <= lastUsedIndex; i++) {
            if (array[i] == value) {
                System.out.println("Found value [ " + value + " ] in tree.");
                return;
            }
        }
        System.out.println("Didn't find value [ " + value + " ] in tree.");
        return;
    }

    // traverse preorder
    public void traversePreOrder(int index) {
        if (index > lastUsedIndex) {
            return;
        }

        System.out.print(array[index] + " ");
        traversePreOrder(index*2);
        traversePreOrder(index*2 + 1);
    }

    // traverse inorder
    public void traverseInOrder(int index) {
        if (index > lastUsedIndex) {
            return;
        }

        traverseInOrder(index*2);
        System.out.print(array[index] + " ");
        traverseInOrder(index*2 + 1);
    }


    // traverse postorder
    public void traversePostOrder(int index) {
        if (index > lastUsedIndex) {
            return;
        }

        traversePostOrder(index*2);
        traversePostOrder(index*2 + 1);
        System.out.print(array[index] + " ");
    }

    // traverse levelOrder
    public void traverseLevelOrder() {
        if (lastUsedIndex > 0) {
            for (int i = 1; i <= lastUsedIndex; i++) {
                System.out.print(array[i] + " ");
            }
        } else {
            System.out.println("Binary Tree is empty");
        }
    }

    // delete tree
    public void deleteTree() {
        array = null;
        lastUsedIndex = 0;
    }

    // delete node
    public void deleteNode(int value) {
        if (lastUsedIndex > 0) {
            for (int i = 0; i <= lastUsedIndex; i++) {
                if (array[i] == value) {
                    array[i] = array[lastUsedIndex];
                    lastUsedIndex--;
                    return;
                }
            }
        }
        System.out.println("Binary Tree is empty.");
    }

}
