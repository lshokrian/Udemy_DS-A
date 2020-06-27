package udemy.dataStructuresAndAlgorithms;

public class TrieNode {
    boolean endOfWord = false;
    char [] charArray;
    TrieNode [] trieArray;

    public TrieNode(int size) {
        this.endOfWord = endOfWord;
        charArray = new char[size];
        trieArray = new TrieNode[size];
    }

    public boolean isEndOfWord() {
        return endOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        this.endOfWord = endOfWord;
    }

    public char[] getCharArray() {
        return charArray;
    }

    public void setCharArray(char[] charArray) {
        this.charArray = charArray;
    }

    public TrieNode[] getTrieArray() {
        return trieArray;
    }

    public void setTrieArray(TrieNode[] trieArray) {
        this.trieArray = trieArray;
    }
}
