// K queue in a single array

public class Queue_13 {

    public class NQueue {
        // Initialize your data structure.
        int n;  // length of array
        int k;  // number of queue
        int[] arr;
        int[] rear;
        int[] front;
        int[] next;
        int freespot;
        
        public NQueue(int n, int s) {
            this.n = n;
            this.k = s;
            arr = new int[n];
            front = new int[s];
            rear = new int[s];
            next = new int[n];
            freespot = 0;
            
            // initialize front and rear array
            for(int i=0;i<s;i++){
                front[i] = -1;
                rear[i] = -1;
            }
            // initialize next array
            for(int i=0 ; i<n ;i++){
                next[i] = i+1;
            }
            next[n-1] = -1;
        }
    
        // Enqueues 'X' into the Mth queue. Returns true if it gets pushed into the queue, and false otherwise.
        public boolean enqueue(int x, int m) {
            
            // overflow
            if(freespot==-1){
                return false;
            }
            // find first free index
            int index = freespot;
            // update freespot
            freespot = next[index];
            // for first element
            if(front[m-1] == -1){
                front[m-1] = index;
            }else{
                // link new element to previous element
                next[rear[m-1]] = index;
            }
            // update next
            next[index] = -1;
            // update rear
            rear[m-1] = index;
            // push element
            arr[index] = x;
            
            return true;
        }
    
        // Dequeues top element from Mth queue. Returns -1 if the queue is empty, otherwise returns the popped element.
        public int dequeue(int m) {
            // underflow condition
            if(front[m-1]==-1){
                return -1;
            }
            // find index to pop
            int index = front[m-1];
            // front ko aage badao
            front[m-1] = next[index];
            // freeslot ko manage karo
            next[index] = freespot;
            freespot = index;
            
            return arr[index];
        }
    };
    
}


// create arr
// create top of size number of stacks
// create front of size number of stack
// create rear of size number of stack
// create freespot variable = 0

// refer to image

// Push algorithm
// check overflow condition                     if(free==-1)
// find index where we want to insert           int index = freesopt
// update freespot                              freespot = next[freespot]
// if(first element)                            if(front[qn] == -1){
//                                                  front[qn] = index
//                                              }else{
//                                                  next[rear[qn]] = index
//                                              }
//                                              next[index] = -1
// point rear to index                          rear[qn] = index
// push element                                 arr[index] = data