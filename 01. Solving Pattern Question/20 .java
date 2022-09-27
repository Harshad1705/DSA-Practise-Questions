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
        
        int i =n;
        int s = 0;
        while(i>0){
            int z = s;
            while(z>0){
                System.out.print(" ");
                z--;
            }
            s++;
            int stars = i;
            while(stars>0){
                System.out.print("*");
                stars--;
            }
            
            System.out.println();
            i--;
        }

		
		// FOR LOOP
		System.out.println("Using For Loop");
		
		int space = 0;
        for(int row =n ;row>0;row--){
            
            for(int spaces = space ; spaces>0;spaces--){
                System.out.print(" ");
            }
            space++;
            for(int star = row ; star>0 ; star--){
                System.out.print("*");
            }
            
            System.out.println();
        }

	}         

}

// * * * *
//   * * *
//     * * 
//       *

