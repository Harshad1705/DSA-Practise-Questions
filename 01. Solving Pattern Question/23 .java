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
        
        int i =1;
        while(i<=n){
            int j = n -i ;
            while(j>=0){
                System.out.print(" ");
                j--;
            }
            int star = 1 ;
            while(star<=i){
                System.out.print(i);
                star++;
            }
            System.out.println();
            i++;
        }

		
		// FOR LOOP
		System.out.println("Using For Loop");
		
        for(int row =1 ;row<=n;row++){
            
            for(int space = 0 ; space<n-row;space++){
                System.out.print(" ");
            }
            for(int k = 1 ;k<= row;k++){
                System.out.print(row);
            }
            System.out.println();
        }

	}         

}

//       1
//     2 2
//   3 3 3
// 4 4 4 4