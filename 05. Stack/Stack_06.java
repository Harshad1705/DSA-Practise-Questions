import java.util.Stack;

// insert element at bottom of stack

public class Stack_06 {

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
    public static void main(String[] args) {
        
        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);

        Stack<Integer> newStack = pushAtBottom(stack, 5);

        System.out.println(newStack);
    }
}
