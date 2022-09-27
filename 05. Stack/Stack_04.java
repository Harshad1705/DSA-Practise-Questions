import java.util.Stack;

// delete middle element of stack

public class Stack_04 {
    
    public static void delete_middle(Stack<Integer> s , int count){
        
        if(count == s.size()){
            s.pop();
            return;
        }
        int top = s.pop();
        delete_middle(s, count);
        s.push(top);


    }

    public static void main(String[] args) {
        
        Stack<Integer> s = new Stack<>();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        s.push(7);

        int count = s.size()%2==0 ? (s.size()/2) : (s.size()/2)+1 ;

        delete_middle(s, count);

        System.out.println(s);
    }
}

