import java.util.Collections;
import java.util.PriorityQueue;

// median in a stream

// Time complexity = O(NlogN)
// see images


public class Heap_12 {

    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    static int median = 0;

    public static int[] findMedian(int[] arr, int n) {
        
        int[] ans  = new int[n];

        for(int i=0;i<n;i++){
            calMedian(arr[i]);
            ans[i] = median;
        }
        return ans;
        
    }

    public static void calMedian(int element) {

        switch( signum(maxHeap.size(), minHeap.size())){

            case 0 : if(element > median){
                        minHeap.add(element);
                        median = minHeap.peek();
                    }else{
                        maxHeap.add(element);
                        median = maxHeap.peek();
                    }
                    break;

            case 1 : if(element >  median){
                        minHeap.add(element);
                        median = (minHeap.peek() + maxHeap.peek()) / 2;
                    }else{
                        minHeap.add(maxHeap.poll());
                        maxHeap.add(element);
                        median = (minHeap.peek() + maxHeap.peek()) / 2;
                    }
                    break;

            case -1:  if(element > median){
                            maxHeap.add(minHeap.poll());
                            minHeap.add(element);
                            median = (minHeap.peek() + maxHeap.peek()) / 2;
                    }else{
                        maxHeap.add(element);
                        median = (minHeap.peek() + maxHeap.peek()) / 2;
                    }
                    break;

        }

    }

    public static int signum(int a , int b){
        if(a==b){
            return 0;
        }else if(a>b){
            return 1;
        }else{
            return -1;
        }
    }





    public static void main(String[] args) {
        int[] arr= {1,2,3 };

        int[] ans =  findMedian(arr, arr.length);

        for(int i : ans ){
            System.out.print(i + " ");
        }
    }
    
}
