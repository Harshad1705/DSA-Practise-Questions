import java.util.Stack;
// minimum cost to make string valid 
// condition   no of open bracket = no of close bracket
//             every close bracket have open bracket before it 

public class Stack_10 {
    
    public static int findMinimumCost(String str) {

        if(str.length()%2!=0){
            return -1;
        }

        Stack<Character> stack = new Stack<>();

        int count = 0;
        
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);

            if(ch=='{'){
                stack.push(ch);
            }else if(ch=='}'){
                if( (!stack.isEmpty())  &&  (stack.peek()=='{') ){
                    stack.pop();
                }else if(stack.isEmpty()){
                    count++;
                }
            }
        }

        int open_braces = stack.size();
        int close_braces = count;

        return ((open_braces+1)/2) + ((close_braces+1)/2);
        
        
    }
    public static void main(String[] args) {
        String str = "}}}}}{";
        int ans = findMinimumCost(str);
        System.out.println(ans);
    }
}

// Algorithm

// 1. string length odd  = return -1;
// 2. input string mai se valid part remove kar doo
// 3. only three possible combination remains : 
//    -  }}}}}} return length/2;
//    -  {{{{{{ return length/2;
//    -  }}}{{{ in this case two more cases possible 
//             -- }}} {{{ (odd length)    - { } { } { } return length+1/2;
//             -- }}}} {{{{ (even length) - { }{ }{ }{ } retun length+1/2;

//     overall formula = ( length of open brackets + 1 )   + ( lenght of close brackest + 1 )
                        //  --------------------------------    ----------------------------------
                        //                2                                    2