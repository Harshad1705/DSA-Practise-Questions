import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Vector;

// Kth largest sum subarray

// approah-1     - O(n^2)
// using two for loops
// store all sum in a vector
// sort the vector   - O(n^2 logN^2)
// last Kth element is our answer

public class Heap_08 {

    // approach - 1
    public static int largestSum_1(int[] arr , int k){

        // Time complexity = O(n^2 logN^2)
        // Space complexity = O(n^2)
        
        Vector<Integer> ans = new Vector<>();
        int n = arr.length;

        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j = i;j<n;j++){
                sum = sum+arr[j];
                ans.add(sum);
            }
        }

        Collections.sort(ans); 

        return ans.elementAt(ans.size()-k);
    }

    // approach - 2
    public static int largestSum_2(int[] arr , int k){

        // Time complexity = O(n^2)
        // Time complexity = O(k)
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = arr.length;

        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j = i;j<n;j++){
                sum = sum+arr[j];

                pq.add(sum);
                if(pq.size()>k){
                    pq.poll();
                }
            }
        }

        return pq.peek();
    }
    
    public static void main(String[] args) {
        
        int[] arr = {3,-2,5};
        int k = 3;

        int ans = largestSum_1(arr,k);
        System.out.println(ans);

        int ans_2 = largestSum_2(arr, k);
        System.out.println(ans_2);
    }
}
