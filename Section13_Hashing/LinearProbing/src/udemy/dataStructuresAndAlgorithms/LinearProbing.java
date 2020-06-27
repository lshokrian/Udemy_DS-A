package udemy.dataStructuresAndAlgorithms;

import java.util.ArrayList;

public class LinearProbing {
    String[] hashTable;
    int numPopulatedCells;
    int size;

    public LinearProbing(int size) {
        this.hashTable = new String[size];
        this.numPopulatedCells = 0;
        this.size = size;
    }

    public int createHashkey(String s) {
        char[] ch = s.toCharArray();
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            sum += ch[i];
        }
        System.out.println("Successfully created hashKey: " + sum % size);
        return sum % size;
    }


    public double getLoadFactor() {
        return numPopulatedCells * 1.0/ hashTable.length;
    }

    public void insertHashKey(String s) {
        double loadFactor = getLoadFactor();
        if (loadFactor >= 0.75) {
            System.out.println("Need to rehash: load factor has reached at least 0.75.");
            rehashKeys(s);
        } else {
            System.out.println("Inserting [" + s + "] in hashTable.");
            int hashKey = createHashkey(s);
            for (int i = hashKey; i < hashKey + hashTable.length; i++) {
                int newHashKey = i % hashTable.length;
                if (hashTable[newHashKey] == null) {
                    hashTable[newHashKey] = s;
                    System.out.println("Successfully added [" + s + "] to the hashTable at " + i + ".");
                    break;
                } else {
                    System.out.println("Location [" + s + "] already occupied.");
                }
            }
        }
        numPopulatedCells++;
    }

    // rehash
    public void rehashKeys(String s) {
        numPopulatedCells = 0;
        ArrayList<String> data = new ArrayList<String>();
        for (String existingS: hashTable) {
            if (existingS != null) data.add(existingS);
        }
        data.add(s);
        hashTable = new String[size * 2];
        for (String existingS : data) {
            insertHashKey(existingS);
        }
    }

    // search for Hash Key
    public boolean searchHashKey(String s) {
        int hashKey = createHashkey(s);
        for (int i = hashKey; i < hashTable.length; i++) {
            int newHashKey = i % hashTable.length;
            if (hashTable[newHashKey] != null && hashTable[newHashKey].equals(s)) {
                System.out.println("Successfully found [" + s + "] in the hashTable.");
                return true;
            }
        }
        System.out.println("Could not find [" + s + "] in the hashTable.");
        return false;
    }

    // delete Hash Key
    public void deleteHashKey(String s) {
        int hashKey = createHashkey(s);
        for (int i = hashKey; i < hashTable.length; i++) {
            int newHashKey = i % hashTable.length;
            if (hashTable[newHashKey] != null && hashTable[newHashKey].equals(s)) {
                System.out.println("Successfully deleting [" + s + "] from the hashTable.");
                hashTable[newHashKey] = null;
                return;
            }
        }
        System.out.println("Couldn't find [" + s + "] to delete from the hashTable.");
        return;
    }

    public void displayHashTable() {
        if (hashTable != null) {
            System.out.println("--------- Hash Table --------------");
            for (int i = 0; i < hashTable.length; i++) {
                System.out.println("Index " + i + ": " + hashTable[i]);
            }
        } else {
            System.out.println("No hashTable exists to print.");
        }
            return;
    }

    public void deleteHashTable() {
        hashTable = null;
        System.out.println("Deleted the hashTable.");
        return;
    }
}
