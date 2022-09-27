import java.util.Stack;

// reverse a string using stack

public class Stack_03 {

    public static void main(String[] args) {

        Stack<Character> s = new Stack<>();

        String str = "Harsad" ;

        for(int i=0;i<str.length();i++){
            s.push(str.charAt(i));
        }

        String res = "";

        while(!s.isEmpty()){
            res = res + s.peek();
            s.pop();
        }

        System.out.println(res);

        // Time complexity = O(n)
        // Space complexity = O(n)
        
    }

}
