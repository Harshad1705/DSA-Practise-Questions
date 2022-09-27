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
            int j = 1 ;
            char value = (char)(64+i) ;
            while(j<=n){
                System.out.print(value);
                j++;
                value++;
            }
            System.out.println();
            i++;
        }

		
		// FOR LOOP
		System.out.println("Using For Loop");
        for(int row =1 ;row<=n;row++){
            for(int col = 1 ;col<=n;col++){
                System.out.print((char)(63+row+col));
            }
            System.out.println();
        }
        
		
		
	}         

}

    
// A B C 
// B C D 
// C D E