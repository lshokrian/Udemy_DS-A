package udemy.dataStructuresAndAlgorithms;

public class Main {

    public static void main(String[] args) {
        //Constructor
        LinearProbing linearProbing = new LinearProbing(13);


        linearProbing.insertHashKey("The");
        linearProbing.insertHashKey("quick");
        linearProbing.insertHashKey("brown");
        linearProbing.insertHashKey("fox");
        linearProbing.insertHashKey("over");
        linearProbing.insertHashKey("lazy");
        linearProbing.displayHashTable();

        linearProbing.insertHashKey("fox"); //use for showing collision
        linearProbing.displayHashTable();

		linearProbing.insertHashKey("fox");
		linearProbing.displayHashTable();

		linearProbing.insertHashKey("fox");
		linearProbing.displayHashTable();

		linearProbing.insertHashKey("fox");
		linearProbing.displayHashTable();

		linearProbing.insertHashKey("fox");
		linearProbing.displayHashTable();


		linearProbing.searchHashKey("jump");
		linearProbing.searchHashKey("brown");


		linearProbing.deleteHashKey("jump");
		linearProbing.deleteHashKey("quick");
		linearProbing.displayHashTable();


		linearProbing.deleteHashTable();
		linearProbing.displayHashTable();

    }
}
