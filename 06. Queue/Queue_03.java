// implement circular queue

public class Queue_03 {
    
    public class CircularQueue {
        // Initialize your data structure.
        int[] arr;
        int size;
        int front;
        int rear;
        public CircularQueue(int n) {
            arr = new int[n];
            this.size = n;
            this.front = -1;
            this.rear = -1;
        }
    
        /*
           Enqueues 'X' into the queue. Returns true if it gets pushed into the stack,
           and false otherwise.
        */
        public boolean enqueue(int value) {
            // Write your code here.
            if(((rear+1)%size) == front){
                return false;
            }
            if(front == -1){
                front = 0;
            }
            rear = (rear+1)%size ;
            arr[rear] = value;
            
            return true;
        }
    
        /*
          Dequeues top element from queue. Returns -1 if the stack is empty, otherwise
          returns the popped element.
        */
        public int dequeue() {
            // Write you code here.
            if(front==-1 && rear==-1){
                return -1;
            }
            int temp = arr[front];
            if(front==rear){
                front = -1;
                rear=-1;
            }else{
                front = (front+1)%size;
            }
            return temp;
        }
    };
}
