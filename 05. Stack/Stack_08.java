import java.util.Stack;

// sort a stack

public class Stack_08 {
    public static void sorted_insertion(Stack <Integer> myStack, int x) {

        if( myStack.isEmpty() || (!myStack.isEmpty() && myStack.peek() < x)){
            myStack.push(x);
            return ;
        }

        int top = myStack.peek();
        myStack.pop(); 
        sorted_insertion(myStack, x);
        myStack.push(top);

    }

    public static void sortStack(Stack<Integer> stack) {

        // Time complexity = O(n^2)
        
        if(stack.isEmpty()){
            return;
        }
        int top = stack.pop();
        sortStack(stack);
        sorted_insertion(stack, top);

    }   
    public static void main(String[] args) {
        
        Stack<Integer> stack = new Stack<>();

        stack.push(-2);
        stack.push(20);
        stack.push(10);
        stack.push(-50);
        stack.push(100);
        stack.push(60);

        sortStack(stack);

        System.out.println(stack);
    }
}
