
// factorial

public class Rec_02 {
    
    public static int factorial(int n){

        if(n==1){
            return 1;
        }

        int smaller_problem = factorial(n-1);
        int bigger_problem = n * smaller_problem;

        return bigger_problem;
    }
    public static void main(String[] args) {
        
        System.out.println(factorial(6));
    }
}
