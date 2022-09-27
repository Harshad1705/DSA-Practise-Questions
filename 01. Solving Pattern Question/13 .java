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
            while(j<=n){
                int val = 64 + j ;
                char value = (char)val;
                System.out.print(value);
                j++;
            }
            System.out.println();
            i++;
        }

		
		// FOR LOOP
		System.out.println("Using For Loop");
        for(int row = 1 ;row<=n;row++){
            for(int col = 1 ;col<=n;col++){
                System.out.print((char)(64+col));
            }
            System.out.println();
        }
        
		
		
	}
}

    
// A B C
// A B C
// A B C