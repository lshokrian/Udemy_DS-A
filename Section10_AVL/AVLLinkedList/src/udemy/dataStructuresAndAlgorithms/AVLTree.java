package udemy.dataStructuresAndAlgorithms;

import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.ObjIntConsumer;

public class AVLTree {
    BinaryNode root;

    public void createAVLTree() {
        root = null;
    }

    public void insertNode(int value) {
        root = insert(root, value);
    }

    public BinaryNode insert(BinaryNode node, int value) {
        if (node == null) {
            BinaryNode newNode = new BinaryNode(value);
            newNode.setHeight(0);
            System.out.println("Inserted " + value);
            return newNode;
        } else if (node.getValue() >= value) {
            node.setLeftNode(insert(node.getLeftNode(), value));
        } else {
            node.setRightNode(insert(node.getRightNode(), value));
        }
        // Check Balance for AVL tree once insert has been done
        int balance = checkBalance(node.getLeftNode(),node.getRightNode());

        if (balance > 1) {
            // not balanced - left side is higher
            if (checkBalance(node.getLeftNode().getLeftNode(), node.getLeftNode().getRightNode()) > 0) {
                node = rightRotate(node);
            } else {
                node.setLeftNode(leftRotate(node.getLeftNode()));
                node = rightRotate(node);
            }
        } else if (balance < -1) {
            // not balanced - right side is higher
            if (checkBalance(node.getRightNode().getRightNode(), node.getRightNode().getLeftNode()) > 0) {
                node = leftRotate(node);
            } else {
                node.setRightNode(rightRotate(node.getRightNode()));
                node = leftRotate(node);
            }
        }
        if (node.getLeftNode() != null) {
            node.getLeftNode().setHeight(calculateHeight(node.getLeftNode()));
        }
        if (node.getRightNode() != null) {
            node.getRightNode().setHeight(calculateHeight(node.getRightNode()));
        }
        node.setHeight(calculateHeight(node));

        return node;
    }

    public int checkBalance(BinaryNode nodeLeft, BinaryNode nodeRight) {
        if ((nodeLeft == null) && (nodeRight == null)) {
            return 0;
        } else if (nodeLeft == null) {
            return -1 * (nodeRight.getHeight() + 1);
        } else if (nodeRight == null) {
            return nodeLeft.getHeight() + 1;
        } else {
            return nodeLeft.getHeight() - nodeRight.getHeight();
        }
    }

    public void searchTree(BinaryNode node, int value) {
        if (node == null) {
            return;
        }

        if (node.getValue() == value) {
            System.out.println("Found value.");
            return;
        } else if (node.getValue() > value) {
            searchTree(node.getLeftNode(), value);
        } else if (node.getValue() < value) {
            searchTree(node.getRightNode(), value);
        }
    }

