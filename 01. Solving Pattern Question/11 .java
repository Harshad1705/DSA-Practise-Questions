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
        int row = 1;
        while(row<=n){
            int col = 1 ;
            int value = row;
            while(col<=row){
                System.out.print(value);
                value--;
                col++;
            }
            System.out.println();
            row++;
        }

		
		// FOR LOOP
		System.out.println("Using For Loop");
        for(int i= 1 ;i<=n;i++){
          for(int j = 1 , count =i;j<=i;j++,count--){
              System.out.print(count);
          }
          System.out.println();
            
        }
        
		
		
	}
}

// 1       
// 2 1                          
// 3 2 1
// 4 3 2 1      

