import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// permutation of string

class Rec_17 {
    
    static List<String> ans = new ArrayList<>();
    
    public static String swap(String s , int first , int second){
        
        StringBuilder sb = new StringBuilder(s);
        
        char temp = sb.charAt(first);
        sb.setCharAt(first , sb.charAt(second));
        sb.setCharAt(second , temp);
        
        return sb.toString();
    }
    
    public static void solve(String s , int N , int index){
        
        // base case
        if(N == index){
            if(!ans.contains(s))
                ans.add(s);
            return;
        }
        
        for(int i=index ; i<N ; i++){
            s = swap(s , i , index);
            solve(s , N , index+1 );
            // backtrack
            swap(s , i , index);
        }
        
    }
    
    public static List<String> find_permutation(String S) {
        
        int len = S.length();
        int index = 0;
        
        solve(S,len,index);
        
        Collections.sort(ans);
        
        return ans;
    
    }

    public static void main(String[] args) {
        
        String s = "ABC";

        find_permutation(s);

        for(String i : ans){
            System.out.print(i + "  ");
        }

    }
}
