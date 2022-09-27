import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

// interleave the first half of queue with second half

public class Queue_12 {

    public static void push_at_bottom(Stack<Integer> s , int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        push_at_bottom(s, data);
        s.push(top);

    }

    public static void reverse(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top = s.pop();
        reverse(s);
        push_at_bottom(s,top);
    }

    public static void interleave_queue_with_using_stack(Queue<Integer> q){

        // Time complexity = O(n)
        // Space complexity = O(n)
        
        Stack<Integer> s = new Stack<>();

        int size = q.size();
        size = size/2;

        while(size>0){
            s.push(q.peek());
            q.remove();

            size--;
        }

        reverse(s);

        while(!s.isEmpty()){
            q.add(s.pop());
            q.add(q.peek());
            q.remove();
        }

        System.out.println(q);
    }

    public static void interleave_queue_without_using_stack(Queue<Integer> q){

        // Time complexity = O(n)
        // Space complexity = O(n)

        int size = q.size();
        size = size/2;

        Queue<Integer> second = new ArrayDeque<>();

        while(size>0){
            second.add(q.peek());
            q.remove();
            size--;
        }

        while(!second.isEmpty()){

            q.add(second.peek());
            second.remove();

            int temp = q.peek();
            q.remove();
            q.add(temp);

        }

        System.out.println(q);
    }

    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(11);
        q.add(12);
        q.add(13);
        q.add(14);
        q.add(15);
        q.add(16);
        q.add(17);
        q.add(18);

        interleave_queue_without_using_stack(q);

        q.clear();
        q.add(11);
        q.add(12);
        q.add(13);
        q.add(14);
        q.add(15);
        q.add(16);
        q.add(17);
        q.add(18);

        interleave_queue_with_using_stack(q);
    
    }
}
