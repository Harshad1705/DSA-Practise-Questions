import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


// subsequence of string

public class Rec_15 {
    
    static List<String> ans = new ArrayList<>();

    public static void func(String s , int N , int index , String temp){

        if(index ==  N){
            ans.add(temp);
            return;
        }

        // exclude
        func(s , N , index+1 , temp);

        // include
        func(s , N , index+1 , temp+s.charAt(index));

    }

    public static void main(String[] args) {
        
        String s = "dxmn";

        func(s , s.length() , 0 , "");

        Collections.sort(ans);
        
        for(String i : ans){
            System.out.print(i + " ");
        }

    }
}
