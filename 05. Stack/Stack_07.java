import java.util.Stack;

// reverse a stack

public class Stack_07 {
    public static Stack<Integer> pushAtBottom(Stack <Integer> myStack, int x) {
        if(myStack.size()==0){
            myStack.push(x);
            return myStack;
        }

        int top = myStack.pop();
        pushAtBottom(myStack, x);
        myStack.push(top);

        return myStack;
    }

    public static void reverseStack(Stack<Integer> stack) {

        // Time complexity = O(n^2)
        
        if(stack.size()==0){
            return;
        }
        int top = stack.pop();
        reverseStack(stack);
        pushAtBottom(stack, top);

    }   
    public static void main(String[] args) {
        
        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);

        reverseStack(stack);

        System.out.println(stack);
    }
}
