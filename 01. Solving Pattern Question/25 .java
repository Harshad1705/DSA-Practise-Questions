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
            
            int space = n-i;
            while(space>0){
                System.out.print(" ");
                space--;
            }
            int star = 1 ;
            while(star<=i){
                System.out.print(star);
                star++;
            }
            int second_number = i-1 ;
            while(second_number>0){
                System.out.print(second_number);
                second_number--;
            }
            
            int second_space = n-i ;
            while(second_space>0){
                System.out.print(" ");
                second_space--;
            }
            
           
            System.out.println();
            i++;
        }

		
		// FOR LOOP
		System.out.println("Using For Loop");


	}         

}


//       1  
//     1 2 1
//   1 2 3 2 1
// 1 2 3 4 3 2 1

