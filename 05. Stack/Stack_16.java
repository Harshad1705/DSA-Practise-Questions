import java.util.Stack;

// Get minimum element in O(1) space and time complexity

class Stack_16{

    public class SpecialStack {
	// Define the data members.
    Stack<Integer> s = new Stack<>();
	int mini = Integer.MAX_VALUE;

	/*----------------- Public Functions of SpecialStack -----------------*/

	void push(int data) {
        // for first element  
        if(s.isEmpty()==true){
            s.push(data);
            mini = data;
        }else{
            if(data < mini){
                int val = 2*data - mini;
                mini = data ; 
                s.push(val);
            }else{
                s.push(data);
            }
        }
        
	}

	int pop() {
		if(s.isEmpty()==true){
            return -1;
        }
        int curr = s.peek();
        if(curr > mini){
            s.pop();
            return curr;
        }else{
            int prevMin = mini;
            int val = 2*mini - curr;
            mini = val ;
            s.pop();
            return prevMin;
        }
	}

	int top() {
		if(s.isEmpty()==true){
            return -1;
        }
        int curr  = s.peek();
        if(curr < mini){
               return mini;
        }else{
            return curr; 
        }
	}

	boolean isEmpty() {
		return s.isEmpty();
	}

	int getMin() {
		if(s.isEmpty()==true){
            return -1;
        }
        return mini;
	}
}



}


// Push Algorithm
// check overflow condition
// for first element - normal push
//                    - mini update
// baaki element  if(curr < mini)
//                   val = 2*curr - mini
//                   push(val)
//                   update mini

// Pop Algorithm
// check underflow condition
// if(stack.top() > mini)
//   normal pop()
// else
//    val = 2*mini - stack.top()
//    mini = val 
//    pop()
