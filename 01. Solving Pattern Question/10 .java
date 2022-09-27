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
            int col = 1;
            int count = row;
            while(col<=row){
                System.out.print(row+col-1+" ");
                count++;
                col++;
            }
            row++;
            System.out.println();
        }
		// WHILE LOOP Second Method 
		System.out.println("Using While Loop Second Method");
         row = 1;
        
        while(row<=n){
            int col = 1;
            int count = row;
            while(col<=row){
                System.out.print(count+" ");
                count++;
                col++;
            }
            row++;
            System.out.println();
        }
		
		// FOR LOOP
		System.out.println("Using For Loop");
         
        for(int i=1;i<=n;i++){
            for(int j = 1 ,count = i;j<=i ;j++,count++){
                System.out.print(count+" ");
            }
            System.out.println();
        }
		
		
	}
}

// 1
// 2 3 
// 3 4 5
// 4 5 6 7

