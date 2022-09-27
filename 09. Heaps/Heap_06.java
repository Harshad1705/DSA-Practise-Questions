import java.util.ArrayList;
import java.util.PriorityQueue;

// minimum cost of ropes

public class Heap_06 {

    public static int  minCost(ArrayList<Integer> arr){

        PriorityQueue<Integer> pq  = new PriorityQueue<>();
        
        for(Integer i : arr){
            pq.add(i);
        }

        int ans = 0 ;
        while(pq.size()>1){
            
            int a = pq.poll();
            int b = pq.poll();

            ans = ans + a+b;

            pq.add(a+b);
        }

        return ans;
    }
    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(8);
        arr.add(5);
        arr.add(3);

        int answer = minCost(arr);
        
        System.out.println(answer);

    }
}
