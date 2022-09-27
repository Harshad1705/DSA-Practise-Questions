import java.util.ArrayDeque;
import java.util.Queue;

// first non repeating character in stream

public class Queue_10 {

    static String FirstNonRepeating(String A){
        
        // Map<Character,Integer> count = new HashMap<>();
        int[] count = new int[26];
        Queue<Character> q = new ArrayDeque<>();
        String ans = "";

        for(int i=0;i<A.length();i++){
            char ch = A.charAt(i);

            // increase count
            count[ch-'a']++;

            // queue mai push karo
            if(count[ch-'a']==1)
                q.add(ch);

            while(!q.isEmpty() && (count[q.peek()-'a']>1)){
                    // repeating character
                    q.remove();
            }

            if(q.isEmpty()){
                ans = ans+'#';
            }else{
                ans = ans+q.peek();
            }

        }
        return ans;


    }
    public static void main(String[] args) {
        String s = "aabc";
        
        System.out.println(FirstNonRepeating(s));
    }
}
