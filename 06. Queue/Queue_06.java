
// doubly ended queue - with the help of this stack and queue both implemented

// push_front()    front-end
// push_back()     rear-end
// pop_front()     front-end
// pop_back()      rear-end
public class Queue_06 {

    static class Queues{

        int arr[] ;
        int size ; 
        int front;
        int rear;

        Queues(int n){
            arr = new int[n];
            this.size = n;
            this.front = -1;
            this.rear = -1;
        }

        public void push_front(int data){
            if(((rear+1%size) == front) || (front==0 && rear ==size-1   )){
                System.out.println("queue full");
                return ;
            }
            rear = (rear+1)%size;
            
            for(int i=rear;i>front;i--){
                arr[i] = arr[i-1];
            }
            arr[front] = data;
        }


        public void push_back(int data){
            if((rear+1%size) == front){
                System.out.println("queue full");
                return ;
            }
            if(front==-1){
                front = 0;
            }
            rear = (rear+1)%size;
            arr[rear] = data;
        }

        public int pop_front() {
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

        public int pop_back(){
            if(rear == -1 && front == -1){
                System.out.println("empty queue");
                return -1;
            }
            int temp = arr[rear];
            if(rear==0){
                rear = size-1;
            }else{
                rear = (rear-1)%size;
            }
            return temp;
        }
    }
    public static void main(String[] args) {
        Queues q = new Queues(5);

        q.push_back(1);
        q.push_back(2);
        q.push_back(3);
        q.push_front(0);


        System.out.println(q.pop_front());   //  0 
        System.out.println(q.pop_front());   //  1
        System.out.println(q.pop_back());    //  3



    }
}
