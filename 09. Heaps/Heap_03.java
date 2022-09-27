
import java.util.Collections;
import java.util.PriorityQueue;

// kth smallest element
// Kth largest element

public class Heap_03 {

    public static int kthSmallest_1(int[] arr , int K){

        // create max Heap
        PriorityQueue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());

        // place element inside heap
        for(int i : arr){
            max_heap.add(i);
            // if heap size if greater than K than pop element
            if(max_heap.size()>K){
                max_heap.poll();
            }
        }

        // return top value
        return max_heap.peek();
    }
    public static int kthSmallest_2(int[] arr , int K){

        PriorityQueue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<K;i++){
            max_heap.add(arr[i]);    
        }

        for(int i=K ; i<arr.length;i++){
            if(arr[i]<max_heap.peek()){       
                max_heap.poll();
                max_heap.add(arr[i]);
            }
        }

        return max_heap.peek();
    }

    // largest element
    public static int largest(int[] arr , int k){

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i : arr){
            pq.add(i);

            if(pq.size() >  k){
                pq.poll();
            }
        }

        return pq.peek();
    }
    public static void main(String[] args) {
        
        int[] arr = {7 ,10, 4, 3, 20, 15};
        int K = 3;

        // using min heap
        int ans = kthSmallest_1(arr, K);

        System.out.println(ans);


        // using max heap

        int ans_2 = kthSmallest_2(arr, K);

        System.out.println(ans_2);



    }
}   
