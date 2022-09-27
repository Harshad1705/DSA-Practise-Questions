
class TrieNode{
    char data;
    TrieNode childern[] = new TrieNode[26];
    boolean isTerminal;

    TrieNode(char data){
        this.data = data;
        for(int i=0;i<26;i++){
            childern[i] = null;
        }
        isTerminal = false;
    }
}

public class Trie_01{
    // create a static "Root" node
    static TrieNode root;

    // constrictor of class - inr which all value in array of children is NULL
    Trie_01(){
        root = new TrieNode('\0');
    }
    
    // insertion using recursion
    public void insertUtil(TrieNode root , String word ){

        // base case
        if(word.length() ==0 ){
            root.isTerminal = true;
            return;
        }
        // assuming word in all CAPS
        int index = word.charAt(0) - 'A';
        TrieNode child;

        // present
        if(root.childern[index] != null){
            child = root.childern[index];

        }else{
            // absent
            child = new TrieNode(word.charAt(0));
            root.childern[index] = child;
        }
        // recursion
        insertUtil(child, word.substring(1));
    }

    // insert function
    public void insert(String word){
        // Time complexity = O(l)  l = length of word
        insertUtil(root, word);
    }



    // seraching using recursion
    public boolean searchUtil(TrieNode root , String word){

        // base case
        if(word.length()==0){
            return root.isTerminal;
        }

        int index = word.charAt(0)- 'A';

        TrieNode child = null;

        if(root.childern[index]==null){
            return false;
        }else{
            child = root.childern[index];
            
        }

        return searchUtil(child, word.substring(1));
    }
    // search function
    public boolean search(String word){
        // Time complexity = O(l)  l = length of word
        return searchUtil(root, word);
    }



    // remove using recursion
    public void removeUtil(TrieNode root , String word){

        if(word.length()==0){
            root.isTerminal = false;
            return;
        }

        int index = word.charAt(0)- 'A';
        TrieNode child = null;

        child = root.childern[index];

        removeUtil(child, word.substring(1));
    }
    // remove function
    public void remove(String word){

        // Time complexity = O(l)  l = length of word 

        if(search(word)==true){
            removeUtil(root , word);
        }
        else {
            System.out.println("Element not present");
        }
    }
    public static void main(String[] args) {
        
        Trie_01 t = new Trie_01();

        t.insert("ARM");
        t.insert("DO");
        t.insert("TIME");

        System.out.println(t.search("TIME"));
        System.out.println(t.search("TIM"));

        t.insert("TITS");
        t.insert("ARMY");

        System.out.println(t.search("ARMY"));
        t.remove("ARMY");
        System.out.println(t.search("ARMY"));
        t.remove("ARMY");
        
    }

}