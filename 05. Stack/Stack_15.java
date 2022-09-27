// N stack in array

public class Stack_15 {
    
    // Time complexit = O(1)
    // Space complexit = O(s+n)
    
    public class NStack {
        int[] arr;
        int[] top;
        int[] next;
        int N,S;
        int freespot;
        // Initialize your data structure.
        public NStack(int N, int S) {
            // Write your code here.
            this.N = N;
            this.S = S;
            arr = new int[this.S];
            top = new int[this.N];
            next = new int[this.S];
            
            // top initialize
            for(int i=0;i<N;i++){
                top[i] = -1;
            }
            
            // next initialize
            for(int i=0;i<S;i++){
                next[i] = i+1; 
            }
            // update last index calue to -1
            next[S-1] = -1;
            
            // initialize freespot
            freespot = 0;
        }
    
        // Pushes 'X' into the Mth stack. Returns true if it gets pushed into the stack, and false otherwise.
        public boolean push(int x, int m) {
            // check for overflow 
            if(freespot == -1){
                return false;
            }
            // find freespot
            int index = freespot;
            // update freespot
            freespot = next[index];
            // insert an element
            arr[index] = x;
            // update next 
            next[index] = top[m-1];
            // update top
            top[m-1] = index;
            
            return true;
        }
    
        // Pops top element from Mth Stack. Returns -1 if the stack is empty, otherwise returns the popped element.
        public int pop(int m) {
            // check underflow
            if(top[m-1] == -1){
                return -1;
            }
            int index = top[m-1];
            top[m-1] = next[index];
            next[index] = freespot;
            freespot = index;
            
            return arr[index];
        }
    }


}

// create arr
// create top of size number of stacks
// create next of size number of stack
// create freespot variable

// refer to image



// Algorithm
// find index              int index = freespot
// freespot update         freespot = next[index]
// insert in array         arr[index] = x
// update next             next[index] = top[m-1]
// update top              top[m-1] = index 
