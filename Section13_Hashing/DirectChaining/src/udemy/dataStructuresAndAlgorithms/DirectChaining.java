package udemy.dataStructuresAndAlgorithms;

import java.util.LinkedList;

public class DirectChaining {
     // main structure
    LinkedList<String>[] hashTable;
    int size;

    // create structure
    public void createHashTable(int size) {
        this.size = size;
        hashTable = new LinkedList[size];
        return;
    }

    // insert data
    public void insertHashKey(String s) {
        System.out.println("Trying to insert: " + s);
        int hashKey = createHashKey(s);
        if (hashTable[hashKey] == null) {
            // location is hashTable is empty
            System.out.println("This is a new location: creating Linked List");
            System.out.println("Inserting [" + s + "] at " + hashKey);
            hashTable[hashKey] = new LinkedList<String>();
            hashTable[hashKey].add(s);
        } else {
            System.out.println("This is an existing location");
            System.out.println("Inserting [" + s + "] at " + hashKey);
            //hashTable[hashKey] = new LinkedList<String>();
            hashTable[hashKey].add(s);
        }
        return;
    }

    // create hash key
    public int createHashKey(String s) {
        char ch[] = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum = sum + ch[i];
        }
        System.out.println("Hash Key : " + sum % size);
        return sum % size; // keep key within table range
    }

    // search for key
    public boolean searchHashKey(String s) {
        int hashKey = createHashKey(s);
        if (hashTable[hashKey] != null && hashTable[hashKey].contains(s)) {
            System.out.println("Found [" + s + "] in hashTable.");
            return true;
        } else {
            System.out.println("Didn't find [" + s + "] in hashTable");
            return false;
        }
    }

    // delete key
    public void deleteHashKey(String s) {
        int hashKey = createHashKey(s);
        if (hashTable[hashKey] != null && hashTable[hashKey].contains(s)) {
            hashTable[hashKey].remove(s);
            System.out.println("Successfully deleted [" + s + "] from hashTable at [" + hashKey + "].");
        } else {
            System.out.println("Cannot find [" + s + "] to delete at [" + hashKey + "].");
        }
        return;
    }

    // display structure
    public void displayHashTable() {
        if (hashTable == null) {
            System.out.println("There is no table to display.");
            return;
        } else {
            System.out.println("---------- Hash Table ----------");
            for (int i = 0; i < hashTable.length; i++) {
                System.out.println("Index: " + i + ": " + hashTable[i]);
            }
        }
    }

    // delete structure
    public void deleteHashTable() {
        hashTable = null;
        System.out.println("Successfully deleted hashTable.");
        return;
    }
}
