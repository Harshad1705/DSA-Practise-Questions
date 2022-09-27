// implement a queue 

public class Queue_02 {


    public  class Queue {
        int[] arr;
        int size;
        int rear;
        int front;
        
        Queue() {
            // Implement the Constructor
            int n = 5;
            arr = new int[n];
            this.size = n;
            rear = 0;
            front = 0;
        }
    
    
        boolean isEmpty() { 
            // Implement the isEmpty() function
            return (rear == front) ;
        }
        
    
        void enqueue(int data) {
            // Implement the enqueue() function
            if(rear==size){
               return ; 
            }
            arr[rear] = data;
            rear = rear+1;
            
        }
    
        int dequeue() {
            // Implement the dequeue() function
            if(isEmpty()){
                return -1;
            }
            int temp = arr[front];
            arr[front] = -1;
            front++;
            if(front==rear){
                front = 0;
                rear=0;
            }
            return temp;
        }
    
        int front() {
            // Implement the front() function
            if(isEmpty()){
                return -1;
            }
            return arr[front];
            
        }
    
    }
    
    
}
