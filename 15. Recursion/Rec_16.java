import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// Phone keypad problem

class Rec_16{
    
    static Map<Integer,String> map = new HashMap<>();
    static ArrayList<String> ans = new ArrayList<>();
    
    public static void create_map(){
        
        map.put(1 ,"");
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        
    }
    
    public static void func(int[] a , int N , int index , String temp){
        
        if(index == N){
            ans.add(temp);
            return;
        }
        
        int num = a[index];
        String s = map.get(num);
        
        for(int i=0 ; i<s.length() ; i++){
            func(a , N , index+1 , temp+s.charAt(i));
        }
        
    }
    
    
    static ArrayList <String> possibleWords(int a[], int N)
    {
        create_map(); 
        
        int index = 0;
        String temp = "";
        
        func(a,N,index , temp);
        
        Collections.sort(ans);
        
        return ans;
        
    }

    public static void main(String[] args) {
        
        int n = 3;

        int a[] = {2,3,5};

        possibleWords(a, n);

        for(String i : ans){
            System.out.print(i + " ");
        }

    }
}


