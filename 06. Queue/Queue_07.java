import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

// reverse a queue

public class Queue_07 {

    public static void reverse_using_recursion(Queue<Integer> q){
        
        if(q.isEmpty()){
            return;
        }   
        
        int top = q.peek();
        q.remove();
        reverse_using_recursion(q);
        q.add(top);
    }

    public static void reverse_using_stack(Queue<Integer> q){

        // Time complexity = O(n)
        // Space complexity = O(n)

        Stack<Integer> s = new Stack<>();

        while(!q.isEmpty()){
            s.push(q.remove());
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }
    }
    public static void main(String[] args) {

        Queue<Integer> q = new ArrayDeque<>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        reverse_using_stack(q);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }

        System.out.println("-----------------------");
        
        Queue<Integer> q1 = new ArrayDeque<>();

        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.add(4);

        reverse_using_recursion(q1);

        while(!q1.isEmpty()){
            System.out.println(q1.peek());
            q1.remove();
        }
    }
}
