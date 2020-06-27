package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
        CircularDLL circularDLL = new CircularDLL();
        circularDLL.createCircularDLL(5);

        circularDLL.insertNode(83, 1);
        circularDLL.traverseCDLLForwards();

        circularDLL.insertNode(34, 2);
        circularDLL.traverseCDLLForwards();

        circularDLL.insertNode(56, 3);
        circularDLL.traverseCDLLForwards();

        circularDLL.insertNode(12, 4);
        circularDLL.traverseCDLLForwards();

        circularDLL.insertNode(43, 2);
        circularDLL.traverseCDLLForwards();

        circularDLL.insertNode(23, 4);
        circularDLL.traverseCDLLForwards();

        circularDLL.traverseCDLLBackwards();

        circularDLL.searchCDLL(12);
        circularDLL.searchCDLL(34);
        circularDLL.searchCDLL(35);
        circularDLL.searchCDLL(5);

        circularDLL.deleteNode(4);
        circularDLL.traverseCDLLForwards();

        circularDLL.deleteNode(2);
        circularDLL.traverseCDLLForwards();

        circularDLL.deleteCDLL();
        circularDLL.traverseCDLLForwards();
        circularDLL.traverseCDLLBackwards();
    }
}
