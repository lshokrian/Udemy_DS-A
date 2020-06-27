package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
        DoubleLL list = new DoubleLL();
        list.createDLL(5);
        list.traverseForwards();

        list.insertNode(10, 1);
        list.traverseForwards();

        list.insertNode(20, 2);
        list.traverseForwards();

        list.insertNode(30, 3);
        list.traverseForwards();

        list.insertNode(40, 4);
        list.traverseForwards();


        System.out.println("\nSearching the node having value 40: ");
        list.searchDLL(40);

        System.out.println("\n\nSearching the node having value 400: ");
        list.searchDLL(400);


        System.out.println("\n\nLinked List in order");
        list.traverseForwards();
        System.out.println("Linked List in reverse order");
        list.traverseBackwards();


        System.out.println("\n\nDeleting the node having location = 2: ");
        System.out.println("List before deletion: ");
        list.traverseForwards();
        list.deleteNode(2);
        System.out.println("List after deletion: ");
        list.traverseForwards();


        System.out.println("\n\nDeleting the node having location = 3: ");
        System.out.println("List before deletion: ");
        list.traverseForwards();
        list.deleteNode(3);
        System.out.println("List after deletion: ");
        list.traverseForwards();


        list.deleteDLL();
        list.traverseForwards();


    }
}
