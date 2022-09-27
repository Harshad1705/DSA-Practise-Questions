
// reverse a string

public class Rec_08 {
    
    public static void reverse( StringBuilder s , int i , int j){

        // base case
        if(i > j){
            return;
        }

        char temp = s.charAt(i);
        s.setCharAt(i , s.charAt(j) );
        s.setCharAt(j, temp); 

        i++;
        j--;

        // recursion call
        reverse(s, i, j);
    }

    public static void main(String[] args) {
        
        StringBuilder s = new StringBuilder("Harry");

        reverse(s, 0, s.length()-1);

        System.out.println(s);


    }
}
