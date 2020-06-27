package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
        SingleLL firstSLL = new SingleLL();

        firstSLL.insertNode(14, 0);
        System.out.println("----------------");
        firstSLL.traverseSingleLL();
        firstSLL.insertNode(18, 1);
        firstSLL.traverseSingleLL();
        System.out.println("----------------");
        firstSLL.insertNode(34, 1);
        System.out.println("----------------");
        firstSLL.traverseSingleLL();
       firstSLL.insertNode(74, 1);
       System.out.println("----------------");
       firstSLL.traverseSingleLL();
       System.out.println("----------------");
       System.out.println("Is 74 in the list? : " + firstSLL.searchSingleLL(74));
       System.out.println("----------------");
       System.out.println("Is 18 in the list? : " + firstSLL.searchSingleLL(18));
       System.out.println("----------------");
       firstSLL.deleteNode(2);
       System.out.println("----------------");
       firstSLL.traverseSingleLL();
       System.out.println("----------------");
       firstSLL.deleteSingleLL();
       System.out.println("----------------");
       firstSLL.traverseSingleLL();
    }
}
