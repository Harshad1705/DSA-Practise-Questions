import java.util.Stack;

// redundant brackets

public class Stack_09 {

    public static boolean redundant_brackets(String str){

        // Time complexity = O(n)

        Stack<Character> stack = new Stack<>();

        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch == '(' || ch=='+' || ch=='-' || ch=='/' || ch=='*'){
                stack.push(ch);
            }else if(ch==')'){
                if(stack.peek()!='(' && ch==')'){
                    stack.pop();
                    while(stack.peek()!='('){
                        stack.pop();
                    }
                    if(stack.peek()=='('){
                        stack.pop();
                    }
                }else if(stack.peek()=='(' && ch==')'){
                    return true;
                }
            }
        }

        return false;
    }
    public static void main(String[] args) {

        String str = "(a/c+(b))";
        Boolean ans=redundant_brackets(str);
        System.out.println(ans);
    }
}
