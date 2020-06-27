package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
	// write your code her
         CircularLinkedList firstSLL = new CircularLinkedList();

                firstSLL.insertNode(14, 0);
                System.out.println("----------------");
                firstSLL.traverseCircularLinkedList();
                System.out.println("----------------");
                firstSLL.insertNode(18, 1);
                firstSLL.traverseCircularLinkedList();
                System.out.println("----------------");
                firstSLL.insertNode(34, 1);
                System.out.println("----------------");
                firstSLL.traverseCircularLinkedList();
        firstSLL.insertNode(74, 1);
        System.out.println("----------------");
        firstSLL.traverseCircularLinkedList();
        System.out.println("----------------");
        System.out.println("Is 74 in the list? : " + firstSLL.searchCircularLinkedList(74));
        System.out.println("----------------");
        System.out.println("Is 18 in the list? : " + firstSLL.searchCircularLinkedList(12));
        System.out.println("----------------");
        firstSLL.deleteNode(2);
        System.out.println("----------------");
        firstSLL.traverseCircularLinkedList();
        System.out.println("----------------");
        firstSLL.deleteCircularLinkedList();
        System.out.println("----------------");
        firstSLL.traverseCircularLinkedList();
    }
}
