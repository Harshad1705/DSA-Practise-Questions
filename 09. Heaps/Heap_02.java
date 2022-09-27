import java.util.Collections;
import java.util.PriorityQueue;

public class Heap_02 {

    public static void main(String[] args) {
        
        System.out.println("Min Heap");

        PriorityQueue<Integer> min_Heap =  new PriorityQueue<>();

        min_Heap.add(25);
        min_Heap.add(10);
        min_Heap.add(20);
        min_Heap.add(30);
        min_Heap.add(40);
        min_Heap.add(50);

        while(!min_Heap.isEmpty()){
            System.out.println(min_Heap.peek());
            min_Heap.poll();
        }
        
        System.out.println("Max Heap");

        PriorityQueue<Integer> max_Heap = new PriorityQueue<>(Collections.reverseOrder());

        max_Heap.add(25);
        max_Heap.add(10);
        max_Heap.add(20);
        max_Heap.add(30);
        max_Heap.add(40);
        max_Heap.add(50);

        while(!max_Heap.isEmpty()){
            System.out.println(max_Heap.peek());
            max_Heap.poll();
        }
    }
    
}
