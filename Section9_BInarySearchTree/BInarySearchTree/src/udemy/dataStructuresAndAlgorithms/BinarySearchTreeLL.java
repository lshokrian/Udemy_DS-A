package udemy.dataStructuresAndAlgorithms;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeLL {
    Node root;

    public void createBinarySearchTree() {
        root = null;
    }

    // insert node
    public void insertNode(int value){
        root = insertNode(root, value);
    }
    public Node insertNode(Node node, int value) {
        if (node == null) {
            Node newNode = new Node(value);
            System.out.println("Inserting node with value [ " + value + " ]");
            return newNode;
        } else if (node.getValue() >= value) {
            node.setLeftChild(insertNode(node.getLeftChild(), value));
        } else if (node.getValue() < value) {
            node.setRightChild(insertNode(node.getRightChild(), value));
        }
        return node;
    }

    // search tree
    public void searchTree(Node node, int value) {
        if(node == null) {
            return;
        } else if(node.getValue() == value) {
            System.out.println("Found value.");
            return;
        } else if(node.getValue() > value) {
            searchTree(node.getLeftChild(), value);
        } else if(node.getValue() < value) {
            searchTree(node.getRightChild(), value);
        }
    }

    // traverse tree - preorder
    public void traversePreOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getValue() + " ");
        traversePreOrder(node.getLeftChild());
        traversePreOrder(node.getRightChild());
    }

    // traverse tree - inorder

    // traverse tree - postorder

    // traverse tree - levelorder
    public void traverseLevelOrder() {
        Queue<Node> queueLL = new LinkedList();

        queueLL.add(root);
        while(!queueLL.isEmpty()) {
            Node node = queueLL.remove();
            if(node.getLeftChild() != null)
                queueLL.add(node.getLeftChild());
            if(node.getRightChild() != null)
                queueLL.add(node.getRightChild());
            System.out.print(node.getValue() + " ");
        }
    }


    // delete node
    public Node deleteNode(Node node, int value) {
        if (node == null)
            return null;

        if (node.getValue() > value) {
            node.setLeftChild(deleteNode(node.getLeftChild(), value));
        } else if (node.getValue() < value) {
            node.setRightChild(deleteNode(node.getRightChild(),value));
        } else {
            if (node.getLeftChild() != null && node.getRightChild() != null) {
                //two children
                Node temp = node;

                Node minRightNode = minumumElement(temp.getRightChild());
                node.setValue(minRightNode.getValue());
                node.setRightChild(deleteNode(node.getRightChild(),minRightNode.getValue()));

            } else if (node.getLeftChild() != null) {
                node = node.getLeftChild();
            } else if (node.getRightChild() != null) {
                node = node.getRightChild();
            } else {
                node = null;
            }
        }
        return node;
    }

    // minimum element
    public Node minumumElement(Node node) {
        if (node.getLeftChild() == null)
            return node;
        else {
            return minumumElement(node.getLeftChild());
        }
    }

    // delete tree
    public void deleteTree() {
        root = null;
    }

    // print Tree Graphically
    public void printTreeGraphicallyCopy() {
        Queue<Node> queueLL = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();

        int currentLevel = 1;
        boolean previousLevelWasAllNull = false;

        queueLL.add(root);
        level.add(1);

        System.out.println("Printing Level order traversal of Tree...");
        if(root == null) {
            System.out.println("Tree does not exist.");
            return;
        }

        while(!queueLL.isEmpty()) {
            if(currentLevel == level.peek()) { //if we are on the same level
                if(queueLL.peek()==null) {
                    queueLL.add(null);
                    level.add(currentLevel+1);
                } else {
                    queueLL.add(queueLL.peek().getLeftChild());
                    level.add(currentLevel+1);
                    queueLL.add((queueLL.peek().getRightChild()));
                    level.add(currentLevel+1);
                    previousLevelWasAllNull = false;
                }
                System.out.println(queueLL.remove().getValue() + "  ");
                level.remove();
            } else { //level has changed
                System.out.println("\n");
                currentLevel++;
                if(previousLevelWasAllNull == true) {
                    break;
                }
                previousLevelWasAllNull = true;
            }
        } //end of loop
    } //end of method
    void printTreeGraphically() {
        Queue<Node> queue = new LinkedList<Node>();
        Queue<Integer> level = new LinkedList<Integer>();

        int CurrentLevel = 1;
        boolean previousLevelWasAllNull = false;
        queue.add(root);
        level.add(1);

        System.out.println("\nPrinting Level order traversal of Tree...");
        if(root == null) {
            System.out.println("Tree does not exists !");
            return;
        }

        while (!queue.isEmpty()) {
            if(CurrentLevel == level.peek()) { //if we are in the same level
                if(queue.peek()==null) {
                    queue.add(null);level.add(CurrentLevel+1);
                }else {
                    queue.add(queue.peek().getLeftChild());level.add(CurrentLevel+1);
                    queue.add(queue.peek().getRightChild());level.add(CurrentLevel+1);
                    previousLevelWasAllNull = false;
                }
                System.out.print(queue.remove().getValue() + "  ");level.remove();
            }else { //level has changed
                System.out.println("\n");
                CurrentLevel++;
                if(previousLevelWasAllNull == true) {
                    break;
                }
                previousLevelWasAllNull = true;
            }
        }//end of loop
    }//end of method
}
