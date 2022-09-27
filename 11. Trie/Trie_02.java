
// Longest common prefix

public class Trie_02 {

    // Method - 1

    public static String longestCommonPrefix_1(String[] arr, int n) {

        // Time Complexity = O(m*n)   m = length of string    n = number of string
        // Space complexity = O(1)
        
		String s = "";
        for(int i=0; i<arr[0].length();i++ ){

            String str = arr[0];
            Character ch = str.charAt(i);
            boolean match = true;
            
            for(int j =1;j<arr.length;j++){

                String str2 = arr[j];
                Character ch2 = str2.charAt(i);

                if((str2.length() <=  i) ||  (ch2!=ch)){
                    match = false;
                    break;
                }
            }

            if(match==false){
                break;
            }else{
                s = s + ch;
            }
        }
        if(s.length()==0){
            String z = "-1";
            return z;
        }
        return s;
	}


    // Method - 2

    static class TrieNode_2{

        char data;
        TrieNode_2[] children = new TrieNode_2[26];
        boolean isTerminal ;
        int size;

        TrieNode_2(char ch){
            this.data = ch;
            for(int i=0;i<26;i++){
                children[i] = null;
            }
            isTerminal = false;
            size = 0;
        }

    }

    static class Trie{

        static TrieNode_2 root;
        Trie(){
            root = new TrieNode_2('\0');
        }

        public static void insertUtils(TrieNode_2 root , String word){
            // base case
            if(word.length()==0){
                root.isTerminal = true;
                return;
            }
            int index = word.charAt(0) - 'a';
            TrieNode_2 child = null;
    
            if(root.children[index]==null){
                child = new TrieNode_2(word.charAt(0));
                root.size++;
                root.children[index] = child;
            }else{
                child = root.children[index];
            }
    
            insertUtils(child, word.substring(1));;
        }
    
        public static void insert(String word){
            
            insertUtils(root,word);
          
        }


        public static String lcp(String str   ){

            String ans = "";
            for(int i=0 ; i<str.length() ; i++){
                 char ch  = str.charAt(i);

                if(root.size == 1){
                    ans = ans + ch;
                    int index = ch - 'a';
                    root = root.children[index];
                }else{
                    break;
                }
                if(root.isTerminal==true){
                    break;
                }

            }

            return ans;
        }
    
    }

    public static String longestCommonPrefix(String[] arr, int n){

        // Time Complexity = O(m*n)   m = length of string    n = number of string
        // Space Complexity = O(m*n)
        
        Trie t = new Trie();

        for(int i=0;i<n;i++){
            t.insert(arr[i]);
        }

        String first = arr[0];

        String  ans = t.lcp(first);

        return ans;

    }

    public static void main(String[] args) {
        String[] arr = {"coding", "codezen", "codingninja", "coders"};
        int n = 4;

        System.out.println(longestCommonPrefix_1(arr, n));
        System.out.println(longestCommonPrefix(arr, n));
    }
}