    public void traversePreOrder(BinaryNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.getValue() + " ");
        traversePreOrder(node.getLeftNode());
        traversePreOrder(node.getRightNode());
    }

    public void traverseLevelOrder() {
        Queue<BinaryNode> queueLL = new LinkedList();

        queueLL.add(root);
        while(!queueLL.isEmpty()) {
            BinaryNode node = queueLL.remove();
            if(node.getLeftNode() != null)
                queueLL.add(node.getLeftNode());
            if(node.getRightNode() != null)
                queueLL.add(node.getRightNode());
            System.out.print(node.getValue() + " ");
        }
    }


    // right rotate
    public BinaryNode rightRotate(BinaryNode currentUnbalancedNode) {
        BinaryNode newNode = currentUnbalancedNode.getLeftNode();
        currentUnbalancedNode.setLeftNode(currentUnbalancedNode.getLeftNode().getRightNode());
        newNode.setRightNode(currentUnbalancedNode);
        currentUnbalancedNode.setHeight(calculateHeight(currentUnbalancedNode));
        newNode.setHeight(calculateHeight(newNode));
        return newNode;
    }


    // left rotate
    public BinaryNode leftRotate(BinaryNode currentUnbalancedNode) {
        BinaryNode newNode = currentUnbalancedNode.getRightNode();
        currentUnbalancedNode.setRightNode(currentUnbalancedNode.getRightNode().getLeftNode());
        newNode.setLeftNode(currentUnbalancedNode);
        currentUnbalancedNode.setHeight(calculateHeight(currentUnbalancedNode));
        newNode.setHeight(calculateHeight(newNode));
        return newNode;
    }


    // calculate Height
    public int calculateHeight(BinaryNode node) {
        if (node == null) {
            return -1;
        }

        return Math.max(calculateHeight(node.getLeftNode()), calculateHeight(node.getRightNode())) + 1;
    }

    // deleteNode
    public BinaryNode deleteNode(BinaryNode node, int value) {
        if (node == null) {
            return null;
        }

        if (node.getValue() > value) {
            node.setLeftNode(deleteNode(node.getLeftNode(), value));
        } else if (node.getValue() < value) {
            node.setRightNode(deleteNode(node.getRightNode(), value));
        } else {
            // node == value needed
            if ((node.getLeftNode() != null) && (node.getRightNode() != null)) {
                BinaryNode temp = node;
                BinaryNode minimumNode = minimumNode(temp.getRightNode());
                node.setValue(minimumNode.getValue());
                node.setRightNode(deleteNode(node.getRightNode(), minimumNode.getValue()));
            } else if (node.getLeftNode() != null) {
                node = node.getLeftNode();
            } else if (node.getRightNode() != null) {
                node = node.getRightNode();
            } else {
                node = null;
            }
            return node;
        }
        // Check Balance for AVL tree once insert has been done
        int balance = checkBalance(node.getLeftNode(),node.getRightNode());

        if (balance > 1) {
            // not balanced - left side is higher
            if (checkBalance(node.getLeftNode().getLeftNode(), node.getLeftNode().getRightNode()) > 0) {
                node = rightRotate(node);
            } else {
                node.setLeftNode(leftRotate(node.getLeftNode()));
                node = rightRotate(node);
            }
        } else if (balance < -1) {
            // not balanced - right side is higher
            if (checkBalance(node.getRightNode().getRightNode(), node.getRightNode().getLeftNode()) > 0) {
                node = leftRotate(node);
            } else {
                node.setRightNode(rightRotate(node.getRightNode()));
                node = leftRotate(node);
            }
        }
        if (node.getLeftNode() != null) {
            node.getLeftNode().setHeight(calculateHeight(node.getLeftNode()));
        }
        if (node.getRightNode() != null) {
            node.getRightNode().setHeight(calculateHeight(node.getRightNode()));
        }
        node.setHeight(calculateHeight(node));
        return node;

    }

    public BinaryNode minimumNode(BinaryNode nodeLeft) {
        if (nodeLeft.getLeftNode() == null) {
            return nodeLeft;
        }

        return minimumNode(nodeLeft.getLeftNode());
    }

    public void printTreeGraphically() {
        Queue<BinaryNode> queue = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();

        int CurrentLevel = 1;
        boolean previousLevelWasAllNull = false;
        queue.add(root);
        level.add(1);

        System.out.println("\nPrinting Level order traversal of Tree...");
        if(root == null) {
            System.out.println("Tree does not exists !");
            return;
        }
        for (int i = 0; i < (15 - CurrentLevel); i++) {
            System.out.print(" ");
        }
        while (!queue.isEmpty()) {
            if(CurrentLevel == level.peek()) { //if we are in the same level
                if(queue.peek()==null) {
                    queue.add(null);level.add(CurrentLevel+1);
                }else {
                    queue.add(queue.peek().getLeftNode());level.add(CurrentLevel+1);
                    queue.add(queue.peek().getRightNode());level.add(CurrentLevel+1);
                    previousLevelWasAllNull = false;
                }
                if (queue.peek() == null) {
                    System.out.print("E" + "  "); queue.remove(); level.remove();
                    for (int i = 0; i < (15 - (CurrentLevel*4)); i++) {
                        System.out.print(" ");
                    }
                } else {
                    System.out.print(queue.remove().getValue() + "  ");level.remove();
                    for (int i = 0; i < (15 - (CurrentLevel*4)); i++) {
                        System.out.print(" ");
                    }
                }
            }else { //level has changed
                System.out.println("\n");
                CurrentLevel++;
                if(previousLevelWasAllNull == true) {
                    break;
                }
                previousLevelWasAllNull = true;
                for (int i = 0; i < (15 - (CurrentLevel * 2)); i++) {
                    System.out.print(" ");
                }
            }
        }//end of loop
    }
}
