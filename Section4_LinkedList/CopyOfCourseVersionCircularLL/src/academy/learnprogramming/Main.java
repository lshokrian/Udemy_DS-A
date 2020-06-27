package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
        CircularLL firstCLL = new CircularLL();

        firstCLL.createCircularLinkedList(5);

        firstCLL.insertNode(14, 0);
        System.out.println("----------------");
        firstCLL.traverseCircularLL();
        firstCLL.insertNode(18, 1);
        firstCLL.traverseCircularLL();
        System.out.println("----------------");
        firstCLL.insertNode(34, 1);
        System.out.println("----------------");
        firstCLL.traverseCircularLL();
        firstCLL.insertNode(74, 1);
        System.out.println("----------------");
        firstCLL.traverseCircularLL();
        System.out.println("----------------");
        System.out.println("Is 74 in the list? : " + firstCLL.searchCLL(74));
        System.out.println("----------------");
        System.out.println("Is 18 in the list? : " + firstCLL.searchCLL(18));
        System.out.println("----------------");
        firstCLL.deleteNode(2);
        System.out.println("----------------");
        firstCLL.traverseCircularLL();
        System.out.println("----------------");
        firstCLL.deleteNode(3);
        System.out.println("----------------");
        firstCLL.traverseCircularLL();
        System.out.println("----------------");
        firstCLL.printHeadThroughTail();
        System.out.println("----------------");
        firstCLL.deleteCircularLL();
        System.out.println("----------------");
        firstCLL.traverseCircularLL();
        System.out.println("----------------");

    }
}
