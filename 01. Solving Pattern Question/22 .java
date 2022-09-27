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
            int spaces = i-1;
            while(spaces>0){
                System.out.print(" ");
                spaces--;
            }
            int star =  n-i+1;
            while(star>0){
                System.out.print(n-star+1);
                star--;
            }
            System.out.println();
            i++;
        }

		
		// FOR LOOP
		System.out.println("Using For Loop");
		
        for(int row = 1 ;row<=n;row++){
            for(int s = row-1 ;s>0;s--){
                System.out.print(" ");
            }
            for(int sn = n-row+1;sn>0;sn--){
                System.out.print(n-sn+1);
            }
            
            System.out.println();
        }

	}         

}

// 1 2 3 4
//   2 3 4
//     3 4
//       4

