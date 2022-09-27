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
        while(i>0){
            
            int num = 1 ;
            while(num<=i){
                System.out.print(num);
                num++;
            }
            
            
            int space = n-i;
            while(space>0){
                System.out.print("**");
                space--;
            }
            
            int second_number = i ;
            while(second_number>0){
                System.out.print(second_number);
                second_number--;
            }
            
           
            System.out.println();
            i--;
        }

		



	}         

}


// 1 2 3 4 5 5 4 3 2 1
// 1 2 3 4 * * 4 3 2 1
// 1 2 3 * * * * 3 2 1
// 1 2 * * * * * * 2 1
// 1 * * * * * * * * 1

