import java.util.Scanner;

class ForLoop_Prime_Number{
    public static void main(String[] args) {
        
        Scanner scn  =  new  Scanner(System.in);
        System.out.println("Enter a number : ");
        int n =  scn.nextInt();

        boolean is_prime = true;
        
        for( int i = 2 ;i<n ;i++){
            if(n%i==0){
                is_prime = false;
                break;
            }
                
        }
        if(is_prime){
            System.out.println("Prime Number");
        }else{
            System.out.println("Non-Prime Number");
        }
    }
}
