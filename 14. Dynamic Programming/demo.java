import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution{
    //Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        pq.add(arr[n-1]);
        
        for(int i =n-2 ; i>=0 ; i-- ){
            
            if(arr[i] > pq.peek()){
                pq.add(arr[i]);
            }
        }

        ArrayList<Integer> result =  new ArrayList<>();

        while(!pq.isEmpty()){
            result.add(pq.poll());
        }


        return result;

        
    }

    public static void main(String[] args) {
        int  n = 5;
        int A[] = {1,2,3,4,0};

        ArrayList<Integer> res = leaders(A, n);


        for(int i : res){
            System.out.println(i);
        }


    }
}