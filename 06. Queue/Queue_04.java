// Input restricted queue

// push_back()    rear-end
// pop_front()    front-end
// pop_back()     rear-end

public class Queue_04 {

    static class Queue{

        int arr[] ;
        int size ; 
        int front;
        int rear;

        Queue(int n){
            arr = new int[n];
            this.size = n;
            this.front = -1;
            this.rear = -1;
        }

        public void push_back(int data){
            if(rear == size-1){
                System.out.println("queue full");
                return ;
            }
            if(front==-1){
                front = 0;
            }
            rear = rear+1;
            arr[rear] = data;
        }

        public int pop_front(){
            if(rear == -1 && front == -1){
                System.out.println("empty queue");
                return -1;
            }

            int temp = arr[0];
            for(int i=0;i<rear;i++){
                arr[i] =arr[i+1];
            }
            rear--;
            return temp;
        }

        public int pop_back(){
            if(rear == -1 && front == -1){
                System.out.println("empty queue");
                return -1;
            }
            int temp = arr[rear];
            rear--;
            return temp;
        }

    }

    public static void main(String[] args) {
        Queue q = new Queue(5);

        q.push_back(1);
        q.push_back(2);
        q.push_back(3);
        q.push_back(4);
        q.push_back(5);
        q.push_back(5);

        System.out.println(q.pop_back());
        System.out.println(q.pop_front());

    }
    
}
