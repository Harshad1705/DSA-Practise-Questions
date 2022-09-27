import java.util.ArrayList;
import java.util.Collections;

// } Driver Code Ends


//User function Template for Java



class Solution {
    
    static ArrayList<Integer> sq_arr = new ArrayList<>();
    
    public static boolean func(int sum , int index){
     
        for(int i=sq_arr.size()-1 ; i>index ;i--){
            if(sum == sq_arr.get(i)){
                return true;
            }
        }
        
        return false;
        
    }
    
    
    public static boolean checkTriplet(int[] arr, int n) {
        
        for(int i=0 ; i<n ; i++){
            sq_arr.add(arr[i]*arr[i]);
        }
        
        Collections.sort(sq_arr);
        
        System.out.println(sq_arr);

        for(int i=0 ; i<n-1 ; i++){
            for(int j=i+1 ; j<n ; j++){
                
                int sum = sq_arr.get(i) + sq_arr.get(j);

                boolean ans = func(sum,j);
                
                if(ans==true){
                    return true;
                }
            }
        }
        
        
        return false;
        
    }


    public static void main(String[] args) {

        int[] arr = {4 ,49, 1 ,59 ,19 ,81 ,97 ,99 ,82, 90 ,99 ,10 ,58 ,73 ,23};
        int n = 15;
        
        System.out.println(checkTriplet(arr, n));

    }
}