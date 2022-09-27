import java.util.Scanner;

class ForLoop_Fibonacci_Series {
    public static void main(String[] args) {
    
        int first = 0 ;
        int second = 1 ;

        Scanner scn  =  new  Scanner(System.in);
        System.out.println("Enter a number : ");
        int n =  scn.nextInt();

        int answer = 0;
        

        System.out.print(first + " " + second );

        for(int i = 2 ;i<n;i++){
            answer = first + second ;
            System.out.print(" " + answer); 
            first = second ;
            second = answer;
            

        }
        // System.out.println(answer);


    }   
}
