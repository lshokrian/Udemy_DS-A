package udemy.dataStructuresAndAlgorithms;

public class Main {

    public static void main(String[] args) {
        // Constructor
        DirectChaining directChaining = new DirectChaining();

        directChaining.createHashTable(13);

        directChaining.insertHashKey("The");
        directChaining.insertHashKey("quick");
        directChaining.insertHashKey("brown");
        directChaining.insertHashKey("fox");
        directChaining.insertHashKey("over");
        directChaining.insertHashKey("lazy");
        directChaining.displayHashTable();

        directChaining.insertHashKey("fox"); // use for showing collision
        directChaining.displayHashTable();

        directChaining.insertHashKey("fox");
        directChaining.displayHashTable();

        directChaining.insertHashKey("fox");
        directChaining.displayHashTable();

        directChaining.insertHashKey("fox");
        directChaining.displayHashTable();

        directChaining.searchHashKey("jump");
        directChaining.searchHashKey("brown");


        directChaining.deleteHashKey("jump");
        directChaining.deleteHashKey("quick");
        directChaining.displayHashTable();


        directChaining.deleteHashTable();
        directChaining.displayHashTable();

    }
}
