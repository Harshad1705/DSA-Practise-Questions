import java.util.ArrayDeque;
import java.util.Queue;

class Queue_01{
    public static void main(String[] args) {
        
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        System.out.println("Size of queue : " + q.size());

        q.remove();

        System.out.println("Size of queue : " + q.size());

        if(q.isEmpty()){
            System.out.println("Queue is empty");
        }else{
            System.out.println("Queue is not empty");
        }

        System.out.println(q.peek());
    }
}