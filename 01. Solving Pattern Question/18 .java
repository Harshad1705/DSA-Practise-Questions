import java.util.*;
public class Main
{
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		System.out.print("Enter a number : ");
		int n = scn.nextInt();
		
		System.out.println();
		
		
		// WHILE LOOP 
		System.out.println("Using While Loop");
        int i = 1 ;
        
        while(i<=n){
            int j =1;
            int value = 64 + n - i ;
            while(j<=i){
                System.out.print((char)(value+ j));
                j++;
            }
            System.out.println();
            i++;
        }

		
		// FOR LOOP
		System.out.println("Using For Loop");
		
        for(int row =1 ;row<=n;row++){
            int value = 64 + n-row;
            for(int col = 1 ;col<=row;col++){
                System.out.print((char)(value+col));
            }
            System.out.println();
        }

	}         

}

    
// D 
// C D 
// B C D 
// A B C D


