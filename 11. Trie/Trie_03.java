import java.util.ArrayList;

// Implement phone directory


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


class Trie{

    static TrieNode root;
    
    Trie(){
        root = new TrieNode('\0');
    }
    
    public void insertUtil(TrieNode root , String word ){

        if(word.length() ==0 ){
            root.isTerminal = true;
            return;
        }

        int index = word.charAt(0) - 'a';
        TrieNode child;

        if(root.childern[index] != null){
            child = root.childern[index];

        }else{
            child = new TrieNode(word.charAt(0));
            root.childern[index] = child;
        }
        insertUtil(child, word.substring(1));
    }
    public void insert(String word){
        insertUtil(root, word);
    }


    public static ArrayList<String> printSuggestion(TrieNode curr,  String prefix) {

        ArrayList<String> list = new ArrayList<>();


        if(curr.isTerminal==true){
            list.add(prefix);
        }

        for(char ch = 'a' ; ch <='z' ; ch ++){
            TrieNode next = curr.childern[ch - 'a'];
            if(next!=null){
                prefix = prefix + ch;
                ArrayList<String> temp = printSuggestion(next,  prefix);
                prefix =  prefix.substring(0, prefix.length() - 1);
                
                for(String s : temp){
                    list.add(s);
                }
            }
        }

        return list;

    }

    public static ArrayList<ArrayList<String>> getSuggestion(String str){

        TrieNode prev = root;
        ArrayList<ArrayList<String>> output = new ArrayList<>();
        String prefix = "";

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);

            prefix = prefix + ch;

            // check for last ch
            TrieNode curr = prev.childern[ch - 'a'];

            // if not found
            if(curr == null){
                break;
            }
            // if found
            ArrayList<String> temp = printSuggestion(curr ,  prefix);
            

            output.add(temp);
            temp.clear();
            prev = curr;
            
        
        }
        return output; 
    }

    


}

public class Trie_03 {

    public static ArrayList<ArrayList<String>> phoneDirectory(ArrayList<String> contactList, String queryStr){

        // Time complexity = O(n*(m^2))
        // Space complexity = O(n*(m))
        
        Trie t = new Trie();

        for(int i=0 ; i< contactList.size() ;i++){
            String s = contactList.get(i);
            t.insert(s);
        }

        return t.getSuggestion(queryStr);
    }



    public static void main(String[] args) {
        
        ArrayList<String> contcat = new ArrayList<>();
        contcat.add("cod");
        contcat.add("coding");
        contcat.add("codding");
        contcat.add("code");
        contcat.add("coly");

        String query = "coding";

       ArrayList<ArrayList<String>> ans =  phoneDirectory(contcat, query);


       for(ArrayList<String> ar : ans){
        for(String s : ar){
            System.out.print(s + " ");
        }
        System.out.println();
       }
    }
    
}




// IN C++




// class TrieNode{
//     public : 
//     char data;
//     TrieNode* children[26];
//     bool isTerminal;

//     TrieNode(char data){
//         this->data = data;
//         for(int i=0;i<26;i++){
//             children[i] = NULL;
//         }
//         isTerminal = false;
//     }
// };
// class Trie{
//     public :
//      TrieNode* root;
    
//     Trie(){
//         root = new TrieNode('\0');
//     }
    
//      void insertUtil(TrieNode* root , string word ){

//         if(word.length() ==0 ){
//             root->isTerminal = true;
//             return;
//         }

//         int index = word[0] - 'a';
//         TrieNode* child;

//         if(root->children[index] != NULL){
//             child = root->children[index];

//         }else{
//             child = new TrieNode(word[0]);
//             root->children[index] = child;
//         }
//         insertUtil(child, word.substr(1));
//     }
//      void insert(string word){
//         insertUtil(root, word);
//     }
       
//     void printSuggestion(TrieNode* curr , vector<string> &temp , string prefix){
        
//         if(curr->isTerminal){
//             temp.push_back(prefix);
//         }
        
//         for(char ch = 'a' ; ch<='z' ; ch++){
//             TrieNode* next = curr->children[ch-'a'];
//             if(next!=NULL){
//                 prefix.push_back(ch);
//                 printSuggestion(next,temp,prefix);
//                 prefix.pop_back();
//             }
//         }
//     }
    
//    vector<vector<string>> getSuggestion(string str){
//         TrieNode* prev = root;
//         vector<vector<string>> output;
//         string prefix = "";
        
//         for(int i=0;i<str.length();i++){
//               char lastch = str[i];
//             prefix.push_back(lastch);
            
//             // check for last ch
//             TrieNode* curr = prev->children[lastch - 'a'];
            
//             // if not found
//             if(curr == NULL)
//                 break;
            
//             // if found  
//             vector<string> temp;
//             printSuggestion(curr,temp,prefix);
            
//             output.push_back(temp);
//             temp.clear();
//             prev = curr;
//         }
        
//         return output;
//     }
// };

// vector<vector<string>> phoneDirectory(vector<string>&contactList, string &queryStr)
// {   // creation of tree
//     Trie* t = new Trie();
//     // insert all contact in tree
//     for(int i=0;i<contactList.size();i++){
//         string s = contactList[i];
//         t->insert(s);
//     }    
    
//     // return ans
//     return t->getSuggestion(queryStr);
// }
