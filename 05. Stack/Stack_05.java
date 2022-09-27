import java.util.Stack;

// valid parenthesis

public class Stack_05 {

    public static Boolean valid_parenthesis(String str){
        Stack<Character> s = new Stack<>();

        for(int i=0;i<str.length();i++){

            char ch = str.charAt(i);

            if(ch=='{' || ch=='(' || ch=='['){
                s.push(ch);
            }else{
                if(!s.isEmpty()){
                    char top = s.peek();
                    if(top=='{' && ch == '}'){
                            s.pop();
                    }else if(top =='(' && ch==')'){
                            s.pop();
                    }else if(top=='[' && ch==']'){
                            s.pop();
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }

        if(s.size()==0){
            return true;
        }
        return false;
    }
    public static void main(String[] args) { 
        String s = "[(])" ;
        Boolean answer = valid_parenthesis(s);   
        System.out.println(answer);
    }
}
