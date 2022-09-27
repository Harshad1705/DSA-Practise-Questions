import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Queue;

// reverse first K element in queue

public class Queue_09 {

    public static Queue<Integer> reverseElements(Queue<Integer> q, int k)
    {
        // Time cmplexity = O(n)
        // Space cmplexity = O(K)



      // reomve first K element and put into stack
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<k;i++){
             s.add(q.peek());
             q.remove();
        }
        
        // add element from stack into queue
        while(!s.isEmpty()){
            q.add(s.pop());
        }
        
        // first (n-k) remove from queue and add at last in queue
        for(int i=0;i<q.size()-k;i++){
            int temp = q.peek();
            q.remove();
            q.add(temp);
        }
        
        // return queue
        return q;
      
    }
    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        System.out.println(reverseElements(q, 3));

        
    }
}
